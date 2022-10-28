package org.nathit.cryptocurrency.domain.model

data class CryptoList(
    val askPrice: String = "",
    val askQty: String = "",
    val bidPrice: String = "",
    val bidQty: String = "",
    val closeTime: Long = 0,
    val count: Int = 0,
    val firstId: Int = 0,
    val highPrice: String = "",
    val lastId: Int = 0,
    val lastPrice: String = "",
    val lastQty: String = "",
    val lowPrice: String = "",
    val openPrice: String = "",
    val openTime: Long = 0,
    val prevClosePrice: String = "",
    val priceChange: String = "",
    val priceChangePercent: String = "",
    val quoteVolume: String = "",
    val symbol: String = "",
    val volume: String = "",
    val weightedAvgPrice: String = ""
)