# Flow And Channel
## Flow
- By using 


## Live Data
- The only key difference between LiveData and MutableLiveData is that you can change the value of MutableLiveData but LiveData does not allow you to change it's value. 
- LiveData only allow you to observe and utilize it's value.

- **Difference Between setValue and postValue in Live data**
- **setValue():** Sets the value. If there are active observers, the value will be dispatched to them. This method must be called from the main thread.
- **postValue():** Posts a task to a main thread to set the given value. If you called this method multiple times before a main thread executed a posted task, only the last value would be dispatched.
- To summarize, the key difference would be:
- setValue() method must be called from the main thread. But if you need set a value from a background thread, postValue() should be used.

- **What is MediatorLiveData**
- Consider the following scenario: we have 2 instances of LiveData, let's name them liveData1 and liveData2
- we want to merge their emissions in one object: liveDataMerger. 
- Then, liveData1 and liveData2 will become sources for the MediatorLiveData liveDataMerger and every time onChanged callback is called for either of them, 
- we set a new value in liveDataMerger.
```
    LiveData<Integer> liveData1 = ...;
    LiveData<Integer> liveData2 = ...;
    
    MediatorLiveData<Integer> liveDataMerger = new MediatorLiveData<>();
    liveDataMerger.addSource(liveData1, value -> liveDataMerger.setValue(value));
    liveDataMerger.addSource(liveData2, value -> liveDataMerger.setValue(value));
```
```
liveDataMerger.addSource(liveData1, new Observer<Integer>() {
     private int count = 1;

     @Override public void onChanged(@Nullable Integer s) {
         count++;
         liveDataMerger.setValue(s);
         if (count > 10) {
             liveDataMerger.removeSource(liveData1);
         }
     }
});
```

## Live data, Flow, Shared flow & State flow
- https://logidots.com/insights/live-data-flow-shared-flow-state-flow-2/
- 
