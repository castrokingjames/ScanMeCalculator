package au.com.outsourcedstaff.calculator.di.module

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import au.com.outsourcedstaff.calculator.RootActivity
import au.com.outsourcedstaff.calculator.di.component.RootSubComponent

@Module(
        subcomponents = [
            RootSubComponent::class
        ]
)
abstract class CalculatorModule {

    @Binds
    @IntoMap
    @ClassKey(RootActivity::class)
    abstract fun bindRootActivityInjectorFactory(factory: RootSubComponent.Factory): AndroidInjector.Factory<*>
}