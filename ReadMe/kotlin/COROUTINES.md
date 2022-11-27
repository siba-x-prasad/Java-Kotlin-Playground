# COROUTINES

**Important Links**

- https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html
- https://blog.mindorks.com/mastering-kotlin-coroutines-in-android-step-by-step-guide
- https://blog.mindorks.com/what-are-coroutines-in-kotlin-bf4fecd476e9
- https://kotlinlang.org/docs/tutorials/coroutines/coroutines-com.swasi.play.basic-jvm.html
- https://www.raywenderlich.com/1423941-kotlin-coroutines-tutorial-for-android-getting-started
- **EXAMPLES**
- https://github.com/dmytrodanylyk/coroutine-recipes.git
- https://github.com/amanjeetsingh150/kotlin-android-examples/tree/master/KotlinCoroutines
- https://github.com/wellingtoncosta/android-kotlin-coroutines
- **KOTLIN EXAMPLE**
- https://github.com/amanjeetsingh150/kotlin-android-examples
- **Coroutines Example Links**
- https://medium.com/@elye.project/understanding-suspend-com.swasi.play.function-of-coroutines-de26b070c5ed

## Official Documentation with example

- [Coroutine Basics](https://kotlinlang.org/docs/reference/coroutines/basics.html)
- [Cancellation and Timeout](https://kotlinlang.org/docs/reference/coroutines/cancellation-and-timeouts.html)
- [Composing/Adding Coroutines](https://kotlinlang.org/docs/reference/coroutines/composing-suspending-functions.html)
- [Coroutine Context & Dispatcher](https://kotlinlang.org/docs/reference/coroutines/coroutine-context-and-dispatchers.html)
- [Asynchronous Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html)
- [Channels](https://kotlinlang.org/docs/reference/coroutines/channels.html)
- [Exception handling & Supervision](https://kotlinlang.org/docs/reference/coroutines/exception-handling.html)
- [Shared mutable state and concurrency](https://kotlinlang.org/docs/reference/coroutines/shared-mutable-state-and-concurrency.html)
- [Select Expression(Experimantal)](https://kotlinlang.org/docs/reference/coroutines/select-expression.html)
- [EXAMPLE](https://github.com/Kotlin/kotlinx.coroutines/tree/master/kotlinx-coroutines-core/jvm/test/guide)

## [Async Programming](https://github.com/siba-x-prasad/Java-Kotlin-Playground/blob/main/ReadMe/kotlin/7.asynchronousProgramming.md)

## [Coroutine Setup](https://github.com/siba-x-prasad/Java-Kotlin-Playground/blob/main/ReadMe/kotlin/7.coroutineSetup.md)

## What is Coroutines ?

- **Co+Routines = Coroutines**
- Co - Cooperation
- Routines - Functions
- When functions cooperate with each other to execute known as **COROUTINES**.
- Coroutine is used to achieve asynchronous programming with using the cpu idle state.
- We can run multiple methods at the same time with the help of Coroutines.

## Coroutines and Threads

- Both are doing multitasking but Thread is handled by the system/os and the coroutines is handled
  by the User as it can execute a few lines of function by taking advantage of the cooperation.
- It's an optimized framework written over the actual threading by taking advantage of the
  cooperative nature of functions to make it light and yet powerful.
- So, we can say that Coroutines are lightweight threads.
- A lightweight thread means it does not map on the native thread, so it does not require context
  switching on the processor, so they are faster.
- Coroutines are available in many languages. It is of 2 types
  -
        1. Stack less
    -
        2. Stack full

- Kotlin implements stackless coroutines — it’s mean that the coroutines don’t have own stack, so
  they don’t map on the native thread.

## NOTE

- One can think of a coroutine as a light-weight thread.
- Like threads, coroutines can run in parallel, wait for each other and communicate.
- The biggest difference is that coroutines are very cheap, almost free: we can create thousands of
  them, and pay very little in terms of performance.
- True threads, on the other hand, are expensive to start and keep around. A thousand threads can be
  a serious challenge for a modern machine.**
- They are lightweight because creating coroutines does not allocate new threads.
- Instead, they use predefined thread pools, and smart scheduling.
- Scheduling is the process of determining which piece of work you will execute next.
- Just like a regular schedule.
- **NOTE:** Additionally, coroutines can be suspended and resumed mid-execution.
- This means you can have a long-running task, which you can execute little-by-little.
- You can pause it any number of times, and resume it when you’re ready again.
- Knowing this, creating a large number of Kotlin Coroutines won’t bring unnecessary memory overhead
  to your program.
- You’ll just suspend some of them until the thread pool frees up.

## Thread Pool

- Thread pool represents a group of worker threads that are waiting for the job and reused many
  times.
- In the case of a thread pool, a group of fixed-size threads is created.
- A thread from the thread pool is pulled out and assigned a job by the service provider.

## Definition of Coroutines :

- A framework to manage concurrency in a more performant and simple way with its lightweight thread
  which is written on top of the actual threading framework to get the most out of it by taking the
  advantage of cooperative nature of functions.
- kotlinx.coroutine is a rich library for coroutines developed by JetBrains.
- It contains a number of high-level coroutine-enabled primitives that this guide covers, including
  launch, async and others.
- https://kotlinlang.org/docs/reference/coroutines/basics.html

## Where we can use Coroutines

- Let's take a simple example where we can
    - 1.Fetch User from the server.
    - 2.Show the User in the UI.
- When we will do any N/W operation in main thread it will show exception network on main thread. To
  avoid that we can use use the below solutions
    -
        1. Call Back
    -
        2. Rx Java
    -
        3. Coroutines

## Basics Of Coroutines

- coroutines are light-weight threads
- Thread is controlled by OS but coroutines controlled by user.
- They are launched with launch coroutine builder in a context of some CoroutineScope.
- **GlobalScope.launch {}** we are launching a new coroutine in the GlobalScope, meaning that the
  lifetime of the new coroutine is limited only by the lifetime of the whole application.
- **NOTE** Suspend functions are only allowed to be called from a coroutine or another suspend
  function

```
fun main() {
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello,") // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}
```

- OUT PUT of above code

```
    Hello 
    World
```

- What is global Scope ?
- Global scope is used to launch top-level coroutines that operate during the whole application
  lifetime and are not canceled prematurely.
- GlobalScope.launch{ } - This code inside these bracket run after 1 second, its non-blocking thread

```
fun main() { 
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
    println("Hello,") // main thread continues here immediately
    runBlocking {     // but this expression blocks the main thread
        delay(5000L)  // ... while we delay for 2 seconds to keep JVM alive
    }
    print("Siba")
}
```

- **runBlocking** is block the execution for 5 seconds above, after 5 second, siba will print in the
  above code snippet.
- **GlobalScope.launch** is used to create coroutines in background

```
GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
```

-

```
  suspend fun fetchAndShowUser() {  
     val user = fetchUser() // fetch on IO thread  
     showUser(user) // back on UI thread  
  }
```  

- Here, the above code looks synchronous, but it is asynchronous. We will see how is it possible.

## How to implement coroutines

- Add Dependency

 ```
 dependencies {  
  implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:x.x.x"  
  implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:x.x.x"  
}
 ```

- Now,our function fetchUser() will look like below:

```
suspend fun fetchUser(): User {  
    return GlobalScope.async(Dispatchers.IO) {  
        // make network call  
        // return user  
    }.await()  
}     
```

## Let's Discuss the main keywords used above

- **launch** is a coroutine builder.
- It launches a new coroutine concurrently with the rest of the code, which continues to work
  independently.
- That's why Hello has been printed first.

- **delay** is a special suspending function.
- It suspends the coroutine for a specific time.
- Suspending a coroutine does not block the underlying thread, but allows other coroutines to run
  and use the underlying thread for their code.

## Thread.Sleep Vs delay

- https://stackoverflow.com/questions/61345712/what-is-the-difference-between-delay-and-thread-sleep-in-kotlin#:~:text=with%20a%20thousand.-,The%20Thread.,calls%20blocking%20the%20coroutine%20threads
  .
- **runBlocking** is also a coroutine builder that bridges the non-coroutine world of a regular fun
  main() and
- the code with coroutines inside of runBlocking { ... } curly braces.
- This is highlighted in an IDE by this: CoroutineScope hint right after the runBlocking opening
  curly brace.
- If you remove or forget runBlocking in this code, you'll get an error on the launch call, since
  launch is declared only in the CoroutineScope:

# The main keywords in Coroutines

## Suspending functions:

- This kind of function can be suspended without blocking the current thread.
- Instead of returning a simple value, it also knows in which context the caller suspended it.
- Using this, it can resume appropriately, when ready.
- suspend function that could be started, paused and resume.
-

## CoroutineBuilders

- These take a suspending lambda as an argument to create a coroutine.
- There are a bunch of coroutine builders provided by Kotlin Coroutines, including async(), launch()
  , runBlocking.

## CoroutineScope

- Helps to define the lifecycle of Kotlin Coroutines.
- It can be application-wide or bound to a component like the Android Activity.
- You have to use a scope to start a coroutine.
- A CoroutineScope defines a lifecycle, a lifetime, for Coroutines that are built and launched from
  it.
- A CoroutineScope lifecycle starts as soon as it is created and ends when it is canceled or when it
  associated Job or SupervisorJob finishes.
- When that happens, the CoroutineScope is no longer active.

```
val scope: CoroutineScope = ...
...
scope.launch {
    while(true) { 
        ...
        delay(100)
    }
}
...
scope.cancel() 
```

- https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-coroutine-scope/
- https://medium.com/swlh/how-can-we-use-coroutinescopes-in-kotlin-2210695f0e89
-

## CoroutineDispatcher

- Defines thread pools to launch your Kotlin Coroutines in.
- This could be the background thread pool, main thread or even your custom thread pool. You’ll use
  this to switch between, and return results from, threads.
- Dispatcher's helps coroutines in deciding the thread on which the work has to be done.
- There are majorly three types of Dispatchers which are as **IO, Default, and Main**.
- **IO dispatcher** is used to do the network and disk related work.
- **Default** is used to do the CPU intensive work.
- **Main** is the UI thread of Android. In order to use these, we need to wrap the work under the
  async

## Coroutine Context

- Coroutines always execute in some context represented by a value of the CoroutineContext type,
  defined in the Kotlin standard library.
- The coroutine context is a set of various elements.
- Job
- Dispatcher
- **GlobalScope**
    - globalscope
- **async()**
    - async
- **launch()**
    - launch
- **await**
    - await
- **Dispatchers**

  -**.Scopes**
    - it is used to cancel the background task as soon as the activity got destroyed.
- **withContext()**
    - withContext is nothing but a way writing the async where we do not have to write await().

## Using Dispatchers With Kotlin Coroutines

- You can execute a coroutine using different CoroutineDispatchers, as mentioned before. Some of the
  available CoroutineDispatchers in the API are: Dispatchers.Main, Dispatchers.IO and
  Dispatchers.Default.
- You can use these dispatchers for the following use cases:

**Dispatchers.Default:** CPU-intensive work, such as sorting large lists, doing complex calculations
and similar. A shared pool of threads on the JVM backs it.  
**Dispatchers.IO:** networking or reading and writing from files. In short – any input and output,
as the name states  
**Dispatchers.Main**: recommended dispatcher for performing UI-related events. For example, showing
lists in a RecyclerView, updating Views and so on.

You’ll use some of these dispatchers to switch between the main and background threads. One last
step before you can launch coroutines – defining a CoroutineScope.

**NOTE-** Suspend functions are only allowed to be called from a coroutine or another suspend
com.swasi.play.function. You can see that the async com.swasi.play.function which includes the
keyword suspend. So, in order to use that, we need to make our com.swasi.play.function suspend too.

```
  GlobalScope.launch(Dispatchers.Main) {  
    fetchAndShowUser()  
  }  
```   

- Actually the above code is as below if we simplify the code

```
GlobalScope.launch(Dispatchers.Main) {  
   val user = fetchUser() // fetch on IO thread  
   showUser(user)         // back on UI thread  
}       
```

- Here **fetchAndShowUser()** is a suspend com.swasi.play.function where we do the network operation
  and after getting the result we delever the result in the main thread.
- showUser will run on UI thread because we have used the Dispatchers.Main to launch it.

There are two functions in Kotlin to start the coroutines which are as follows:

**1. launch{}

2. async{}**

**Launch vs Async in Kotlin Coroutines**

The difference is that the launch{} does not return anything and the async{}returns an instance of
Deferred<T>, which has an await()com.swasi.play.function that returns the result of the coroutine
like we have future in Java in which we do future.get() to the get the result.

```
fun fetchUserAndSaveInDatabase() {  
    // fetch user from network  
    // save user in database  
    // and do not return anything  
}  
```

- Now, we can use the launch like below:

```  
  GlobalScope.launch(Dispatchers.IO) {  
      fetchUserAndSaveInDatabase() // do on IO thread  
  }
```  

- As the fetchUserAndSaveInDatabase do not return anything, we can use the launch.
- But when we need the result back then we must have to use async.Look into the below example
- Let us there are 2 methods fetchFirstUser() and fetchSecondUser() which returns User object after
  fetching from the network.

```
fun fetchFirstUser(): User {  
    // make network call  
    // return user  
}    
fun fetchSeconeUser(): User {  
    // make network call   
    // return user  
}  
```  

No need to make the above functions as suspend as we are not calling any other suspend
com.swasi.play.function from them.

Now, we can use the async like below:

```  
GlobalScope.launch(Dispatchers.Main) {  
    val userOne = async(Dispatchers.IO) { fetchFirstUser() }  
    val userTwo = async(Dispatchers.IO) { fetchSeconeUser() }  
    showUsers(userOne.await(), userTwo.await()) // back on UI thread  
}    
```  

Here, it makes both the network call in parallel, await for the results and then call the showUsers
com.swasi.play.function.

**withContext** is nothing but an another way writing the async where we do not have to write
await().Look at the example below

```  
suspend fun fetchUser(): User {  
    return withContext(Dispatchers.IO) {  
        // make network call  
        // return user  
    }  
}  
```  

Now we will understand the scope in the below example  
Scopes in Kotlin Coroutines are very useful because we need to cancel the background task as soon as
the activity is destroyed. Here, we will learn how to use scopes to handle these types of situation.

Assuming that our activity is the scope, the background task should get canceled as soon as the
activity is destroyed.Our activity will look like this

```  
class MainActivity : AppCompatActivity(), CoroutineScope {  
  private lateinit var job: Job  

  override val coroutineContext: CoroutineContext  
        get() = Dispatchers.Main + job  
        
   override fun onCreate(savedInstanceState: Bundle?) {  
    super.onCreate(savedInstanceState)  
    job = Job() // create the Job  
   }  

   override fun onDestroy() {  
    job.cancel() // cancel the Job  
    super.onDestroy()  
  }      
}  
```  

- Now, just use the launch like below:

```  
    launch {  
        val userOne = async(Dispatchers.IO) { fetchFirstUser() }  
        val userTwo = async(Dispatchers.IO) { fetchSeconeUser() }  
        showUsers(userOne.await(), userTwo.await())  
    }  
```  

- As soon as the activity is destroyed, the task will get cancelled if it is running because we have
  defined the scope.
- When we need the global scope which is our application scope, not the activity scope, we can use
  the GlobalScope as below:

```  
GlobalScope.launch(Dispatchers.Main) {  
    val userOne = async(Dispatchers.IO) { fetchFirstUser() }  
    val userTwo = async(Dispatchers.IO) { fetchSeconeUser() }  
}    
```  

USE OF SupervisorJob,

# Scope

- Scope in Kotlin’s coroutines can be defined as the restrictions within which the Kotlin coroutines
  are being executed.
- Scopes help to predict the lifecycle of the coroutines. There are basically 3 scopes in Kotlin
  coroutines:

## Global Scope :

- Global Scope is one of the ways by which coroutines are launched.
- When Coroutines are launched within the global scope, they live long as the application does.

```
GlobalScope.launch {
            Log.d(TAG, Thread.currentThread().name.toString())
        }
```

## LifeCycle Scope

- The lifecycle scope is the same as the global scope, but the only difference is that when we use
  the lifecycle scope, all the coroutines launched within the activity also dies when the activity
  dies.

```
btnStartActivity.setOnClickListener {
  lifecycleScope.launch {
                  while (true) {
                      delay(1000L)
                      Log.d(TAG, "Still Running..")
                  }
              }
  }
```

## ViewModel Scope

- It is also the same as the lifecycle scope, only difference is that the coroutine in this scope
  will live as long the view model is alive.
- ViewModel is a class that manages and stores the UI-related data by following the principles of
  the lifecycle system in android.

```
viewmodelScope.launch {
                while (true) {
                    delay(1000L)
                    Log.d(TAG, "Still Running..")
                }
            }
```

## Coroutine context and dispatchers

- The coroutine context includes a coroutine dispatcher (see CoroutineDispatcher) that determines
  what thread or threads the corresponding coroutine uses for its execution.
- When you launch a coroutine, you can specify the coroutine context.
- The coroutine context includes a coroutine dispatcher that determines what thread or threads the
  corresponding coroutine uses for its execution.
- All coroutine builders like launch and async accept an optional CoroutineContext parameter that
  can be used to explicitly specify the dispatcher for the new coroutine and other context elements.

## Types of Dispatchers

- There are basically four types of Dispatchers:
- Dispatchers.Main: A coroutine dispatcher that is confined to the Main thread operating with UI
  objects. Usually such dispatcher is single-threaded.
- Dispatchers.Default: The default CoroutineDispatcher that is used by all standard builders like
  launch, async, etc. if no dispatcher nor any other ContinuationInterceptor is specified in their
  context.
- Dispatchers.IO: The CoroutineDispatcher that is designed for offloading blocking IO tasks to a
  shared pool of threads.
- Dispatchers.Unconfined: A coroutine dispatcher that is not confined to any specific thread. It
  executes initial continuation of the coroutine in the current call-frame and lets the coroutine
  resume in whatever thread that is used by the corresponding suspending function, without mandating
  any specific threading policy.





  


