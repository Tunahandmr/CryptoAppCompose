package com.tunahan.cryptojetpack.di

import com.tunahan.cryptojetpack.data.remote.CryptoAPI
import com.tunahan.cryptojetpack.data.repository.CryptoRepositoryImpl
import com.tunahan.cryptojetpack.domain.repository.CryptoRepository
import com.tunahan.cryptojetpack.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCryptoAPI(): CryptoAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(cryptoAPI: CryptoAPI):CryptoRepository{
        return CryptoRepositoryImpl(cryptoAPI)
    }

}