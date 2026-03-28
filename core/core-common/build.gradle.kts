plugins {
    id("pokedex.android.library")
}

android {
    namespace = "com.pedroabreudev.pokedex.core.common"
}

dependencies {
    implementation(libs.coroutines.android)
}