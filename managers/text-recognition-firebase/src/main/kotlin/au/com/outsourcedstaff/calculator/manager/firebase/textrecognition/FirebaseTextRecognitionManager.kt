package au.com.outsourcedstaff.calculator.manager.firebase.textrecognition

import android.content.Context
import android.net.Uri
import au.com.outsourcedstaff.calculator.text.TextRecognitionManager
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class FirebaseTextRecognitionManager(private val context: Context) : TextRecognitionManager<Uri> {

    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    override suspend fun scan(input: Uri): String {
        val image = InputImage.fromFilePath(context, input)
        val result = recognizer
            .process(image)
            .await()
        val textBlock = result.textBlocks
        if (textBlock.isEmpty()) {
            throw IllegalArgumentException("No text found")
        }
        return textBlock.first().text
    }
}