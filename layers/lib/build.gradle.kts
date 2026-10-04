plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.alejandro.rickandmorty.lib"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    implementation(project(":layers:domain"))
    implementation(project(":layers:data"))
    implementation(project(":layers:presentation"))

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)

}