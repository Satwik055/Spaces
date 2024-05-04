package com.satwik.spaces.details.domain.use_case.get_properties_by_type

import com.google.common.truth.Truth.assertThat
import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.core.utils.Resource
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPropertiesByTypeUseCaseTest{

    private lateinit var getPropertiesByTypeUseCase:GetPropertiesByTypeUseCase
    private lateinit var repository: MockRepository

    @Before
    fun setup(){
        repository = MockRepository()
        getPropertiesByTypeUseCase = GetPropertiesByTypeUseCase(repository)
    }

    @Test
    fun `Get a list of properties of given type from firebase database`(){
        runBlocking {
            val propertyType = PropertyType.WORKSPACE
            val result = getPropertiesByTypeUseCase.invoke(propertyType)
            result.collect{resource->
                when(resource){
                    is Resource.Success -> assertThat(resource.data?.first()?.type).isEqualTo(propertyType.name.lowercase())
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                }
            }
        }
    }

    @Test
    fun `Passing a non existing property type throws an error`(){
        runBlocking {
            val propertyType = PropertyType.WORKSPACE
            val result = getPropertiesByTypeUseCase.invoke(propertyType)
            result.onEach{resource->
                when(resource){
                    is Resource.Success -> {}
                    is Resource.Error -> assertThat(resource.data?.first()?.type).isEqualTo(propertyType.name.lowercase())
                    is Resource.Loading -> {}
                }
            }
        }
    }
}