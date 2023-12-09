package com.satwik.spaces.payments.domain.use_case

import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.payments.domain.repository.PaymentsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCustomerUseCase @Inject constructor(private val repository: PaymentsRepository) {

    operator fun invoke()=flow{
        val customer = repository.getCustomer()
        try{
            emit(Resource.Success(customer))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred"))
        }
    }
}