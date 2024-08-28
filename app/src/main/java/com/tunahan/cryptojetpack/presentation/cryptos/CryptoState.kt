package com.tunahan.cryptojetpack.presentation.cryptos

import com.tunahan.cryptojetpack.domain.model.Crypto

data class CryptoState(
    val isLoading:Boolean = false,
    val crypto: List<Crypto> = emptyList(),
    val error:String =""
)
