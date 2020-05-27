package com.example.appforros.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appforros.R;
import com.example.appforros.User;

public class UserFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        User user = User.getInstance();
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        TextView account = root.findViewById(R.id.account);
        TextView priority = root.findViewById(R.id.priority);
        account.setText(String.valueOf(user.getUser_account()));
        priority.setText(String.valueOf(user.getUser_priority()));
        return root;
    }
}
