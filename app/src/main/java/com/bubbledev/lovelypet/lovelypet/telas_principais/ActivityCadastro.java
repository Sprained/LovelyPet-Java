package com.bubbledev.lovelypet.lovelypet.telas_principais;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bubbledev.lovelypet.lovelypet.R;
import com.bubbledev.lovelypet.lovelypet.tutorial.ActivityTutorial;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityCadastro extends AppCompatActivity {

    private Button cadastrar,cancelar;
    private EditText txtNome,txtSenha,txtConfirmarSenha,txtEndereco,txtTelefone,txtEmail;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        txtConfirmarSenha = findViewById(R.id.txtConfirmarSenha);
        txtNome = findViewById(R.id.txtNome);
        txtEndereco = findViewById(R.id.txtEndereco);
        txtTelefone = findViewById(R.id.txtTelefone);
        cadastrar = findViewById(R.id.btnCadastrar);
        cancelar = findViewById(R.id.btnCancelar);

        mAuth = FirebaseAuth.getInstance();


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = txtEmail.getText().toString();
                final String senha = txtSenha.getText().toString();
                final String senha2 = txtConfirmarSenha.getText().toString();
                final String nome = txtNome.getText().toString();
                final String endereco = txtEndereco.getText().toString();
                final String telefone = txtTelefone.getText().toString();

                if (email.isEmpty() || nome.isEmpty() || senha.isEmpty() || !senha.equals(senha2) || endereco.isEmpty() || telefone.isEmpty()){

                    showMessage("por favor verifique os campos");


                }
                else {


                    createUserAccount(email,nome,senha,telefone,endereco);


                }



            }
        });
    }

    private void createUserAccount(String email, String nome, String senha, String telefone, String endereco) {

        mAuth.createUserWithEmailAndPassword(email,senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            showMessage("conta criada");

                        }
                        else {
                            showMessage("conta não criada" + task.getException().getMessage());
                        }


                    }
                });
    }

    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }


}
