package com.example.appforros.ui.plan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appforros.R;
import com.example.appforros.Robot;
import com.example.appforros.RobotList;
import com.google.android.material.snackbar.Snackbar;

public class PlanFragment extends Fragment {

    private View root;
    private Robot robot = null;
    private RobotList robotList = RobotList.getInstance();
    private ImageView map_view;
    private final String MAP_MESSAGE = "map";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_plan, container, false);
        Button refresh_map = root.findViewById(R.id.refresh_map);
        Button send_des = root.findViewById(R.id.send_des);
        final EditText destination = root.findViewById(R.id.destination);
        map_view = root.findViewById(R.id.map);
        doRegisterReceiver();

        if (robotList.getChosed_id() != -1) {
            robot = robotList.getChosed_robot();
        }

        refresh_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (robot != null) {
                    robot.refresh_map();
                    Snackbar.make(v, "更新地图", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(v, "请连接机器人", Snackbar.LENGTH_SHORT).show();
                }

            }
        });

        send_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String des = destination.getText().toString();
                destination.setText("");
                if (robot != null) {
                    if (checkDes(des)) {
                        robot.send_des(des);
                        Snackbar.make(v, "发送地址", Snackbar.LENGTH_SHORT).show();
                    } else {
                        Snackbar.make(v, "地址错误", Snackbar.LENGTH_SHORT).show();
                    }
                } else {
                    Snackbar.make(v, "请连接机器人", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }

    private class ChatMessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String message=intent.getStringExtra(MAP_MESSAGE);
            System.out.println(message);
            System.out.println("*************************");
            //map_view.set 设置地图
        }
    }


    /**
     * 动态注册广播
     */
    private void doRegisterReceiver() {
        ChatMessageReceiver chatMessageReceiver = new ChatMessageReceiver();
        IntentFilter filter = new IntentFilter(MAP_MESSAGE);
        root.getContext().registerReceiver(chatMessageReceiver, filter);
    }

    private boolean checkDes(String des) {
        return true;
    }
}