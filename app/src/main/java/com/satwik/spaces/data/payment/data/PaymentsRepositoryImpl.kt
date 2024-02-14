package com.satwik.spaces.data.payment.data

import com.satwik.spaces.data.payment.domain.model.customers.CustomerDto
import com.satwik.spaces.data.payment.domain.model.ephemeral_keys.EphemeralKeyDto
import com.satwik.spaces.data.payment.domain.model.payment_intents.PaymentIntentDto
import com.satwik.spaces.data.payment.domain.remote.StripeAPI
import com.satwik.spaces.data.payment.domain.repository.PaymentsRepository
import javax.inject.Inject

class PaymentsRepositoryImpl @Inject constructor(
    private val api: StripeAPI,
): PaymentsRepository {
    override suspend fun getCustomer(): CustomerDto {
        return api.getCustomer()
    }

    override suspend fun getEphemeralKey(customerId: String): EphemeralKeyDto {
        return api.getEphemeralKey(customerId)
    }

    override suspend fun getPaymentIntent(
        customer: String,
        amount: String,
        currency: String,
        automaticPay: Boolean
    ): PaymentIntentDto {
        return api.getPaymentIntent(customer,amount,currency,automaticPay)
    }
}