plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {

    defaultConfig {
        namespace = Config.applicationId
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        compileSdk = Config.compileSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFile("proguard-rules.pro")
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
        dataBinding = true
    }
}

dependencies {
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Dagger2 ( DI )
    implementation(Libraries.Dagger.androidHilt)
    kapt(Libraries.Dagger.androidHiltCompiler)
    // Dagger2 ( DI ) Android Support
    implementation(Libraries.AndroidX.Hilt.common)
    kapt(Libraries.AndroidX.Hilt.compiler)
    /** etc */
    // CoreLibrary Desugar
    coreLibraryDesugaring(Libraries.desugar)
}