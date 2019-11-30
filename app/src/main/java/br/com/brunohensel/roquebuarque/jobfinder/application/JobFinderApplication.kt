package br.com.brunohensel.roquebuarque.jobfinder.application

import android.app.Application
import br.com.brunohensel.roquebuarque.jobfinder.application.di.ApplicationComponent
import br.com.brunohensel.roquebuarque.jobfinder.application.di.DaggerApplicationComponent

class JobFinderApplication: Application() {

    private var component: ApplicationComponent? = null

    fun getComponent(): ApplicationComponent{

        if (component == null) {
            component = DaggerApplicationComponent.factory().create(this)
        }

        return component as ApplicationComponent
    }
}