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

        // Enable Multidex
        multiDexEnabled = true
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
        enable = true // Corrected line to enable View Binding
    }
}

dependencies {
    // Using version catalog for these dependencies
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.coreKtx)
    implementation(libs.activityKtx)
    implementation(libs.constraintlayout)
    implementation(libs.glide)

    // Firebase dependencies
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
    implementation("com.google.firebase:firebase-database-ktx")
    implementation("com.google.firebase:firebase-core")

    // Multidex dependency
    implementation("androidx.multidex:multidex:2.0.1")

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.extJUnit)
    androidTestImplementation(libs.espressoCore)
}
