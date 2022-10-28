package org.nathit.cryptocurrency.data.model.mapper

import org.nathit.cryptocurrency.data.model.CryptoListEntity
import org.nathit.cryptocurrency.domain.model.CryptoList

class CoinsListMapper : Mapper<ArrayList<CryptoListEntity>, ArrayList<CryptoList>> {

    override fun map(input: ArrayList<CryptoListEntity>): ArrayList<CryptoList> {
        return with(input) {
            getCoinList(this)
        }
    }

    private fun getCoinList(results: ArrayList<CryptoListEntity>): ArrayList<CryptoList> {
        val list = ArrayList<CryptoList>()
        results.map { data ->
            list.add(
                CryptoList(
                    askPrice = data.askPrice ?: "",
                    askQty = data.askQty ?: "",
                    bidPrice = data.bidPrice ?: "",
                    bidQty = data.bidQty ?: "",
                    closeTime = data.closeTime ?: 0,
                    count = data.count ?: 0,
                    firstId = data.firstId ?: 0,
                    highPrice = data.highPrice ?: "",
                    lastId = data.lastId ?: 0,
                    lastPrice = data.lastPrice ?: "",
                    lastQty = data.lastQty ?: "",
                    lowPrice = data.lowPrice ?: "",
                    openPrice = data.openPrice ?: "",
                    openTime = data.openTime ?: 0,
                    prevClosePrice = data.prevClosePrice ?: "",
                    priceChange = data.priceChange ?: "",
                    priceChangePercent = data.priceChangePercent ?: "",
                    quoteVolume = data.quoteVolume ?: "",
                    symbol = data.symbol ?: "",
                    volume = data.volume ?: "",
                    weightedAvgPrice = data.weightedAvgPrice ?: ""

                )
            )
        }
        return list

    }

}