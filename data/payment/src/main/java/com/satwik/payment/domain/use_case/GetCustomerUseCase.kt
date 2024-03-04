package com.satwik.payment.domain.use_case

import com.satwik.payment.domain.model.customers.Customer
import com.satwik.payment.domain.model.customers.toCustomer
import com.satwik.payment.domain.repository.PaymentsRepository
import javax.inject.Inject

class GetCustomerUseCase @Inject constructor(private val repository: PaymentsRepository) {

    suspend operator fun invoke(): Customer {
        return repository.getCustomer().toCustomer()
    }
}