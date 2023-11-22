package com.satwik.spaces.properties.domain.use_case.get_property_by_id

import com.google.common.truth.Truth.assertThat
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.properties.data.repository.MockRepository
import com.satwik.spaces.properties.domain.use_case.get_properties_by_type.GetPropertiesByTypeUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPropertyByIdUseCaseTest{

    private lateinit var getPropertyByIdUseCase: GetPropertyByIdUseCase
    private lateinit var repository: MockRepository

    @Before
    fun setup(){
        repository = MockRepository()
        getPropertyByIdUseCase = GetPropertyByIdUseCase(repository)
    }

    @Test
    fun `Invoke with valid propertyId should emit success resource`(){
        runBlocking{
            val propertyId = "1"
            getPropertyByIdUseCase.invoke(propertyId).collect{resource->
                when(resource){
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> assertThat(resource.data?.id.equals(propertyId)).isTrue()
                }
            }
        }
    }

    @Test
    fun `Invoke with invalid propertyId should emit error resource`(){
        runBlocking{
            val propertyId = "111111"
            getPropertyByIdUseCase.invoke(propertyId).collect{resource->
                when(resource){
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> assertThat(resource.data).isNull()
                }
            }
        }
    }
}