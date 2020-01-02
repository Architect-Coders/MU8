object Versions {
    const val minSDK = 21
    const val compileSDK = 29
    const val targetSDK = 29
    const val buildToolsVersion = "29.0.2"
    const val applicationId = "com.architect.coders.mu8"

    const val appVersionCode = 1
    const val appVersionName = "1.0.0"

    internal const val androidGradlePlugin = "3.5.2"
    internal const val kotlin = "1.3.60"
    internal const val coroutines = "1.3.2"
    internal const val support = "1.1.0"
    internal const val constraintLayout = "1.1.3"
    internal const val retrofit = "2.6.2"
    internal const val httpLoggingInterceptorVersion = "4.2.1"
    internal const val detekt = "1.1.1"
    internal const val glide = "4.10.0"
    internal const val junit = "4.12"
    internal const val espresso = "3.2.0"
    internal const val testJunit = "1.1.1"
    internal const val robolectric = "4.3.1"
    internal const val coroutinesTest = "1.2.1"
    internal const val lifecycleVersion = "2.1.0"
    internal const val firebaseAnalytics = "17.2.0"
    internal const val crashlytics = "2.10.1"
    internal const val googleService = "4.3.2"
    internal const val fabricTools = "1.31.2"
    internal const val materialVersion = "1.0.0"
    internal const val cardView = "28.0.0"
    internal const val roomVersion = "2.2.3"
}

object GradleDependencies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
}

object JetPackDependencies {
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
}

object SupportDependencies {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.support}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.support}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.support}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val cardView = "com.android.support:cardview-v7:${Versions.cardView}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"
    const val fabricTools = "io.fabric.tools:gradle:${Versions.fabricTools}"
    const val googleService = "com.google.gms:google-services:${Versions.googleService}"
}

object KotlinDependencies {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object TestDependencies {
    const val junit = "junit:junit:${Versions.junit}"
    const val testJunit = "androidx.test.ext:junit:${Versions.testJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
}

object LibsDependencies {
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val detekt = "io.gitlab.arturbosch.detekt:detekt-cli:${Versions.detekt}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideAnnotation = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.httpLoggingInterceptorVersion}"
    const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
}
