package com.satwik.spaces.payments.domain.use_case

import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.payments.domain.model.api_response.PaymentsApiResponse
import com.satwik.spaces.payments.domain.model.customers.toCustomer
import com.satwik.spaces.payments.domain.model.ephemeral_keys.toEphemeralKey
import com.satwik.spaces.payments.domain.model.payment_intents.toPaymentIntent
import com.satwik.spaces.payments.domain.repository.PaymentsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InitiatePaymentRequestUseCase @Inject constructor(private val repository: PaymentsRepository) {
    operator fun invoke(customerId:String, amount:String)=flow{
        val customers = repository.getCustomer().toCustomer()
        val ephemeralKey = repository.getEphemeralKey(customerId).toEphemeralKey()
        val paymentIntent = repository.getPaymentIntent(customerId, amount).toPaymentIntent()
        val apiResponse = PaymentsApiResponse(customers, ephemeralKey, paymentIntent)
        try {
            emit(Resource.Success(apiResponse))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred" ))
        }
    }
}