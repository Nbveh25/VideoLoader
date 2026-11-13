package com.example.common.viewmodel

interface VmFactory {
    fun create(args: Map<String, Any?>): Any
}