package com.example.la1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class opt extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        final DataBaseHelper mydb = new DataBaseHelper(this);
        final EditText ausername, apassword, uusername, upassword,
                dusername;
        final Button adduser, deleteuser, updateuser;
        ausername = findViewById(R.id.ausername);
        apassword = findViewById(R.id.apassword);
        uusername = findViewById(R.id.uusername);
        upassword = findViewById(R.id.upassword);
        dusername = findViewById(R.id.dusername);
        adduser = findViewById(R.id.adduser);
        updateuser = findViewById(R.id.updateuser);
        deleteuser = findViewById(R.id.deleteuser);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = ausername.getText().toString();
                String pass = apassword.getText().toString();
                if (!uname.isEmpty() && !pass.isEmpty()) {
                    if (mydb.insertData(uname, pass)) {
                        Toast.makeText(opt.this, "User Added", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(opt.this,
                                activity_log_reg_screen.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(opt.this, "Some Error Occurred", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(opt.this, "Fields are empty", Toast.LENGTH_LONG).show();
                }
            }
        });
        updateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = uusername.getText().toString();
                String pass = upassword.getText().toString();
                if (!uname.isEmpty() && !pass.isEmpty()) {
                    if (mydb.updateData(uname, pass)) {
                        Toast.makeText(opt.this, "User Updated", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(opt.this,
                                activity_log_reg_screen.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(opt.this, "Some Error Occurred", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(opt.this, "Fields are empty", Toast.LENGTH_LONG).show();
                }
            }
        });
        deleteuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = dusername.getText().toString();
                if (!uname.isEmpty()) {
                    if (mydb.deleteData(uname)) {
                        Toast.makeText(opt.this, "User Deleted", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(opt.this,
                                activity_log_reg_screen.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(opt.this, "Some Error Occurred", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(opt.this, "Fields are empty", Toast.LENGTH_LONG).show();
                }
            }
        });
        deleteuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = dusername.getText().toString();
                if (!uname.isEmpty()) {
                    if (mydb.deleteData(uname)) {
                        Toast.makeText(opt.this, "User Deleted", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(opt.this,
                                activity_log_reg_screen.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(opt.this, "Some Error Occurred", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(opt.this, "Some Error Occurred", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    }

