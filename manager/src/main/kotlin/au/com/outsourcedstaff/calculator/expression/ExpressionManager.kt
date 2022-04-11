package au.com.outsourcedstaff.calculator.expression

interface ExpressionManager {

    suspend fun evaluate(expression: String): String
}