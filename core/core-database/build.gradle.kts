plugins {
    id("pokedex.android.library")
    id("pokedex.android.hilt")
}

android {
    namespace = "com.pedroabreudev.pokedex.core.database"
}

dependencies {
    implementation(libs.bundles.room)
    ksp(libs.room.compiler)
}