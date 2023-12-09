package com.satwik.spaces.payments.domain.model.payment_intents

data class AutomaticPaymentMethods(
    val allow_redirects: String,
    val enabled: Boolean
)