package com.satwik.spaces.payments.di

import dagger.Module
import dagger.Provides
import com.satwik.spaces.payments.data.PaymentsRepositoryImpl
import com.satwik.spaces.payments.domain.remote.StripeAPI
import com.satwik.spaces.payments.domain.repository.PaymentsRepository
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object PaymentsModule {

    @Provides
    @Singleton
    fun provideStripeApi(): StripeAPI {
        return Retrofit.Builder()
            .baseUrl("https://api.stripe.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StripeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideStripeAPIRepository(api:StripeAPI):PaymentsRepository{
        return PaymentsRepositoryImpl(api)
    }
}