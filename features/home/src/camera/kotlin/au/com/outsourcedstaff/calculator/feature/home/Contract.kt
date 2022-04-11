package au.com.outsourcedstaff.calculator.feature.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import java.io.File

class Contract : ActivityResultContract<Void?, Uri>() {

    private val delegate = ActivityResultContracts.TakePicture()
    private lateinit var uri: Uri

    override fun createIntent(context: Context, input: Void?): Intent {
        uri = createUri(context)
        return delegate.createIntent(context, uri)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        val success = delegate.parseResult(resultCode, intent)
        if (success) {
            return uri
        }
        return null
    }

    private fun createUri(context: Context): Uri {
        val tempImageDirectory = File(context.filesDir, context.getString(R.string.temp_image_directory))
        tempImageDirectory.mkdir()
        val tempImage = File(tempImageDirectory, context.getString(R.string.temp_image_file_name))
        return FileProvider.getUriForFile(context, context.getString(R.string.authorities), tempImage)
    }
}