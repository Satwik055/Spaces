package com.satwik.spaces.payments.domain.repository

import com.satwik.spaces.payments.domain.model.customers.Customer
import com.satwik.spaces.payments.domain.model.ephemeral_keys.EphemeralKey
import com.satwik.spaces.payments.domain.model.payment_intents.PaymentIntent

interface PaymentsRepository {

    suspend fun getCustomer(): Customer
    suspend fun getEphemeralKey(customerId: String):EphemeralKey
    suspend fun getPaymentIntent(
        customer: String,
        amount: String = "100",
        currency: String = "inr",
        automaticPay:Boolean = true
    ): PaymentIntent
}