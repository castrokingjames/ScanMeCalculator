package au.com.outsourcedstaff.calculator.manager.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import au.com.outsourcedstaff.calculator.dispatcher.DispatcherManager

class AndroidDispatcherManager : DispatcherManager {

    override val main: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
}