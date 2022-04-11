# Scan me! calculator
[![CircleCI](https://circleci.com/gh/castrokingjames/ScanMeCalculator.svg?style=svg)](https://circleci.com/gh/castrokingjames/ScanMeCalculator)

Simple image to result calculator.

Libraries Used
--------------
* [Foundation][0] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
  * [AppCompat][1] - Degrade gracefully on older versions of Android.
  * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
  * [Material Components][3] - Modular and customizable Material Design UI components
* [Architecture][10] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [View Binding][11] - Declaratively bind observable data to UI elements.
  * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
  * [Navigation][14] - Handle everything needed for in-app navigation.
  * [ViewModel][17] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
  * [Fragment][34] - A basic unit of composable UI.
  * [Layout][35] - Lay out widgets using different algorithms.
* Third party and miscellaneous libraries
  * [Mavericks][99] - Android MVI framework 
  * [Dagger][92] - for [dependency injection][93]
  * [Kotlin Coroutines][91] - for managing background threads with simplified code and reducing needs for callbacks
  * [Firebase MLKit Text Recognition][44] - For text cognition
  * [Beanshell][43] - For arithmetic evaluator

[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[3]: https://github.com/material-components/material-components-android
[10]: https://developer.android.com/jetpack/arch/
[11]: https://developer.android.com/topic/libraries/view-binding
[12]: https://developer.android.com/topic/libraries/architecture/lifecycle
[13]: https://developer.android.com/topic/libraries/architecture/livedata
[14]: https://developer.android.com/topic/libraries/architecture/navigation/
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel
[30]: https://developer.android.com/guide/topics/ui
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout
[91]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[92]: https://developer.android.com/training/dependency-injection/dagger-android
[93]: https://developer.android.com/training/dependency-injection
[99]: https://github.com/airbnb/mavericks
[44]: https://firebase.google.com/docs/ml-kit/recognize-text
[43]: https://beanshell.github.io