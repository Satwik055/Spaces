package com.satwik.spaces.bookings.domain.use_case

import com.satwik.spaces.bookings.domain.repository.BookingsRepository
import com.satwik.spaces.core.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllBookingsUseCase @Inject constructor(private val bookingsRepository: BookingsRepository){

    operator fun invoke()=flow{
        emit(Resource.Loading())
        try {
            val bookings = bookingsRepository.getAllBookedProperty()
            emit(Resource.Success(bookings))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"Unexpected Error Occurred"))
        }
    }
}