package com.noteefy.build.configurations

import com.noteefy.build.dependencies.Versions


object ProjectConfigs {
    const val compileSdkVersion = 32
    const val minSdkVersion = 25
    const val targetSdkVersion = 30
    const val applicationId = "com.noteefy"
    const val kotlinCompilerExtensionVersion = Versions.composeCompiler
    const val kotlinKSP = Versions.kotlinKsp
    const val versionCode = 1
    const val versionName = "1.0.0"
}