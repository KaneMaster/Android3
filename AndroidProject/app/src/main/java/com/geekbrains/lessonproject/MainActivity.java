package com.geekbrains.lessonproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.geekbrains.lessonproject.user.list.UserRecycleAdapter;
import com.geekbrains.lessonproject.user.list.user;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new UserRecycleAdapter(getUsersList()));
    }

    private List<user> getUsersList(){
        List<user> users = new ArrayList<>();
        users.add(new user(1, "Test", "", ""));
        users.add(new user(1, "Test2", "", ""));
        return users;
    }

}
