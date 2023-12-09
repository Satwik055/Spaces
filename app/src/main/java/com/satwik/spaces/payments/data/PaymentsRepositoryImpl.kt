package com.satwik.spaces.payments.data

import com.satwik.spaces.payments.domain.model.customers.Customer
import com.satwik.spaces.payments.domain.model.ephemeral_keys.EphemeralKey
import com.satwik.spaces.payments.domain.model.payment_intents.PaymentIntent
import com.satwik.spaces.payments.domain.remote.StripeAPI
import com.satwik.spaces.payments.domain.repository.PaymentsRepository
import javax.inject.Inject

class PaymentsRepositoryImpl @Inject constructor(private val api:StripeAPI):PaymentsRepository {
    override suspend fun getCustomer(): Customer {
        return api.getCustomer()
    }

    override suspend fun getEphemeralKey(customerId: String): EphemeralKey {
        return api.getEphemeralKey(customerId)
    }

    override suspend fun getPaymentIntent(
        customer: String,
        amount: String,
        currency: String,
        automaticPay: Boolean
    ): PaymentIntent {
        return api.getPaymentIntent(customer,amount,currency,automaticPay)
    }
}