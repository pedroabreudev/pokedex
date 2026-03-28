plugins {
    id("pokedex.android.library")
    id("pokedex.android.compose")
}

android {
    namespace = "com.pedroabreudev.pokedex.core.ui"
}

dependencies {
    implementation(libs.coil.compose)
}