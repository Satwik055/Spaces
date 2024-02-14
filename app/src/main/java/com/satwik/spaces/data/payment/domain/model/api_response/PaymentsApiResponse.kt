package com.satwik.spaces.data.payment.domain.model.api_response

import com.satwik.spaces.data.payment.domain.model.customers.Customer
import com.satwik.spaces.data.payment.domain.model.ephemeral_keys.EphemeralKey
import com.satwik.spaces.data.payment.domain.model.payment_intents.PaymentIntent

data class PaymentsApiResponse(
    val customer: Customer,
    val ephemeralKey: EphemeralKey,
    val paymentIntent: PaymentIntent
)
