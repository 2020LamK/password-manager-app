package edu.ysu.klam.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pass);

        Button addPass = this.findViewById(R.id.button);
        addPass.setOnClickListener(v -> {
            PasswordsActivity.addToList(newPass());
            finish();
        });
    }

    public Login newPass() {
        Login login = new Login();

        EditText email = findViewById(R.id.userEmail);
        login.setEmail(email.getText().toString());

        EditText user = findViewById(R.id.userUser);
        login.setUser(user.getText().toString());

        EditText password = findViewById(R.id.userPass);
        login.setPassword(password.getText().toString());

        EditText website = findViewById(R.id.userWebsite);
        login.setWebsite(website.getText().toString());

        return login;
    }
}