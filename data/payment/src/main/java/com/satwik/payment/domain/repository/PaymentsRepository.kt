package com.satwik.payment.domain.repository

import com.satwik.payment.domain.model.customers.CustomerDto
import com.satwik.payment.domain.model.ephemeral_keys.EphemeralKeyDto
import com.satwik.payment.domain.model.payment_intents.PaymentIntentDto

interface PaymentsRepository {

    suspend fun getCustomer(): CustomerDto
    suspend fun getEphemeralKey(customerId: String): EphemeralKeyDto
    suspend fun getPaymentIntent(
        customer: String,
        amount: String,
        currency: String = "inr",
        automaticPay:Boolean = true
    ): PaymentIntentDto

}