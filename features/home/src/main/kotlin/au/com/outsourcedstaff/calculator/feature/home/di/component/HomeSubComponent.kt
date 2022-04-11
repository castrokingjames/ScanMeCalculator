package au.com.outsourcedstaff.calculator.feature.home.di.component

import au.com.outsourcedstaff.calculator.di.scope.ForFragment
import au.com.outsourcedstaff.calculator.feature.home.HomeFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForFragment
@Subcomponent
interface HomeSubComponent : AndroidInjector<HomeFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<HomeFragment>
}