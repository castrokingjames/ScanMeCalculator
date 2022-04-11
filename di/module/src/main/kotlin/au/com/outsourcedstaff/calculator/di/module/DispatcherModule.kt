package au.com.outsourcedstaff.calculator.di.module

import dagger.Module
import dagger.Provides
import au.com.outsourcedstaff.calculator.di.scope.ForActivity
import au.com.outsourcedstaff.calculator.dispatcher.DispatcherManager
import au.com.outsourcedstaff.calculator.manager.dispatcher.AndroidDispatcherManager

@Module
class DispatcherModule {

    @Provides
    @ForActivity
    fun providesDispatcherManager(): DispatcherManager {
        return AndroidDispatcherManager()
    }
}