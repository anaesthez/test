package handler

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.coreDependencies() {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APP_COMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.ANDROIDX_TEST_JUNIT)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)
}

// Libraries

fun DependencyHandler.lifecycle() {
    implementation(Dependencies.VIEWMODEL_LIFECYCLE)
    implementation(Dependencies.VIEWMODEL_LIVEDATA)
    implementation(Dependencies.FRAGMENT_KTX)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.MOSHI)
}

fun DependencyHandler.room() {
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.ROOM_RUNTIME)
    kapt(Dependencies.ROOM_COMPILER)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.NAV_COMPONENTS)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.NAVIGATION_FEATURE)
    implementation(Dependencies.DYNAMIC_FEATURES)
}

fun DependencyHandler.coroutines() {
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.VIEWMODEL_SCOPE)
}

fun DependencyHandler.viewpager() {
    implementation(Dependencies.VIEWPAGER)
}

fun DependencyHandler.glide() {
    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_COMPILER)
}


// Modules

fun DependencyHandler.core() {
    moduleImplementation(Modules.CORE_COMMON)
}

fun DependencyHandler.features() {
    moduleImplementation(Modules.FEATURE_HOTEL)
    moduleImplementation(Modules.FEATURE_BOOKING)
    moduleImplementation(Modules.FEATURE_ROOMS)
    moduleImplementation(Modules.FEATURE_CONFIRMATION)
}

fun DependencyHandler.data() {
    moduleImplementation(Modules.DATA)
}



