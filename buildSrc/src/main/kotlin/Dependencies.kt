object Versions {
    //RxJava
    const val rxAndroid = "3.0.0"
    const val rxjava = "3.1.3"

    //Retrofit
    const val loggingInterceptor = "5.0.0-alpha.3"
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val adapterRx = "2.9.0"

    //Moxy
    const val moxy = "2.2.2"
    const val moxyKtx = "2.2.2"
    const val moxyAndroidx = "2.2.2"
    const val moxyCompiler = "2.2.2"

    //Dagger
    const val dagger = "2.40.5"
    const val daggerAndroid = "2.40.5"
    const val daggerSupport = "2.40.5"
    const val daggerCompiler = "2.40.5"
    const val daggerProcessor = "2.40.5"

    //Koin
    const val koin = "3.1.5"
    const val koinAndroid = "3.1.5"

    //Room
    const val roomRuntime = "2.4.1"
    const val roomCompiler = "2.4.1"
    const val roomKtx = "2.4.1"

    //Glide
    const val glide = "4.12.0"
    const val glideCompiler = "4.12.0"

    //ViewBinding
    const val viewbindingpropertydelegate = "1.5.6"

    const val coreKtx = "1.7.0"
    const val appcompat = "1.4.1"
    const val material = "1.5.0"
    const val constraintlayout = "2.1.3"
    const val lifecycleLivedata = "2.4.0"
    const val lifecycleViewmodel = "2.4.0"
    const val junit = "4.13.2"
    const val androidxJunit = "1.1.3"
    const val espressoCore = "3.4.0"
    const val coroutinesCore = "1.6.0-native-mt"
    const val coroutinesAndroid = "1.6.0-native-mt"
}

object Modules {
    const val repository = ":repository"
}

object RxJava {
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid}"
    const val rxjava = "io.reactivex.rxjava3:rxjava:${Versions.rxjava}"
}

object Retrofit {
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val adapterRx = "com.squareup.retrofit2:adapter-rxjava3:${Versions.adapterRx}"
}

object Moxy {
    const val moxy = "com.github.moxy-community:moxy:${Versions.moxy}"
    const val moxyKtx = "com.github.moxy-community:moxy-ktx:${Versions.moxyKtx}"
    const val moxyAndroidx = "com.github.moxy-community:moxy-androidx:${Versions.moxyAndroidx}"
    const val moxyCompiler = "com.github.moxy-community:moxy-compiler:${Versions.moxyCompiler}"
}

object Dagger {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerAndroid}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.daggerSupport}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerCompiler}"
    const val daggerProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.daggerProcessor}"
}

object Koin {
    const val koin = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinAndroid}"
}

object Room {
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomRuntime}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomKtx}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideCompiler}"
}

object ViewBindingProp {
    const val viewbindingpropertydelegate =
        "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewbindingpropertydelegate}"
}

object AndroidDep {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val lifecycleLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedata}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewmodel}"
    const val junit = "junit:junit:${Versions.junit}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}