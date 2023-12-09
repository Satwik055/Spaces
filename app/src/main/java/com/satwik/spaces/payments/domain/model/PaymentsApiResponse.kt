package com.satwik.spaces.payments.domain.model

import com.satwik.spaces.payments.domain.model.customers.Customer
import com.satwik.spaces.payments.domain.model.ephemeral_keys.EphemeralKey
import com.satwik.spaces.payments.domain.model.payment_intents.PaymentIntent

data class PaymentsApiResponse(
    val customer: Customer,
    val ephemeralKey: EphemeralKey,
    val paymentIntent: PaymentIntent
)
