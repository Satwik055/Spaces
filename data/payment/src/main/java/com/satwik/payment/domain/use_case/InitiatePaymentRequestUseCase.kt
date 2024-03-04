package com.satwik.payment.domain.use_case

import com.satwik.common.Resource
import com.satwik.payment.domain.model.api_response.PaymentsApiResponse
import com.satwik.payment.domain.model.customers.toCustomer
import com.satwik.payment.domain.model.ephemeral_keys.toEphemeralKey
import com.satwik.payment.domain.model.payment_intents.toPaymentIntent
import com.satwik.payment.domain.repository.PaymentsRepository
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