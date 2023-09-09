package handler

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}

fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

fun DependencyHandler.compile(depName: String) {
    add("api", depName)
}
fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

fun DependencyHandler.implementation(dep: Dependency) {
    add("implementation", dep)
}

fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

fun DependencyHandler.moduleImplementation(moduleName: String) {
    implementation(project(mapOf("path" to moduleName)))
}