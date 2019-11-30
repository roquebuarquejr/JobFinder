package br.com.brunohensel.roquebuarque.jobfinder.application.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (private var activity: AppCompatActivity) {

    @Provides
    internal fun providesContext(): Context {
        return activity
    }
}