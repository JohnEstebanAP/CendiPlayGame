package com.example.cendiplaygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private EditText user, psw;
    private String inputUser, inputPsw;
    public Button btnLogin;
    public Button btnClose;
    public Button btnRegister;
    private Intent intent;
    public TextInputLayout lyUser;
    public TextInputLayout lyPsw;
  //  private CheckBox remember;
  //  private SharedPreferences.Editor sharedPrefrencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.edtNameLogin);
        psw = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.btnlogin);
        btnClose = findViewById(R.id.btnExit);
        btnRegister = findViewById(R.id.btnRegister);
        lyUser = findViewById(R.id.lyedtNameLogin);
        lyPsw = findViewById(R.id.lyedtPasswordLogin);

      //  remember = findViewById(R.id.ch_remember);
      //  SharedPreferences prefer = getSharedPreferences("data", MODE_PRIVATE);

        /*
        user.setOnkeyListener(new View.OnClickListener(){
            @Override
            public boolean
        });
        */


        psw.setOnKeyListener((view, keyCode, keyEvent) ->{
            if(keyCode == keyEvent.KEYCODE_ENTER){
                validator();
                return true;
            }
            return false;
             });

        user.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                return false;
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validator();
            }
        });

        btnClose.setOnClickListener(View -> close());

        btnRegister.setOnClickListener(view -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });


      //  SharedPreferences Data = getSharedPreferences("data",MODE_PRIVATE);
    }

    private void valuesRetrunLogin(){
        inputUser = user.getText().toString();
        inputPsw = psw.getText().toString();
    }


    private void validator(){
        valuesRetrunLogin();
        String welcome = getString(R.string.welcome);

        if(inputUser.isEmpty()){
            lyUser.setError("Por favor ingrese el usuario");}
        else if(inputUser.length() > 20){
            lyUser.setError("El usuario no puede exceder los 20 caracteres");
        }else if(inputPsw.isEmpty()){
            lyUser.setError(null);
            lyPsw.setError("Ingrese La Contraseña");
        }else if(inputPsw.length() <= 3){
            lyUser.setError(null);
            lyPsw.setError("La contraseña deve tener mas de 3 caracteres");
        }else{
            lyUser.setError(null);
            lyPsw.setError(null);
            Toast.makeText(LoginActivity.this, welcome + inputUser, Toast.LENGTH_SHORT).show();
            intent = new Intent(this, HomeActivity.class);
            intent.putExtra("user",inputUser);
            startActivity(intent);
        }
/*
        if(remember.isChecked()){
            sharedPrefrencesEditor.putBoolean("status",true);
        }*/
    }

    public void close(){

        String title = getString(R.string.title_exit_alert);
        String message = getString(R.string.message_exit_alert);
        String btnNegative = getString(R.string.negative_exit_alert);
        String btnPositive = getString(R.string.positive_exit_alert);

        new MaterialAlertDialogBuilder(this)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(btnNegative, (dialogInterface, i) -> dialogInterface.cancel())
                .setPositiveButton(btnPositive, (dialogInterface, i) -> super.finishAndRemoveTask())
                .show();
        /*
        super.finish(); // para finalisr mi activadad
        super.finishAffinity();//Serar la aplicacion completa
        super.finishAndRemoveTask();//finalisar la actividad y remover e la vasurera para que no quede abierta en segundo plano
        */
    }

    //El metodo se ejecuta cadabes que precionamos el boton de atras.
    @Override
    public void onBackPressed(){
        close();
    }
}