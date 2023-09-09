object Dependencies {

    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"

    //Tests
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ANDROIDX_TEST_JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_TEST_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"

    //Hilt
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"

    //Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val MOSHI = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"

    //Room
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM_VERSION}"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM_VERSION}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM_VERSION}"

    //Navigation
    const val NAV_COMPONENTS = "androidx.navigation:navigation-fragment-ktx:${Versions.NAV_VERSION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAV_VERSION}"
    const val NAVIGATION_FEATURE = "androidx.navigation:navigation-ui-ktx:${Versions.NAV_VERSION}"
    const val DYNAMIC_FEATURES = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.FEATURES_VERSION}"

    //lifecycle
    const val VIEWMODEL_LIFECYCLE = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    const val VIEWMODEL_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_VERSION}"

    //Coroutines
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    const val VIEWMODEL_SCOPE = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.SCOPE_VERSION}"

    //Viewpager
    const val VIEWPAGER = "androidx.viewpager2:viewpager2:${Versions.VIEWPAGER_VERSION}"

    //Glide
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE_VERSION}"
}