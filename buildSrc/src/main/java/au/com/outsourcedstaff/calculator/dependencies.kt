package au.com.outsourcedstaff.calculator

object Version {

    const val applicationId = "au.com.outsourcedstaff.calculator"
    const val code = 1
    const val name = "0.1"
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
}

object Deps {

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.31"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2"
    }

    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:7.0.3"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.2"

        object Material {
            const val material = "com.google.android.material:material:1.5.0"
        }

        object Navigation {
            private const val version = "2.3.5"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        }
    }

    object Dagger {
        private const val version = "2.40.5"
        const val dagger = "com.google.dagger:dagger:$version"
        const val android = "com.google.dagger:dagger-android:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object Airbnb {

        object Mavericks {
            const val mavericks = "com.airbnb.android:mavericks:2.5.1"
        }
    }

    object Firebase {
        const val textrecognition = "com.google.android.gms:play-services-mlkit-text-recognition:18.0.0"
    }

    object Beanshell {
        const val beanshell = "org.beanshell:bsh-core:2.0b4"
    }
}