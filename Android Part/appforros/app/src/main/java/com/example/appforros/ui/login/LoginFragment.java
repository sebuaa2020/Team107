package com.example.appforros.ui.login;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appforros.R;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        Button login_in = root.findViewById(R.id.login_in_button);
        TextView register = root.findViewById(R.id.user_register);
        final EditText user_account = root.findViewById(R.id.user_account);
        final EditText user_password = root.findViewById(R.id.user_password);
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
                Snackbar.make(v, "帐号为: " + user_account.getText() + "\n密码为: " + user_password.getText(),
                        Snackbar.LENGTH_SHORT).show();
                user_account.setText("");
                user_password.setText("");
            }
        });

        return root;
    }
}