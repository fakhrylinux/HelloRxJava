package tech.fakhrylinux.hellorxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import tech.fakhrylinux.hellorxjava.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start the stream when the button is clicked
        binding.button.setOnClickListener {
            startRStream()
        }
    }

    private fun startRStream() {
        // RxKotlin
        val list = listOf("1", "2", "3", "4", "5")

        // Apply the toObservable() extension functions
        list.toObservable()

            //Construct your Observer using the subscribeBy() extension function
            .subscribeBy(
                onNext = { println(it) },
                onError = { it.printStackTrace() },
                onComplete = { println("onComplete!") }
            )

        // // Create an Observable
        // val myObservable = getObservable()
        //
        // // Create ob Observer
        // val myObserver = getObserver()
        //
        // // Subscrive myObserver to myObservable
        // myObservable.subscribe(myObserver)
    }

    // private fun getObserver(): Observer<String> {
    //     return object : Observer<String> {
    //         override fun onSubscribe(d: Disposable) {
    //         }
    //
    //         // Every time onNext is called, print the value to Android Studio’s Logcat
    //         override fun onNext(s: String) {
    //             Log.d(TAG, "onNext: $s")
    //         }
    //
    //         // Called if an exception is thrown
    //         override fun onError(e: Throwable) {
    //             Log.e(TAG, "onError:  ${e.message}")
    //         }
    //
    //         // When onComplete is called, print the following to Logcat
    //         override fun onComplete() {
    //             Log.d(TAG, "onComplete")
    //         }
    //     }
}

// Give myObservable some data to emit
// private fun getObservable(): Observable<String> {
//     return Observable.just("1", "2", "3", "4", "5")
// }
// }