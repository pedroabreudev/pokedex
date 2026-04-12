plugins {
    id("pokedex.android.feature")
}

android {
    namespace = "com.pedroabreudev.pokedex.feature.list"
}

dependencies {
    implementation(project(":core:core-network"))
    implementation(project(":core:core-database"))
    implementation(project(":core:core-common"))
    implementation(project(":core:core-ui"))
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.coil.compose)
    implementation(libs.navigation.compose)
    implementation(libs.paging.runtime)
    implementation(libs.paging.compose)
}