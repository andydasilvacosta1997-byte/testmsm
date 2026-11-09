plugins {
 id("com.android.application")
 id("org.jetbrains.kotlin.android")
 id("org.jetbrains.kotlin.plugin.compose")
}
android {
 namespace = "com.example.msmautocollector"
 compileSdk = 35
 defaultConfig { applicationId = "com.example.msmautocollector"; minSdk = 26; targetSdk = 35; versionCode = 1; versionName = "0.2-prototype" }
 buildFeatures { compose = true }
 kotlinOptions { jvmTarget = "17" }
}
dependencies {
 implementation(platform("androidx.compose:compose-bom:2024.12.01"))
 implementation("androidx.activity:activity-compose:1.10.0")
 implementation("androidx.compose.ui:ui")
 implementation("androidx.compose.material3:material3")
 implementation("androidx.compose.foundation:foundation")
}
