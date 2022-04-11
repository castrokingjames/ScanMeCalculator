package au.com.outsourcedstaff.calculator.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import au.com.outsourcedstaff.calculator.CalculatorApplication
import au.com.outsourcedstaff.calculator.di.module.ApplicationModule
import au.com.outsourcedstaff.calculator.di.module.CalculatorModule
import au.com.outsourcedstaff.calculator.di.scope.ForApplication
import javax.inject.Singleton

@ForApplication
@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ApplicationModule::class,
            CalculatorModule::class
        ]
)
interface CalculatorComponent : AndroidInjector<CalculatorApplication> {

    @Component.Factory
    interface Factory {

        fun create(module: ApplicationModule, @BindsInstance application: Application): CalculatorComponent
    }

    override fun inject(app: CalculatorApplication)
}