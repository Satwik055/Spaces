@file:Suppress("KOTLIN_SCOPE_VIOLATION")
plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp") version "1.8.10-1.0.9"
    id("com.google.firebase.crashlytics")
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

android {
    namespace = "com.satwik.spaces"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.satwik.spaces"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("benchmark") {
            initWith(buildTypes.getByName("release"))
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

//    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.analytics.ktx)
    implementation(libs.firebase.firestore)

    testImplementation(libs.bundles.local.unit.test)

    implementation(libs.coil)

    implementation(libs.navigation.compose)

    implementation(libs.bundles.hilt)
    kapt(libs.bundles.hilt.compiler)

    implementation(libs.bundles.coroutines)

    implementation(libs.bundles.maxkeppeler.calender)
    implementation (libs.androidx.core.splashscreen)
    implementation(libs.stevdza.onetapsignin)
    implementation(libs.bundles.retrofit)
    implementation (libs.stripe)
    implementation(libs.lottie.compose)
    implementation (libs.androidx.datastore.preferences)

    // Instrumentation tests
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.junit4)
    debugImplementation(libs.compose.tooling)
    debugImplementation(libs.compose.test.manifest)

    implementation(project(":features:booking"))
    implementation(project(":features:explore"))
    implementation(project(":features:auth"))
    implementation(project(":features:detail"))
    implementation(project(":features:location"))
    implementation(project(":features:checkout"))
    implementation(project(":features:search"))


    implementation(project(":data:auth"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:common"))







}