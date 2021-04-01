package edu.ysu.klam.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pass);

        EditText email = findViewById(R.id.userEmail3);
        email.setText(searchAgain().getEmail(), TextView.BufferType.EDITABLE);

        EditText user = findViewById(R.id.userUser3);
        user.setText(searchAgain().getUser(), TextView.BufferType.EDITABLE);

        EditText pass = findViewById(R.id.userPass3);
        pass.setText(searchAgain().getPassword(), TextView.BufferType.EDITABLE);

        EditText website = findViewById(R.id.userWebsite3);
        website.setText(searchAgain().getWebsite(), TextView.BufferType.EDITABLE);

        Button finalEditPass = this.findViewById(R.id.button2);
        finalEditPass.setOnClickListener(v -> {
            PasswordsActivity.updateList(PasswordsActivity.getLogin(EditOrDeleteSearchActivity.getEdit().getId()), editPass());
            finish();
        });
    }

    public Login editPass() {
        Login edit = new Login();

        EditText email = findViewById(R.id.userEmail3);
        edit.setEmail(email.getText().toString());

        EditText user = findViewById(R.id.userUser3);
        edit.setUser(user.getText().toString());

        EditText password = findViewById(R.id.userPass3);
        edit.setPassword(password.getText().toString());

        EditText website = findViewById(R.id.userWebsite3);
        edit.setWebsite(website.getText().toString());

        return edit;
    }

    public Login searchAgain() {
        for (int i=0; i<PasswordsActivity.getPasswordList().size();i++) {
            if (EditOrDeleteSearchActivity.getEdit().equals(PasswordsActivity.getPasswordList().get(i))) {
                return PasswordsActivity.getPasswordList().get(i);
            }
        }
        return null;
    }
}