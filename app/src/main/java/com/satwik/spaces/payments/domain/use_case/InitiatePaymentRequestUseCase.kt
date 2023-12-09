package com.satwik.spaces.payments.domain.use_case

import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.payments.domain.model.PaymentsApiResponse
import com.satwik.spaces.payments.domain.repository.PaymentsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InitiatePaymentRequestUseCase @Inject constructor(private val repository: PaymentsRepository) {
    operator fun invoke(customerId:String)=flow{
        emit(Resource.Loading())
        val customers = repository.getCustomer()
        val ephemeralKey = repository.getEphemeralKey(customerId)
        val paymentIntent = repository.getPaymentIntent(customerId)
        val apiResponse = PaymentsApiResponse(customers, ephemeralKey, paymentIntent)
        try {
            emit(Resource.Success(apiResponse))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred" ))
        }
    }
}