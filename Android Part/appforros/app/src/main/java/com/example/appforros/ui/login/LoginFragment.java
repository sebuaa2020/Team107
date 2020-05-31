package com.example.appforros.ui.login;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.appforros.R;
import com.example.appforros.User;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {

    private EditText user_account;
    private EditText user_password;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        Button login_in = root.findViewById(R.id.login_in_button);
        TextView register = root.findViewById(R.id.user_register);

        user_account = root.findViewById(R.id.user_account);
        user_password = root.findViewById(R.id.user_password);
        user_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        final User user = User.getInstance();

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
                    Snackbar.make(v, "帐号为: " + user_account.getText() + "\n密码为: " + user_password.getText(),
                            Snackbar.LENGTH_SHORT).show();
                    user.setUser_account(Long.valueOf(cheekAccount()));
                    user.setUser_priority(2);
                    user_account.setText("");
                    user_password.setText("");

                }

            }
        });

        return root;
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