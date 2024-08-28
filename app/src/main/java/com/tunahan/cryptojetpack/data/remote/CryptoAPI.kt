package com.tunahan.cryptojetpack.data.remote

import com.tunahan.cryptojetpack.data.remote.dto.CryptoDto
import com.tunahan.cryptojetpack.util.Constants.API_TOKEN
import com.tunahan.cryptojetpack.util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface CryptoAPI {
    @GET("economy/cripto")
    suspend fun getCrypto(
        @Header("content-type") contentType: String = CONTENT_TYPE,
        @Header("authorization") key: String = API_TOKEN
    ):CryptoDto
}