package au.com.outsourcedstaff.calculator.di.module

import android.app.Activity
import au.com.outsourcedstaff.calculator.RootActivity
import au.com.outsourcedstaff.calculator.feature.home.HomeFragment
import au.com.outsourcedstaff.calculator.feature.home.di.component.HomeSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        HomeSubComponent::class
    ]
)
abstract class RootModule {

    @Binds
    @IntoMap
    @ClassKey(HomeFragment::class)
    abstract fun bindHomeSubComponentFactory(factory: HomeSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    abstract fun bindActivity(factory: RootActivity): Activity
}