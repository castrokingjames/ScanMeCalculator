package au.com.outsourcedstaff.calculator.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherManager {

    val main: CoroutineDispatcher

    val io: CoroutineDispatcher
}