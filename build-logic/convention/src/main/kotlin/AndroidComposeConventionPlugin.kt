import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.android")
            extensions.configure<LibraryExtension> {
                buildFeatures { compose = true }
                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.8"
                }
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation", platform(libs.findLibrary("compose.bom").get()))
                add("implementation", libs.findLibrary("compose.ui").get())
                add("implementation", libs.findLibrary("compose.ui.tooling.preview").get())
                add("implementation", libs.findLibrary("compose.material3").get())
                add("debugImplementation", libs.findLibrary("compose.ui.tooling").get())
            }
        }
    }
}