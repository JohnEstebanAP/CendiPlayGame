package com.example.cendiplaygame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class RegisterActivity extends AppCompatActivity {

    public MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = findViewById(R.id.topAppBar);
        toolbar.setTitle(getString(R.string.title_register));

        toolbar.setNavigationOnClickListener(view -> super.finish());
    }
}