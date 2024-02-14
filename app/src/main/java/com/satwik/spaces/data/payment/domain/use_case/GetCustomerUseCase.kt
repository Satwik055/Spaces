package com.satwik.spaces.data.payment.domain.use_case

import com.satwik.spaces.data.payment.domain.model.customers.Customer
import com.satwik.spaces.data.payment.domain.model.customers.toCustomer
import com.satwik.spaces.data.payment.domain.repository.PaymentsRepository
import javax.inject.Inject

class GetCustomerUseCase @Inject constructor(private val repository: PaymentsRepository) {

    suspend operator fun invoke(): Customer {
        return repository.getCustomer().toCustomer()
    }
}