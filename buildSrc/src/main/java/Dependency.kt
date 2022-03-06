object Versions {

    val versionName = "1.0"

    const val VERSION_CODE = 1
    const val COMPILE_SDK = 32
    const val TARGET_SDK = 32
    const val MIN_SDK = 21

    const val KOTLIN = "1.5.31"
    const val ANDROID_GRADLE_PLUGIN = "7.0.0-beta05"
    const val BENCHMARK = "1.0.0"
    const val COMPOSE = "1.0.0-beta04"
    const val FIREBASE_CRASHLYTICS = "2.3.0"
    const val GOOGLE_SERVICES = "4.3.3"
    const val NAVIGATION = "2.3.5"

    const val CORE_KTX = "1.7.0"
    const val ANDROID_APPCOMPAT = "1.4.1"
    const val ANDROID_MATERIAL = "1.5.0"
    const val CONSTRAINT_LAYOUT = "2.1.3"
    const val LIFECYCLE_LIVEDATA_KTX = "2.4.1"
    const val LIFECYCLE_VIEW_MODEL_KTX = "2.4.1"
    const val JUNIT = "4.13"
    const val JUNIT_EXT = "1.1.1"

    const val GSON = "2.9.0"
    const val RETROFIT2 = "2.9.0"
    const val OKHTTP3_LOGGING_INTERCEPTOR = "4.9.3"
    const val RETROFIT2_GSON_CONVERTOR = "2.9.0"

}

object Libs {
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val ANDROID_APPCOMPAT = "androidx.appcompat:appcompat:${Versions.ANDROID_APPCOMPAT}"
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.ANDROID_MATERIAL}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val JUNIT = "junit:junit:4.13:${Versions.JUNIT}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"

    const val LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_LIVEDATA_KTX}"
    const val LIFECYCLE_VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VIEW_MODEL_KTX}"

    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    const val RETROFIT2 = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT2}"
    const val OKHTTP3_LOGGING_INTERCEPTOR ="com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP3_LOGGING_INTERCEPTOR}"
    const val RETROFIT2_GSON_CONVERTOR = "com.squareup.retrofit2:converter-gson:${Versions.OKHTTP3_LOGGING_INTERCEPTOR}"


}