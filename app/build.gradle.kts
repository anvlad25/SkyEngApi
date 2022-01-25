plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.example.skyengapi"
        minSdk = 28
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.schemaLocation"] = "$projectDir/schemas"
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        buildFeatures.viewBinding = true
    }
}

dependencies {
    implementation(AndroidDep.coreKtx)
    implementation(AndroidDep.appcompat)
    implementation(AndroidDep.material)
    implementation(AndroidDep.constraintlayout)
    implementation(AndroidDep.lifecycleLivedata)
    implementation(AndroidDep.lifecycleViewmodel)
    testImplementation(AndroidDep.junit)
    androidTestImplementation(AndroidDep.androidxJunit)
    androidTestImplementation(AndroidDep.espressoCore)
    implementation(AndroidDep.coroutinesCore)
    implementation(AndroidDep.coroutinesAndroid)

    //Modules
    implementation(project(Modules.repository))

    //RX
    implementation(RxJava.rxAndroid)
    implementation(RxJava.rxjava)

    //Retrofit
    implementation(Retrofit.loggingInterceptor)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.converterGson)
    implementation(Retrofit.adapterRx)

    //Moxy
    implementation(Moxy.moxy)
    implementation(Moxy.moxyKtx)
    implementation(Moxy.moxyAndroidx)
    kapt(Moxy.moxyCompiler)

    //ViewBinding
    implementation(ViewBindingProp.viewbindingpropertydelegate)

    //Dagger
    implementation(Dagger.dagger)
    implementation(Dagger.daggerAndroid)
    implementation(Dagger.daggerSupport)
    kapt(Dagger.daggerCompiler)
    kapt(Dagger.daggerProcessor)

    //Koin
    implementation(Koin.koin)
    implementation(Koin.koinAndroid)

    //Room
    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)
    implementation(Room.roomKtx)

    //Glide
    implementation(Glide.glide)
    kapt(Glide.glideCompiler)
}