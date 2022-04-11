package au.com.outsourcedstaff.calculator.feature.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class Contract : ActivityResultContract<Void?, Uri>() {

    private val delegate = ActivityResultContracts.GetContent()

    override fun createIntent(context: Context, input: Void?): Intent {
        return delegate.createIntent(context, "image/*")
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        return delegate.parseResult(resultCode, intent)
    }
}