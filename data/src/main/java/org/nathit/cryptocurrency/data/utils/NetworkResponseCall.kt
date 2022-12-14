package org.nathit.cryptocurrency.data.utils

import com.google.gson.Gson
import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import org.nathit.cryptocurrency.domain.model.NetworkResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

@Suppress("UNCHECKED_CAST")
internal class NetworkResponseCall<S : Any, E : Any>(
    private val delegate: Call<S>,
    private val errorConverter: Converter<ResponseBody, E>
) : Call<NetworkResponse<S, E>> {

    companion object {
        const val RESPONSE_STATUS = "responseStatus"
        const val CODE = "code"
        const val OPERATION = "operation"
        const val MESSAGE = "message"
        const val MESSAGE_TYPE = "messageType"
        const val STATUS = "status"
    }

    override fun enqueue(callback: Callback<NetworkResponse<S, E>>) {
        return delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()

                if (response.isSuccessful) {
                    if (body != null) {
                        /** Response is successful but the responseStatus code success **/
                        callback.onResponse(this@NetworkResponseCall,Response.success(NetworkResponse.Success(body)))

                    } else {
                        /** Response is successful but the body is null **/
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.UnknownError(null))
                        )
                    }
                } else {
                    /** Response not successful **/
                    checkResponseApiError(error, callback, code)
                }
            }

            override fun onFailure(call: Call<S>, throwable: Throwable) {
                val networkResponse = when (throwable) {
                    is IOException -> NetworkResponse.NetworkError(
                        throwable
                    )
                    else -> NetworkResponse.UnknownError(
                        throwable
                    )
                }
                callback.onResponse(this@NetworkResponseCall, Response.success(networkResponse))
            }
        })
    }

    private fun checkResponseStatusError(
        callback: Callback<NetworkResponse<S, E>>,
        responseStatus: org.nathit.cryptocurrency.domain.model.CommonError
    ) {
        callback.onResponse(
            this@NetworkResponseCall,
            Response.success(
                NetworkResponse.ApiError(
                    responseStatus as E,
                    responseStatus.code
                )
            )
        )
    }

    private fun checkResponseApiError(
        error: ResponseBody?,
        callback: Callback<NetworkResponse<S, E>>,
        code: Int
    ) {
        val errorBody = when {
            error == null -> null
            error.contentLength() == 0L -> null
            else -> try {
                errorConverter.convert(error)
            } catch (ex: Exception) {
                null
            }
        }
        if (errorBody != null) {
            callback.onResponse(
                this@NetworkResponseCall,
                Response.success(
                    NetworkResponse.ApiError(
                        errorBody,
                        code.toString()
                    )
                )
            )
        } else {
            callback.onResponse(
                this@NetworkResponseCall,
                Response.success(
                    NetworkResponse.UnknownError(
                        null
                    )
                )
            )
        }
    }

    private fun getStatusCode(body: S): org.nathit.cryptocurrency.domain.model.CommonError {
        val responseStatus = JSONObject(Gson().toJson(body)).getJSONObject(RESPONSE_STATUS)
        return org.nathit.cryptocurrency.domain.model.CommonError(responseStatus.getString(CODE),
            responseStatus.getString(MESSAGE),
            responseStatus.getString(MESSAGE_TYPE),
            responseStatus.getString(OPERATION),
            responseStatus.getString(STATUS))
    }

    override fun isExecuted() = delegate.isExecuted

    override fun clone() =
        NetworkResponseCall(
            delegate.clone(),
            errorConverter
        )

    override fun isCanceled() = delegate.isCanceled

    override fun cancel() = delegate.cancel()

    override fun execute(): Response<NetworkResponse<S, E>> {
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}
