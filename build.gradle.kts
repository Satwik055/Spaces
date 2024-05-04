buildscript {
    dependencies {
        classpath(libs.google.services)
        classpath(libs.gradle)
        classpath ("com.google.gms:google-services:4.4.1")
        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.9.9")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.android.test") version "8.1.1" apply false
    alias(libs.plugins.com.android.library) apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
}