package com.satwik.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PropertyCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UserCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BookingCollection