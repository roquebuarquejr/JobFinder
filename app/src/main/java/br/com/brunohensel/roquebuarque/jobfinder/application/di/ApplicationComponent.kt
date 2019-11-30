package br.com.brunohensel.roquebuarque.jobfinder.application.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{

    fun createActivityComponent (module: ActivityModule): ActivityComponent

    @Component.Factory
    interface Factory {
        fun create (@BindsInstance context: Context): ApplicationComponent
    }
}