package com.TugasAkhir.hafizhonthestreet.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.TugasAkhir.hafizhonthestreet.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signupdummy extends AppCompatActivity {

    EditText emailEt,passEt;
    private FirebaseAuth mAuth;
    Button daftarbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupdummy);

        emailEt = (EditText)findViewById(R.id.emaildaftar);
        passEt = (EditText)findViewById(R.id.passworddaftar);

        Button daftarbt = (Button) findViewById(R.id.bt_daftar);

        mAuth = FirebaseAuth.getInstance();
        daftarbt .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEt.getText().toString().trim();
                String password = passEt.getText().toString().trim();
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Berhasil daftar",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });



    }
}
