plugins {
    id("pokedex.android.feature")
}

android {
    namespace = "com.pedroabreudev.pokedex.feature.detail"
}

dependencies {
    implementation(project(":core:core-network"))
    implementation(project(":core:core-database"))
    implementation(project(":core:core-common"))
    implementation(project(":core:core-ui"))
}