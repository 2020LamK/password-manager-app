package edu.ysu.klam.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.UUID;

public class EditOrDeleteSearchActivity extends AppCompatActivity{
    private static Login edit = new Login();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_or_delete_search);

        // this is the Confirm Edit/Delete button
        Button editPass = this.findViewById(R.id.button3);
        editPass.setOnClickListener(v -> {
            setEdit();
        });

        // edit button just redirects user to the edit screen

        // delete works
        Button deletePass = this.findViewById(R.id.button4);
        deletePass.setOnClickListener(v -> {
            PasswordsActivity.removeFromList(searchEditList());
            finish();
        });
    }

    public static Login getEdit() {
        return edit;
    }

    public void setEdit() {
        edit = PasswordsActivity.getLogin(searchEditList());
    }

    // this works
    public UUID searchEditList() {
        Login login = new Login();

        EditText email = findViewById(R.id.userEmail2);
        login.setEmail(email.getText().toString());

        EditText website = findViewById(R.id.userWebsite2);
        login.setWebsite(website.getText().toString());

        for (int i = 0; i < PasswordsActivity.getPasswordList().size(); i++) {
            if (PasswordsActivity.getPasswordList().get(i).getEmail().equals(login.getEmail()) &&
                    PasswordsActivity.getPasswordList().get(i).getWebsite().equals(login.getWebsite())) {
                return PasswordsActivity.getPasswordList().get(i).getId();
            }
        }
        return null;
    }

    public void goToEditPass(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
    }
}
