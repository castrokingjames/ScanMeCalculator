package au.com.outsourcedstaff.calculator.di.module

import au.com.outsourcedstaff.calculator.di.scope.ForActivity
import au.com.outsourcedstaff.calculator.expression.ExpressionManager
import au.com.outsourcedstaff.calculator.expression.beanshell.BeanshellExpressionManager
import au.com.outsourcedstaff.calculator.expression.simple.SimpleExpressionManager
import dagger.Module
import dagger.Provides

@Module
class ExpressionModule {

    @ForActivity
    fun providesSimpleExpressionManager(): ExpressionManager {
        return SimpleExpressionManager()
    }

    @Provides
    @ForActivity
    fun providesBeanshellExpressionManager(): ExpressionManager {
        return BeanshellExpressionManager()
    }
}