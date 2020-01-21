package com.geekbrains.testrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    Bitmap bmp;

    int N = 15;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.mainText);



        Observable.fromCallable(()-> getFactorial())
                .map(String::valueOf)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    textView.setText(result);
                }, error -> {
                    Log.i("error", "ошибка");
                });

    }

    private int getFactorial() {
        int res = 1;
        for (int i = 2; i<=N; i++) res *= i;
        return res;
    }


    private Bitmap loadFileAndConvert() throws FileNotFoundException {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/logo2.jpg");
        OutputStream outputStream = new FileOutputStream(file);
        Bitmap bmp = null;
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return bmp;
    }
}
