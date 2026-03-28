import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

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
            dependencies {
                val catalog = extensions
                    .getByType(org.gradle.api.artifacts.VersionCatalogsExtension::class.java)
                    .named("libs")
                add("implementation", platform(catalog.findLibrary("compose.bom").get()))
                add("implementation", catalog.findLibrary("compose.ui").get())
                add("implementation", catalog.findLibrary("compose.ui.tooling.preview").get())
                add("implementation", catalog.findLibrary("compose.material3").get())
                add("debugImplementation", catalog.findLibrary("compose.ui.tooling").get())
            }
        }
    }
}