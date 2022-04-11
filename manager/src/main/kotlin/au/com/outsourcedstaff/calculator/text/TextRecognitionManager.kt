package au.com.outsourcedstaff.calculator.text

interface TextRecognitionManager<T>{

    suspend fun scan(input: T): String
}