
package com.example.tablebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register_Activity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore database;
    EditText editText1, editText,editText2,editText3,editText4,editText5;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        auth=FirebaseAuth.getInstance();
        database=FirebaseFirestore.getInstance();

        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        editText1=findViewById(R.id.editText1);
        //editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email,password,name,gender;
                String age;
                email=editText.getText().toString();
                name=editText1.getText().toString();
                gender=editText4.getText().toString();
                password=editText5.getText().toString();
                age=editText3.getText().toString();

                Users users=new Users();
                users.setEmail(email);
                users.setPassword(password);
                users.setName(name);
                users.setGender(gender);
                users.setAge(age);

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            database.collection("Users")
                                    .document().set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    startActivity(new Intent(Register_Activity.this,LoginActivity.class));
                                }
                            });
                            Toast.makeText(Register_Activity.this,"Account is Created",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Register_Activity.this, (CharSequence) task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            
        });


    }
}