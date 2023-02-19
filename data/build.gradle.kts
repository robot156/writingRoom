plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}
android {
    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        compileSdk = Config.compileSdk
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
}

dependencies {
    implementation(project(":domain"))

    // AndroidX Room
    implementation(Libraries.AndroidX.Room.runtime)
    implementation(Libraries.AndroidX.Room.coroutine)
    implementation(Libraries.AndroidX.Room.paging)
    kapt(Libraries.AndroidX.Room.compiler)

    // Moshi
    implementation(Libraries.Moshi.core)
    kapt(Libraries.Moshi.codegen)

    // Retrofit2
    implementation(Libraries.Retrofit2.core)
    implementation(Libraries.Retrofit2.converterMoshi)
    
    // logging interceptor
    implementation(Libraries.OkHttp.logger)
    // Kotlin
    implementation(Libraries.Kotlin.kotlin)
    implementation(Libraries.Kotlin.coroutine)

    // Dagger2 ( DI )
    implementation(Libraries.Dagger.androidHilt)
    kapt(Libraries.Dagger.androidHiltCompiler)

    // ETC
    coreLibraryDesugaring(Libraries.desugar)
    api(Libraries.timber)
}