package com.example.rxjava_demo1;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
//import io.reactivex.rxjava2.core.Observable;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.reactivestreams.Subscriber;

import java.sql.Time;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

//    private TextView text;
//    private Observable<String> newObservable;
//    private Observer<String> newObserver;

    private Button button;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Rxjava2的Observable.fromarray()方法
                 *
                 */
//                demoObservableFrom();

                /** Rxjava2的Observable.just()方法
                 *
                 */
//                demoObservableJust();

                /** Rxjava2的Observable.defer()方法
                 *
                 */
//                movie = new Movie("The Avengers 4");
//                Observable<Movie> movieObservable = Observable.defer(new Callable<ObservableSource<? extends Movie>>() {
//                    @Override
//                    public ObservableSource<? extends Movie> call() throws Exception {
//                        return Observable.just(movie);
//                    }
//                });
//                movie = new Movie("Black Panda");
//                movieObservable.subscribe(new Observer<Movie>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Movie movie) {
//                        Log.i("onNext3",movie.name);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

                /** Rxjava2的Observable.interval()方法
                 *
                 */
//                demoObservableInterval();

                /** Rxjava2的Observable.create()方法
                 *
                 */
                demoObservableCreate();
            }
        });
    }

    private void demoObservableCreate() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();

            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i("onNext5",String.valueOf(integer));

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void demoObservableInterval() {
        Observable.interval(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                if(aLong == 5){
                   onComplete();
                }
                Log.i("onNext4",String.valueOf(aLong));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void demoObservableDefer() {
    }

    class Movie{
        public String name;

        public Movie(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }
    }

    private void demoObservableJust() {
        Observable.just(1,2,3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i("onNext2",String.valueOf(integer));

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void demoObservableFrom(){
        Observable.fromArray(new Integer[]{1,2,3}).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i("onNext1",String.valueOf(integer));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


}
