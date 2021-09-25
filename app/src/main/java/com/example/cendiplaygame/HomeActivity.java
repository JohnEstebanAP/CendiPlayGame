package com.example.cendiplaygame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HomeActivity extends AppCompatActivity {

    public Button btnContinuar;
    public Intent intent;
    public String outputUser;
    public TextView txtNombreUsr;

    public MediaPlayer pop;
    public long count;
    //public MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        outputUser = getIntent().getStringExtra("user");
        btnContinuar= (Button)findViewById(R.id.btnContinuar);
        txtNombreUsr= (TextView)findViewById(R.id.tv_user_home);
        pop = MediaPlayer.create(this, R.raw.pop);
        txtNombreUsr.setText(outputUser);
        btnContinuar.setOnClickListener( View -> pop.start());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int search = R.id.mn_search;
        final int information = R.id.mn_information;
        final int configuration = R.id.mn_configuration;

        switch(item.getItemId()){
            case search:
                pop.start();
                Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
                return true;
            case information:
                pop.start();
                Toast.makeText(this,"information",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Information.class));
                return true;
            case configuration:
                pop.start();
                Toast.makeText(this,"configutation",Toast.LENGTH_SHORT).show();
                showInformation();
                return true;
            default:
                return false;
        }
        //return super.onOptionsItemSelected(item);
    }

    /* Menu */
        /*
        //toolbar = (MaterialToolbar)findViewById(R.id.topAppBar);

       toolbar.setOnMenuItemClickListener(item -> {
             Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
             switch (item.getItemId()) {
                 case R.id.search:
                     // Navigate to settings screen
                     return true;
                 case R.id.more:
                     // Save profile changes
                     return true;
                 default:
                     return false;
             }
         });*/
       /*   toolbar.setOnMenuItemClickListener();
        toolbar.setOnMenuItemClickListener(menuItem ->{
          final int search = R.id.mn_search;
            final int count = R.id.mn_count;
            final int information = R.id.mn_information;
            final int configuration = R.id.mn_configuration;
            final int a = R.id.favorite;
            final int b = R.id.search;
            final int c = R.id.more;*/
         /* switch(item.getItemId()){
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
            }*/
    // return false;
    // });

    private void showInformation(){
        new MaterialAlertDialogBuilder(this)
                .setTitle("Information")
                .setMessage("Version: 1.0 \n This information App PlayGame")
                .setPositiveButton("ok", (dialogInterface, i) -> dialogInterface.cancel())
                .show();
    }

    //El metodo se ejecuta cadabes que precionamos el boton de atras.
    @Override
    public void onBackPressed() {
        if( count + 200 >  System.currentTimeMillis()) {
            super.finishAffinity();
        }else {
            Toast.makeText(this, "¡Otra vez para salir!", Toast.LENGTH_SHORT).show();
            count = System.currentTimeMillis();
        }
    }
}