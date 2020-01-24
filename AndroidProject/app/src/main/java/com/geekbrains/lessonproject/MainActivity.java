package com.geekbrains.lessonproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;

import com.geekbrains.lessonproject.user.list.UserRecycleAdapter;
import com.geekbrains.lessonproject.user.list.user;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Model model;
    List<user> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new Model();
        getUsersList();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new UserRecycleAdapter(users));
    }



    private void getUsersList(){
        model.getObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(result -> {
            users.add(new user(1, result, null, null));
        });
    }


}
