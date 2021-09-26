package com.example.cendiplaygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HomeInicioActivity extends AppCompatActivity {

    public Button btnContinuar;
    public Intent intent;
    public String outputUser;
    public TextView txtNombreUsr;

    public MediaPlayer pop;
    public long count;
    public MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_inicio);

        outputUser = getIntent().getStringExtra("user");
        btnContinuar= (Button)findViewById(R.id.btnContinuar);
        txtNombreUsr= (TextView)findViewById(R.id.tv_user_home);
        pop = MediaPlayer.create(this, R.raw.pop);
        txtNombreUsr.setText(outputUser);


        btnContinuar.setOnClickListener( View -> pop.start());

        /* Menu */
        toolbar = (MaterialToolbar) findViewById(R.id.top_app_bar_menu_home);
        toolbar.setOnMenuItemClickListener(item -> {
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
                    showInformation();
                    return true;
                case configuration:
                    Toast.makeText(this,"configutation",Toast.LENGTH_SHORT).show();
                    pop.start();
                    startActivity(new Intent(this, ConfigurationActivity.class ));
                    return true;
                default:
                    return false;
            }
        });

    }




    private void showInformation(){
        final  String title = getString(R.string.title_information_alert);
        final  String message = getString(R.string.message_information_alert);
        final  String positive = getString(R.string.positive_information_alert);


        new MaterialAlertDialogBuilder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positive, (dialogInterface, i) -> dialogInterface.cancel())
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