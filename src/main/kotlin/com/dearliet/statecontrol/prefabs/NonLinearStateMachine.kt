package com.dearliet.statecontrol.prefabs

import com.dearliet.statecontrol.prefabs.BaseState.StateMachine

/**
 * [NonLinearStateMachine] is a concrete implementation of [StateMachine] that allows for traversing through a set of states in a non-linear fashion.
 *
 * @param owner The unique object that owns the state machine structure
 * @param parentStateMachine The parent [StateMachine] of this instance.
 */
abstract class NonLinearStateMachine<T : Any, E: Enum<E>>(owner: T, parentStateMachine: StateMachine<T, *>? = null)
    : StateMachine<T, E>(owner, parentStateMachine) {

    /**
     * A [LinkedHashMap] that holds the state constructors or factories.
     */
    abstract override val initStates: LinkedHashMap<E, () -> BaseState<T>>

    override val stateFactory: LinkedHashMap<E, () -> BaseState<T>>
        get() = initStates

    /**
     * Transitions to the [BaseState] represented by [stateKey].
     * @param stateKey The key of the [BaseState] to transition to.
     * @throws IllegalArgumentException if the provided [stateKey] is invalid.
     */
    fun goto(stateKey: E){
        transitionTo(stateKey)
    }
}