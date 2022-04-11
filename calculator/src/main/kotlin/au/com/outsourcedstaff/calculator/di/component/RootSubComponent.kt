package au.com.outsourcedstaff.calculator.di.component

import au.com.outsourcedstaff.calculator.RootActivity
import au.com.outsourcedstaff.calculator.di.module.DispatcherModule
import au.com.outsourcedstaff.calculator.di.module.ExpressionModule
import au.com.outsourcedstaff.calculator.di.module.RootModule
import au.com.outsourcedstaff.calculator.di.module.TextRecognitionModule
import au.com.outsourcedstaff.calculator.di.scope.ForActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForActivity
@Subcomponent(
    modules = [
        RootModule::class,
        DispatcherModule::class,
        TextRecognitionModule::class,
        ExpressionModule::class
    ]
)
interface RootSubComponent : AndroidInjector<RootActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<RootActivity>
}