package com.example.appforros;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private User user = User.getInstance();
    private EditText user_account;
    private EditText user_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        Button login_in = findViewById(R.id.login_in_button);
        TextView register = findViewById(R.id.user_register);

        user_account = findViewById(R.id.user_account);
        user_password = findViewById(R.id.user_password);
        user_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "注册", Snackbar.LENGTH_SHORT).show();
            }
        });

        login_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cheekAccount() == -1) {
                    Snackbar.make(v, "帐号错误: ", Snackbar.LENGTH_SHORT).show();
                } else {
                    user.setUser_account(Long.valueOf(cheekAccount()));
                    user.setUser_priority(2);
                    user_account.setText("");
                    user_password.setText("");
                    Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    private long cheekAccount() {
        long account;
        try {
            //System.out.println("account" + user_account.getText().toString());
            account = Long.parseLong(user_account.getText().toString());
        } catch (NumberFormatException e) {
            return -1;
        }

        return account;
    }
}
