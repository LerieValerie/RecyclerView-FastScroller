import Publish_util_gradle.PublishUtil.declareAndroidModule

plugins {
    id(libs.plugins.comAndroidLibrary)
    id(libs.plugins.kotlinAndroid)
}

declareAndroidModule(Modules.ThirdPartyModules.recycleViewFastScroller)

android {
    compileSdk = Tools.Android.compileSdkVersion
    namespace = "androidx.recyclerview"

    defaultConfig {
        minSdk = Tools.Android.minSdkVersion
        consumerProguardFiles("proguard-rules.pro")
    }

    sourceSets["main"].apply {
        manifest.srcFile("AndroidManifest.xml")
        java.srcDirs("src")
        res.srcDirs("res")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidxCore.core)
    implementation(libs.androidxRecyclerview.recyclerview)

    implementation(moduleDependency(Modules.Core.domain))
}