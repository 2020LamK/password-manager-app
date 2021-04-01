package edu.ysu.klam.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToPasswords(View view) {
        Intent intent = new Intent(this, PasswordsActivity.class);
        startActivity(intent);
    }

    public void goToPassGen(View view) {
        Intent intent = new Intent(this, PassGenActivity.class);
        startActivity(intent);
    }

}