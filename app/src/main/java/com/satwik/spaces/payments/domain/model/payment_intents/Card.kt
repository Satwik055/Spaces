package com.satwik.spaces.payments.domain.model.payment_intents

data class Card(
    val installments: Any,
    val mandate_options: Any,
    val network: Any,
    val request_three_d_secure: String
)