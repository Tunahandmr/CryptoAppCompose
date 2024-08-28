package com.tunahan.cryptojetpack.data.repository

import com.tunahan.cryptojetpack.data.remote.CryptoAPI
import com.tunahan.cryptojetpack.data.remote.dto.CryptoDto
import com.tunahan.cryptojetpack.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoAPI: CryptoAPI
): CryptoRepository {
    override suspend fun getCrypto(): CryptoDto {
        return cryptoAPI.getCrypto()
    }
}