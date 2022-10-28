package org.nathit.cryptocurrency.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.nathit.common.ui.base.BaseViewModel
import org.nathit.cryptocurrency.domain.model.CryptoList
import org.nathit.cryptocurrency.domain.model.NetworkResponse
import org.nathit.cryptocurrency.domain.usecase.HomeUseCase
import org.nathit.cryptocurrency.domain.usecase.SecurePreferencesUseCase

class HomeViewModel(
    private val homeUseCase: HomeUseCase,
    private val securePreferencesUseCase: SecurePreferencesUseCase
): BaseViewModel() {

    var coinsListResult = MutableLiveData<ArrayList<CryptoList>>()

    fun getCoinsList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = homeUseCase.getCoinsList()) {
                is NetworkResponse.Success -> {
                    coinsListResult.value = result.body
                }
                is NetworkResponse.ApiError -> {
                    handlerError(result.body)
                }
                is NetworkResponse.NetworkError -> {
                    createOneButtonDialogEvent(messageRes = R.string.Error_Network_title)
                }
                is NetworkResponse.UnknownError -> {
                    createAlertDialogEvent()
                }
                else -> {}
            }
            progressDialogEvent.value = false
        }
    }
}