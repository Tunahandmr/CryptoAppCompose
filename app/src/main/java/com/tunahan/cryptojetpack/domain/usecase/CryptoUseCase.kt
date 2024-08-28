package com.tunahan.cryptojetpack.domain.usecase

import com.tunahan.cryptojetpack.data.remote.dto.toCrypto
import com.tunahan.cryptojetpack.domain.model.Crypto
import com.tunahan.cryptojetpack.domain.repository.CryptoRepository
import com.tunahan.cryptojetpack.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptoUseCase @Inject constructor(
    private val cryptoRepository: CryptoRepository
) {
    fun getCrypto(): Flow<Resource<List<Crypto>>> = flow {
        try {
            emit(Resource.Loading())
            val crypto = cryptoRepository.getCrypto()
            if (crypto.success) {
                emit(Resource.Success(crypto.toCrypto()))
            } else {
                emit(Resource.Error("No crypto found!"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}