package com.theost.recyclerapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.theost.recyclerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UsersAdapter usersAdapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<User> users = new ArrayList<>(Arrays.asList(
                new User(0, "https://source.unsplash.com/random/200x200?sig=1", "Liam", "liam@gmail.com"),
                new User(1, "https://source.unsplash.com/random/200x200?sig=2", "Olivia", "olivia@gmail.com"),
                new User(2, "https://source.unsplash.com/random/200x200?sig=3", "Noah", "noah@gmail.com"),
                new User(3, "https://source.unsplash.com/random/200x200?sig=4", "Emma", "emma@gmail.com"),
                new User(4, "https://source.unsplash.com/random/200x200?sig=5", "Oliver", "oliver@gmail.com"),
                new User(5, "https://source.unsplash.com/random/200x200?sig=6", "Ava", "ava@gmail.com"),
                new User(6, "https://source.unsplash.com/random/200x200?sig=7", "Henry", "henry@gmail.com"),
                new User(7, "https://source.unsplash.com/random/200x200?sig=8", "Mia", "mia@gmail.com"),
                new User(8, "https://source.unsplash.com/random/200x200?sig=9", "James", "james@gmail.com"),
                new User(9, "https://source.unsplash.com/random/200x200?sig=10", "Sophia", "sophia@gmail.com"),
                new User(10, "https://source.unsplash.com/random/200x200?sig=11", "Lucas", "lucas@gmail.com"),
                new User(11, "https://source.unsplash.com/random/200x200?sig=12", "Julia", "julia@gmail.com"),
                new User(12, "https://source.unsplash.com/random/200x200?sig=13", "Mike", "mike@gmail.com"),
                new User(13, "https://source.unsplash.com/random/200x200?sig=14", "Walter", "walter@gmail.com"),
                new User(14, "https://source.unsplash.com/random/200x200?sig=15", "Dan", "dan@gmail.com"),
                new User(15, "https://source.unsplash.com/random/200x200?sig=16", "Sia", "sia@gmail.com")
        ));

        usersAdapter = new UsersAdapter(users, user -> usersAdapter.cloneUser(user));
        binding.usersList.setAdapter(usersAdapter);
    }

}
