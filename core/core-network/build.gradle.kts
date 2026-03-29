plugins {
    id("pokedex.android.library")
    id("pokedex.android.hilt")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.pedroabreudev.pokedex.core.network"
}

dependencies {
    implementation(project(":core:core-common"))
    implementation(libs.bundles.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.coroutines.android)
}