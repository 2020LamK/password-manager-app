package edu.ysu.klam.passwordmanager;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PasswordsActivity extends AppCompatActivity {
    private static final List<Login> passwordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpass);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        if (passwordList.isEmpty()) {
            // filler password to test if they are displayed
            Login login = new Login();
            login.setEmail("example@gmail.com");
            login.setUser("example1");
            login.setPassword("ExamplePass321");
            login.setWebsite("Example");
            passwordList.add(login);
        }

        TextView tv = findViewById(R.id.passDisplay);
        tv.setText(passList(passwordList));
    }

    public String passList(List<Login> list) {
        StringBuilder string = new StringBuilder();
        for (int i=0;i<list.size();i++) {
            string.append(list.get(i).toString()).append("\n");
        }
        return string.toString();
    }

    public static List<Login> getPasswordList() {
        return passwordList;
    }

    public static void addToList(Login login) {
        passwordList.add(login);
    }

    public static void removeFromList(Login login) {
        passwordList.remove(login);
    }

    public static void updateList(Login login, Login edit) {
        login.setEmail(edit.getEmail());
        login.setUser(edit.getUser());
        login.setPassword(edit.getPassword());
        login.setWebsite(edit.getWebsite());
    }

    public static void removeFromList(UUID uuid) {
        for (int i = 0; i < passwordList.size(); i++) {
            if (passwordList.get(i).getId().equals(uuid)) {
                passwordList.remove(i);
                return;
            }
        }
    }

    public static Login getLogin(UUID uuid) {
        for (int i = 0; i < passwordList.size(); i++) {
            if (passwordList.get(i).getId().equals(uuid)) {
                return passwordList.get(i);
            }
        }
        return null;
    }

    public void goToAddPass(View view) {
        Intent intent = new Intent(this, AddPassActivity.class);
        startActivity(intent);
    }

    public void goToEditSearch(View view) {
        Intent intent = new Intent(this, EditOrDeleteSearchActivity.class);
        startActivity(intent);
    }
}