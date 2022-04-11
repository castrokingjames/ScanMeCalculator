package au.com.outsourcedstaff.calculator.feature.home

import android.net.Uri
import android.util.Log
import au.com.outsourcedstaff.calculator.dispatcher.DispatcherManager
import au.com.outsourcedstaff.calculator.expression.ExpressionManager
import au.com.outsourcedstaff.calculator.text.TextRecognitionManager
import com.airbnb.mvrx.*
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel @AssistedInject constructor(
    @Assisted private val state: HomeState,
    private val dispatcherManager: DispatcherManager,
    private val textRecognitionManager: TextRecognitionManager<Uri>,
    private val expressionManager: ExpressionManager,
) : MavericksViewModel<HomeState>(state), CoroutineScope {

    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext get() = dispatcherManager.main + job

    init {
        eval("1+1")
    }

    fun load(uri: Uri) {
        setState {
            copy(
                image = Success(uri),
                expression = Uninitialized,
                result = Uninitialized
            )
        }

        scan(uri)
    }

    private fun scan(uri: Uri) {
        val context = CoroutineExceptionHandler { _, exception ->
            setState {
                copy(expression = Fail(exception))
            }
        } + dispatcherManager.io

        launch(context) {
            val expression = textRecognitionManager.scan(uri)
            withContext(dispatcherManager.main) {
                setState {
                    copy(expression = Success(expression))
                }
            }
            eval(expression)
        }
    }

    private fun eval(expression: String) {
        val context = CoroutineExceptionHandler { _, exception ->
            setState {
                copy(result = Fail(exception))
            }
        } + dispatcherManager.io

        launch(context) {
            val result = expressionManager.evaluate(expression)
            withContext(dispatcherManager.main) {
                setState {
                    copy(result = Success(result))
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    @AssistedFactory
    interface Factory {
        fun create(state: HomeState): HomeViewModel
    }

    companion object : MavericksViewModelFactory<HomeViewModel, HomeState> {
        override fun create(viewModelContext: ViewModelContext, state: HomeState): HomeViewModel {
            val fragment: HomeFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.viewModelFactory.create(state)
        }
    }
}