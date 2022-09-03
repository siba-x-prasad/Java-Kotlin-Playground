package com.swasi.play.coroutines.scope

import kotlinx.coroutines.*

/**
 * Coroutine Scope
 *
 * In view of Coroutine Context can be a bunch of context elements,
 * to better manage them, it is wrapped around Coroutine Scope.
 *
Other than just wrapping around the context, the Coroutine Scope also keeps track of all its children's scopes.
e.g. when perform a launch within another scope, a child scope is created automatically.
It provides all the utilities to launch, async, and also cancel etc…
In another word, it’s the main interface to the developer for managing coroutines.

I’ll have to use runBlocking before I can do any launch. This is because launch can only be triggered from CoroutineScope.

What are the scopes we have?

GlobalScope —
    If you just want to have a simple launch without worrying about managing it,
    we can use GlobalScope.launch { }.
    However, this is not ideal, as per this article.

MainScope —
    This will launch the coroutine in the main thread (UI thread) by default when using MainScope().launch { }.

CoroutineScope —
    This allows you to define a custom scope by providing your own context e.g. CoroutineScope(Dispatchers.IO).launch {  }.

LifecycleScope —
    This is an Android-specific coroutine scope that ties the scope Android lifecycle
    (i.e. ability to automatically terminate upon end of Android Activity lifecycle.

 *
 */

fun main() {
    scopeDet()
}

fun scopeDet() {
    GlobalScope.launch {
        println("Inside Global Scope")
    }

    MainScope().launch {
        println("Inside MainScope which run inside Main Thread")
    }

    CoroutineScope(Dispatchers.Main).launch{
        println("Inside CoroutineScope Which run under Dispatchers.Main")
    }
}