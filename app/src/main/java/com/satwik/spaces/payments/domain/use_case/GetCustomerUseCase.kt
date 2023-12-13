package com.satwik.spaces.payments.domain.use_case

import com.satwik.spaces.payments.domain.model.customers.Customer
import com.satwik.spaces.payments.domain.model.customers.CustomerDto
import com.satwik.spaces.payments.domain.model.customers.toCustomer
import com.satwik.spaces.payments.domain.repository.PaymentsRepository
import javax.inject.Inject

class GetCustomerUseCase @Inject constructor(private val repository: PaymentsRepository) {

    suspend operator fun invoke(): Customer {
        return repository.getCustomer().toCustomer()
//        try{
//            emit(Resource.Success(customer))
//        }
//        catch (e:Exception){
//            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred"))
//        }
    }
}