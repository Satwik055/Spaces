package com.satwik.payment.domain.model.customers

data class InvoiceSettings(
    val custom_fields: Any,
    val default_payment_method: Any,
    val footer: Any,
    val rendering_options: Any
)