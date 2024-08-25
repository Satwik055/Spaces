package com.satwik.property.di

import com.satwik.property.data.PropertyRepositoryImpl
import com.satwik.property.domain.remote.SupabaseAPI
import com.satwik.property.domain.repository.PropertyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PropertyModule {

    @Provides
    @Singleton
    fun providesPropertyRepository(
        api: SupabaseAPI
        ): PropertyRepository {
        return PropertyRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSupabaseAPI(retrofit: Retrofit): SupabaseAPI = retrofit.create(SupabaseAPI::class.java)


}