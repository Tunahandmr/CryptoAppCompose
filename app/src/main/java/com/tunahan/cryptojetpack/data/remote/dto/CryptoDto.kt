package com.tunahan.cryptojetpack.data.remote.dto

import com.tunahan.cryptojetpack.domain.model.Crypto

data class CryptoDto(
    val result: List<Result>,
    val success: Boolean
)

fun CryptoDto.toCrypto():List<Crypto>{
    return result.map { result -> Crypto(
        name = result.name,
        pricestr = result.pricestr,
        currency = result.currency,
        code = result.code
    ) }
}