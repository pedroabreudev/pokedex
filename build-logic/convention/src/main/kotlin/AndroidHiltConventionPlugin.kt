import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
                apply("com.google.devtools.ksp")
            }
            dependencies {
                add("implementation", catalogLibrary("hilt.android"))
                add("ksp", catalogLibrary("hilt.compiler"))
            }
        }
    }

    private fun Project.catalogLibrary(alias: String) =
        extensions.getByType(org.gradle.api.artifacts.VersionCatalogsExtension::class.java)
            .named("libs")
            .findLibrary(alias)
            .get()
}