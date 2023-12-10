package com.satwik.spaces.payments.domain.model.ephemeral_keys

data class EphemeralKeyDto(
    val associated_objects: List<AssociatedObject>,
    val created: Int,
    val expires: Int,
    val id: String,
    val livemode: Boolean,
    val `object`: String,
    val secret: String
)

fun EphemeralKeyDto.toEphemeralKey(): EphemeralKey {
    return EphemeralKey(id = id)
}
