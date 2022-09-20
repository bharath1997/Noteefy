import com.noteefy.build.dependencies.*
import com.noteefy.build.configurations.ProjectConfigs

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("com.google.devtools.ksp") version ProjectConfigs.kotlinKSP
}

android {
    namespace = "com.noteefy"
    compileSdk = ProjectConfigs.compileSdkVersion
    viewBinding.isEnabled = true
    dataBinding.isEnabled = true
    androidExtensions {
        isExperimental = true
    }

    defaultConfig {
        applicationId = "com.noteefy"
        minSdk = ProjectConfigs.minSdkVersion
        targetSdk = ProjectConfigs.targetSdkVersion
        versionCode = ProjectConfigs.versionCode
        versionName = ProjectConfigs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
        //  useIR = true
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"

    }
    buildFeatures {
        //dataBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ProjectConfigs.kotlinCompilerExtensionVersion
    }

    lint {
        abortOnError = false
    }
    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

dependencies {
    addKotlinDependencies()
    addDataDependencies()
    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addComposeThirdPartyDependencies()

    addThirdPartyUiDependencies()
    addKspDependencies()

    addCoreAndroidDependencies()
    addCoreAndroidUiDependencies()

    addKotlinTestDependencies()
    addJunit5TestDependencies()
    addThirdPartyUnitTestsDependencies()

    addAndroidInstrumentationTestsDependencies()
}