package br.com.brunohensel.roquebuarque.jobfinder.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.brunohensel.roquebuarque.jobfinder.application.JobFinderApplication
import br.com.brunohensel.roquebuarque.jobfinder.application.di.ActivityComponent
import br.com.brunohensel.roquebuarque.jobfinder.application.di.ActivityModule
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseActivity<State: BaseState, ViewModel: BaseViewModel<State>> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: ViewModel

    val compositeDisposable by lazy { CompositeDisposable() }
    private var component: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        component = createComponent()
        onInject(this.component!!)
        super.onCreate(savedInstanceState)
    }

    protected abstract fun onInject(component: ActivityComponent)

    private fun createComponent(): ActivityComponent {
        val application = JobFinderApplication::class.java.cast(application)
        val component = application!!.getComponent()
        return component.createActivityComponent(ActivityModule(this))
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }
}