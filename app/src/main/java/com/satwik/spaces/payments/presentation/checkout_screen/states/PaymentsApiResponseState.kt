package com.satwik.spaces.payments.presentation.checkout_screen.states

import com.satwik.spaces.payments.domain.model.api_response.PaymentsApiResponse

data class PaymentsApiResponseState(
    val data: PaymentsApiResponse? = null,
    val error: String? = null,
    val isLoading:Boolean = false
)
