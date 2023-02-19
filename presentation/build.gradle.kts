plugins {
    id("com.android.library")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        compileSdk = Config.compileSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = Config.javaCompileTarget
        targetCompatibility = Config.javaCompileTarget
    }
    kotlinOptions {
        jvmTarget = Config.javaCompileTarget.toString()
    }

    buildFeatures {
        // DataBinding Apply
        dataBinding = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Libraries.AndroidX.core)
    implementation(Libraries.AndroidX.appcompat)
    implementation(Libraries.AndroidX.design)
    implementation(Libraries.AndroidX.constraint)
    implementation(Libraries.AndroidX.activity)
    implementation(Libraries.AndroidX.fragment)

    // Kotlin
    implementation(Libraries.Kotlin.kotlin)
    implementation(Libraries.Kotlin.coroutine)

    // Dagger2 ( DI )
    implementation(Libraries.Dagger.androidHilt)
    kapt(Libraries.Dagger.androidHiltCompiler)
    // Dagger2 ( DI ) Android Support
    implementation(Libraries.AndroidX.Hilt.common)
    implementation(Libraries.AndroidX.Hilt.navigation)
    kapt(Libraries.AndroidX.Hilt.compiler)

    // Java 8 Desugaring
    coreLibraryDesugaring(Libraries.desugar)

    // Image loading library
    implementation(Libraries.Glide.core)
    kapt(Libraries.Glide.compiler)
}