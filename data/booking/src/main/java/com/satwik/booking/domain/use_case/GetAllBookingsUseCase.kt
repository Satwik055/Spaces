package com.satwik.booking.domain.use_case

import com.satwik.booking.domain.repository.BookingsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllBookingsUseCase @Inject constructor(private val bookingsRepository: BookingsRepository){

    operator fun invoke()=flow{
        emit(com.satwik.common.Resource.Loading())
        try {
            val bookings = bookingsRepository.getAllBookedProperty()
            emit(com.satwik.common.Resource.Success(bookings))
        }
        catch (e:Exception){
            emit(com.satwik.common.Resource.Error(e.localizedMessage?:"Unexpected Error Occurred"))
        }
    }
}