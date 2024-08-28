package com.tunahan.cryptojetpack.domain.repository

import com.tunahan.cryptojetpack.data.remote.dto.CryptoDto

interface CryptoRepository {
    suspend fun getCrypto():CryptoDto
}