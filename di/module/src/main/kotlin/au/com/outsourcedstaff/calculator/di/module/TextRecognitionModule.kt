package au.com.outsourcedstaff.calculator.di.module

import android.content.Context
import android.net.Uri
import au.com.outsourcedstaff.calculator.di.scope.ForActivity
import au.com.outsourcedstaff.calculator.manager.firebase.textrecognition.FirebaseTextRecognitionManager
import au.com.outsourcedstaff.calculator.text.TextRecognitionManager
import dagger.Module
import dagger.Provides

@Module
class TextRecognitionModule {

    @Provides
    @ForActivity
    fun providesTextRecognitionManager(context: Context): TextRecognitionManager<Uri> {
        return FirebaseTextRecognitionManager(context)
    }
}