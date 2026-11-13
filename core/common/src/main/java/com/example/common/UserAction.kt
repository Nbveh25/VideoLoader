package com.example.common

fun interface UserAction<A> {

    operator fun invoke(action: A)
}