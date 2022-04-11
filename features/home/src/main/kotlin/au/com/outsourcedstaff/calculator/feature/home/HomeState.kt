package au.com.outsourcedstaff.calculator.feature.home

import android.net.Uri
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized

data class HomeState(
    val image: Async<Uri> = Uninitialized,
    val expression: Async<String> = Uninitialized,
    val result: Async<String> = Uninitialized,
) : MavericksState