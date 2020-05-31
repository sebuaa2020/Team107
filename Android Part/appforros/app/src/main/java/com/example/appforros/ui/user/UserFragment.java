package com.example.appforros.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appforros.MainActivity;
import com.example.appforros.R;
import com.example.appforros.SelectActivity;
import com.example.appforros.User;

public class UserFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final User user = User.getInstance();
        final View root = inflater.inflate(R.layout.fragment_user, container, false);
        TextView account = root.findViewById(R.id.account);
        TextView priority = root.findViewById(R.id.priority);
        if (user.getUser_account() != -1) {
            account.setText(String.valueOf(user.getUser_account()));
            priority.setText(String.valueOf(user.getUser_priority()));
        }

        Button login_out = root.findViewById(R.id.login_out);
        login_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUser_account(-1);
                user.setUser_priority(-1);
                Intent intent = new Intent(root.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
