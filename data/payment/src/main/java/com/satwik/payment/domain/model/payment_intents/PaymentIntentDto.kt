package com.satwik.payment.domain.model.payment_intents

data class PaymentIntentDto(
    val amount: Int,
    val amount_capturable: Int,
    val amount_details: AmountDetails,
    val amount_received: Int,
    val application: Any,
    val application_fee_amount: Any,
    val automatic_payment_methods: AutomaticPaymentMethods,
    val canceled_at: Any,
    val cancellation_reason: Any,
    val capture_method: String,
    val charges: Charges,
    val client_secret: String,
    val confirmation_method: String,
    val created: Int,
    val currency: String,
    val customer: String,
    val description: Any,
    val id: String,
    val invoice: Any,
    val last_payment_error: Any,
    val latest_charge: Any,
    val livemode: Boolean,
    val metadata: Metadata,
    val next_action: Any,
    val `object`: String,
    val on_behalf_of: Any,
    val payment_method: Any,
    val payment_method_configuration_details: PaymentMethodConfigurationDetails,
    val payment_method_options: PaymentMethodOptions,
    val payment_method_types: List<String>,
    val processing: Any,
    val receipt_email: Any,
    val review: Any,
    val setup_future_usage: Any,
    val shipping: Any,
    val source: Any,
    val statement_descriptor: Any,
    val statement_descriptor_suffix: Any,
    val status: String,
    val transfer_data: Any,
    val transfer_group: Any
)

fun PaymentIntentDto.toPaymentIntent(): PaymentIntent {
    return PaymentIntent(id=  id, client_secret = client_secret)
}