package com.satwik.checkout.presentation.checkout_screen.states

import com.satwik.payment.domain.model.api_response.PaymentsApiResponse

data class PaymentsApiResponseState(
    val data: PaymentsApiResponse? = null,
    val error: String = "",
    val isLoading:Boolean = false
)
