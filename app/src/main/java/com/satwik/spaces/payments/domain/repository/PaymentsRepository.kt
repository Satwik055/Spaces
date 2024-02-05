package com.satwik.spaces.payments.domain.repository

import com.satwik.spaces.payments.domain.model.Booking
import com.satwik.spaces.payments.domain.model.customers.Customer
import com.satwik.spaces.payments.domain.model.customers.CustomerDto
import com.satwik.spaces.payments.domain.model.ephemeral_keys.EphemeralKey
import com.satwik.spaces.payments.domain.model.ephemeral_keys.EphemeralKeyDto
import com.satwik.spaces.payments.domain.model.payment_intents.PaymentIntent
import com.satwik.spaces.payments.domain.model.payment_intents.PaymentIntentDto

interface PaymentsRepository {

    suspend fun getCustomer(): CustomerDto
    suspend fun getEphemeralKey(customerId: String):EphemeralKeyDto
    suspend fun getPaymentIntent(
        customer: String,
        amount: String,
        currency: String = "inr",
        automaticPay:Boolean = true
    ): PaymentIntentDto

}