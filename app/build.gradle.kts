plugins {
    id("com.android.application") version "8.7.1" apply true
    id("org.jetbrains.kotlin.android") version "2.0.21" apply true
}

android {
    namespace = "com.example.beauty911"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.beauty911"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Enable View Binding
    viewBinding {
        enable = true
    }
}

dependencies {
    implementation(libs.appcompat) // Using version catalog alias
    implementation(libs.material) // Using version catalog alias
    implementation(libs.coreKtx) // Using version catalog alias
    implementation(libs.activityKtx) // Using version catalog alias
    implementation(libs.constraintlayout) // Using version catalog alias
    implementation(libs.glide) // Using version catalog alias

    testImplementation(libs.junit) // Using version catalog alias
    androidTestImplementation(libs.extJUnit) // Using version catalog alias
    androidTestImplementation(libs.espressoCore) // Using version catalog alias
}
