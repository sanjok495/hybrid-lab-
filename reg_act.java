package com.example.la1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class reg_act extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final DataBaseHelper mydb = new DataBaseHelper(this);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                if(!uname.isEmpty() && !pass.isEmpty()){
                    if(mydb.insertData(uname,pass)){
                        Toast.makeText(reg_act.this , "Registered",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(reg_act.this ,
                                opt.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(reg_act.this , "Some Error Occured",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(reg_act.this , "Fields are empty",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
