package br.com.brunohensel.roquebuarque.jobfinder.base

import br.com.brunohensel.roquebuarque.jobfinder.utils.applySchedulers
import io.reactivex.Observable

open class BaseViewModel<State: BaseState>(private val baseState: Observable<State>){

    fun fetchState():Observable<State> =
        baseState.applySchedulers()

}