package br.com.brunohensel.roquebuarque.jobfinder.application.di

import android.content.Context
import br.com.brunohensel.roquebuarque.jobfinder.application.JobFinderApplication
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule {

    @Provides
    fun provideApplicationContext(app: JobFinderApplication): Context {
        return app.applicationContext
    }
}