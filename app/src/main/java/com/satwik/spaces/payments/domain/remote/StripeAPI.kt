package com.satwik.spaces.payments.domain.remote

import com.satwik.spaces.core.utils.Constants
import com.satwik.spaces.payments.domain.model.customers.Customer
import com.satwik.spaces.payments.domain.model.ephemeral_keys.EphemeralKey
import com.satwik.spaces.payments.domain.model.payment_intents.PaymentIntent
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface StripeAPI {

    @Headers("Authorization: Bearer ${Constants.TEST_KEY}")
    @POST("/v1/customers")
    suspend fun getCustomer(): Customer

    @Headers("Authorization: Bearer ${Constants.TEST_KEY}", "Stripe-Version: 2020-08-27")
    @POST("/v1/ephemeral_keys")
    suspend fun getEphemeralKey(
        @Query("customer") customerId: String
    ): EphemeralKey

    @Headers("Authorization: Bearer ${Constants.TEST_KEY}")
    @POST("/v1/payment_intents")
    suspend fun getPaymentIntent(
        @Query("customer") customer: String,
        @Query("amount") amount: String,
        @Query("currency") currency: String,
        @Query("automatic_payment_methods[enabled]") automaticPay:Boolean
    ): PaymentIntent
}