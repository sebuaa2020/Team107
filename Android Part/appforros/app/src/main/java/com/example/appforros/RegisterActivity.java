package com.example.appforros;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText new_account;
    private EditText new_password;
    private EditText repeat_password;
    private EditText administer_password;
    private Button register_button;
    private String s_account;
    private String s_password;
    private String rs_password;
    private String sa_password;
    private final String ADMINISTER_PASSWORD = "team107";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        new_account = findViewById(R.id.new_account);
        new_password = findViewById(R.id.new_password);
        repeat_password = findViewById(R.id.repeat_password);
        administer_password = findViewById(R.id.administer_password);
        register_button = findViewById(R.id.register_button);
        new_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        repeat_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        administer_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    addAccount();
                    Toast.makeText(v.getContext(), "添加帐号成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                setEdit();
            }
        });

    }

    private boolean check() {
        s_account = new_account.getText().toString();
        s_password = new_password.getText().toString();
        rs_password = repeat_password.getText().toString();
        sa_password = administer_password.getText().toString();
        if (s_account.equals("")) {
            Toast.makeText(this, "请输入帐号", Toast.LENGTH_SHORT).show();
            return false;
        } else if (s_password.equals("")) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!rs_password.equals(s_password)) {
            Toast.makeText(this, "确认密码错误", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!sa_password.equals(ADMINISTER_PASSWORD)) {
            Toast.makeText(this, "管理员密码错误", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private void addAccount() {

    }

    private void setEdit() {
        new_account.setText("");
        new_password.setText("");
        repeat_password.setText("");
        administer_password.setText("");
    }

}
