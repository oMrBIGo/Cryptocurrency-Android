package org.nathit.cryptocurrency.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.nathit.cryptocurrency.domain.model.CryptoList
import org.nathit.cryptocurrency.home.R
import org.nathit.cryptocurrency.home.databinding.ItemCryptoListBinding
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

class CryptoListAdapter(
    private val context: Context,
    private val result: ArrayList<CryptoList>,
) : RecyclerView.Adapter<CryptoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_crypto_list,
                    parent,
                    false
                )
            )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return result.size ?: 0
    }

    inner class ViewHolder(private val binding: ItemCryptoListBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(
                position: Int,
            ) {
                binding.model = result[position]
                binding.txvVolList.text = prettyCount(result[position].volume)
                if (result[position].volume == "0.00000000") {
                    binding.root.visibility = View.GONE
                    binding.root.layoutParams = RecyclerView.LayoutParams(0,0)
                }
                binding.txvLastQtyList.text = priceCount(result[position].lastQty)
                binding.txvLastPriceList.text = context.getString(R.string.price_usb,priceCount(result[position].lastPrice))
                binding.executePendingBindings()
            }

        private fun prettyCount(number: String): String? {
            val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
            val numValue = number.toDouble()
            val value = floor(log10(numValue)).toInt()
            val base = value / 3
            return if (value >= 3 && base < suffix.size) {
                DecimalFormat("#0.0").format(numValue / 10.0.pow((base * 3).toDouble())) + suffix[base]
            } else {
                DecimalFormat("#,##0").format(numValue)
            }
        }

        private fun priceCount(number: String): String? {
            val numValue = number.toDouble()
            val value = floor(log10(numValue)).toInt()
            return if (value >= 3) {
                DecimalFormat("#0.0").format(numValue)
            } else {
                DecimalFormat("#,##0").format(numValue)
            }
        }
    }
}