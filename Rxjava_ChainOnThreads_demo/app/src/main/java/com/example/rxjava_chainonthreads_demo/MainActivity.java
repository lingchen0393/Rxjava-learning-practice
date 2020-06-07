package com.example.rxjava_chainonthreads_demo;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> observable =
                Observable.create(source -> {
                    source.onNext("first");
                    source.onNext("second");
                    source.onNext("third");
                    source.onComplete();
                });

        observable.subscribeOn(Schedulers.computation()) //RxComputationThreadPool -- 1
                .doOnNext(value -> print("(a)" + value))

                .observeOn(Schedulers.newThread()) //RxNewThreadScheduler -- 2
                .doOnNext(value -> print("(b)" + value))

                .observeOn(Schedulers.newThread()) //RxNewThreadScheduler -- 3
                .subscribeOn(Schedulers.newThread())
                .doOnNext(value -> print("(c)" + value))

                .observeOn(Schedulers.newThread()) //RxNewThreadScheduler -- 4
                .observeOn(AndroidSchedulers.mainThread()) //main
                .subscribe(result -> print("(d)" + result)
                );




    }

    public static void print(String message){
        String threadName = Thread.currentThread().getName();
        Log.d("TAG", threadName + ":" + message);
    }
}
