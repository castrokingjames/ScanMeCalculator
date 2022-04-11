package au.com.outsourcedstaff.calculator.expression.simple

import au.com.outsourcedstaff.calculator.expression.ExpressionManager

class SimpleExpressionManager : ExpressionManager {

    override suspend fun evaluate(expression: String): String {
        if (expression.contains(Regex("[0-9]([+*-/])[0-9]"))) {
            val numbers = expression.split(Regex("([+*-/])"))
            if (numbers.size == 2) {
                val a = numbers[0].toInt()
                val b = numbers[1].toInt()

                return when {
                    expression.contains("+") -> {
                        "${a + b}"
                    }
                    expression.contains("-") -> {
                        "${a - b}"
                    }
                    expression.contains("*") -> {
                        "${a * b}"
                    }
                    expression.contains("/") -> {
                        "${a / b}"
                    }
                    else -> {
                        throw IllegalArgumentException("Invalid operation: $expression")
                    }
                }
            } else {
                throw IllegalArgumentException("Invalid expression: $numbers")
            }
        }
        throw IllegalArgumentException("Invalid expression: $expression")
    }
}