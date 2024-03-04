package com.satwik.payment.domain.remote

import com.satwik.common.Constants
import com.satwik.payment.domain.model.customers.CustomerDto
import com.satwik.payment.domain.model.ephemeral_keys.EphemeralKeyDto
import com.satwik.payment.domain.model.payment_intents.PaymentIntentDto
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface StripeAPI {

    @Headers("Authorization: Bearer ${Constants.TEST_KEY}")
    @POST("/v1/customers")
    suspend fun getCustomer(): CustomerDto

    @Headers("Authorization: Bearer ${Constants.TEST_KEY}", "Stripe-Version: 2020-08-27")
    @POST("/v1/ephemeral_keys")
    suspend fun getEphemeralKey(
        @Query("customer") customerId: String
    ): EphemeralKeyDto

    @Headers("Authorization: Bearer ${Constants.TEST_KEY}")
    @POST("/v1/payment_intents")
    suspend fun getPaymentIntent(
        @Query("customer") customer: String,
        @Query("amount") amount: String,
        @Query("currency") currency: String,
        @Query("automatic_payment_methods[enabled]") automaticPay:Boolean
    ): PaymentIntentDto
}