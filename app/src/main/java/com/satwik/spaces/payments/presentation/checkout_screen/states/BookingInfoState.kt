package com.satwik.spaces.payments.presentation.checkout_screen.states

import java.time.LocalDate

data class BookingInfoState(
    val people:String? = null,
    val startDate: String? = null,
    val endDate: String? = null
)
