package com.example.cendiplaygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

public class ConfigurationActivity extends AppCompatActivity {

    public MaterialToolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        toolbar = (MaterialToolbar) findViewById(R.id.topAppBar);
        toolbar.setTitle(R.string.configuration);

        toolbar.setNavigationOnClickListener(view -> super.finish());
/*
        toolbar.setOnMenuItemClickListener(menuItem ->{
            final int a = R.id.favorite;
            final int b = R.id.search;
            final int c = R.id.more;
            switch(item.getItemId()){
                case search:
                    Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
                    return true;
                case count:
                    Toast.makeText(this,"Count",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, count.class));
                    return true;
                case information:
                    Toast.makeText(this,"information",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, Information.class));
                    return true;
                case configuration:
                    Toast.makeText(this,"configutation",Toast.LENGTH_SHORT).show();
                    showInformation();
                    return true;
                default:
                    return false;
            }
        });
*/
    }
}