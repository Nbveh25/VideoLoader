package com.example.common

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineProvider {

    fun main(): CoroutineDispatcher

    fun io(): CoroutineDispatcher

    fun computation(): CoroutineDispatcher
}