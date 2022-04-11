package au.com.outsourcedstaff.calculator

import android.app.Application
import au.com.outsourcedstaff.calculator.di.component.DaggerCalculatorComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import au.com.outsourcedstaff.calculator.di.module.ApplicationModule
import com.airbnb.mvrx.Mavericks
import javax.inject.Inject

class CalculatorApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
        DaggerCalculatorComponent
                .factory()
                .create(ApplicationModule(this), this)
                .inject(this)
    }
}