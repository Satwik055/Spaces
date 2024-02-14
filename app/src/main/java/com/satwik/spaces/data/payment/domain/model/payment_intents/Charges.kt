package com.satwik.spaces.data.payment.domain.model.payment_intents

data class Charges(
    val `data`: List<Any>,
    val has_more: Boolean,
    val `object`: String,
    val total_count: Int,
    val url: String
)