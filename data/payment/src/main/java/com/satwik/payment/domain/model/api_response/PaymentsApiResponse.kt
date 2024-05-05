package com.satwik.payment.domain.model.api_response

import com.satwik.payment.domain.model.customers.Customer
import com.satwik.payment.domain.model.ephemeral_keys.EphemeralKey
import com.satwik.payment.domain.model.payment_intents.PaymentIntent

data class PaymentsApiResponse(
    val customer: Customer,
    var ephemeralKey: EphemeralKey,
    val paymentIntent: PaymentIntent
)
