package au.com.outsourcedstaff.calculator.expression.beanshell

import au.com.outsourcedstaff.calculator.expression.ExpressionManager
import bsh.EvalError
import bsh.Interpreter

class BeanshellExpressionManager : ExpressionManager {

    private val interpreter: Interpreter = Interpreter()

    override suspend fun evaluate(expression: String): String {
        try {
            return interpreter.eval("result = $expression").toString()
        } catch (error: EvalError) {
            throw IllegalArgumentException("Invalid expression: $expression")
        }
    }
}