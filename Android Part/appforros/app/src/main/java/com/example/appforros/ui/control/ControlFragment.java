package com.example.appforros.ui.control;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appforros.R;
import com.example.appforros.Robot;
import com.example.appforros.RobotList;
import com.example.appforros.User;
import com.google.android.material.snackbar.Snackbar;
import com.kongqw.rockerlibrary.view.RockerView;

public class ControlFragment extends Fragment {
    private RobotList robotList = RobotList.getInstance();
    private View root;
    private int chosed_id = -1;
    private Robot robot = null;
    private double velocity = 0.5;
    private User user = User.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_control, container, false);
        final SeekBar velocitySeekBar = root.findViewById(R.id.velocity);
        final TextView v_value = root.findViewById(R.id.v_value);
        chosed_id = robotList.getChosed_id();
        if (chosed_id != -1) {
            robot = robotList.getChosed_robot();
        }

        velocitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                velocity = progress / 100.0;
                v_value.setText("当前速度：" + velocity);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        RockerView rockerView = root.findViewById(R.id.rockerView);
        final TextView mLog = root.findViewById(R.id.mLog);
        rockerView.setCallBackMode(RockerView.CallBackMode.CALL_BACK_MODE_STATE_CHANGE);
        rockerView.setOnAngleChangeListener(new RockerView.OnAngleChangeListener() {
            @Override
            public void onStart() {
                mLog.setText(null);
            }

            @Override
            public void angle(double angle) {
                mLog.setText("摇动角度 : " + angle);
                sendAngle(String.valueOf(angle));
            }

            @Override
            public void onFinish() {
                mLog.setText(null);
                //System.out.println("************************");
                sendStop();
            }
        });

        return root;
    }

    private void sendAngle(String angle) {
        if (chosed_id == -1) {
            //Toast.makeText(root.getContext(), "请连接机器人", Toast.LENGTH_SHORT).show();
        } else if (user.check_priority("move")) {
            //Toast.makeText(root.getContext(), "权限不足", Toast.LENGTH_SHORT).show();
        } else {
            robot.sendAngle(angle + " " + velocity);
        }
    }

    private void sendStop() {
        if (chosed_id == -1) {
            Toast.makeText(root.getContext(), "请连接机器人", Toast.LENGTH_SHORT).show();
        } else if (!user.check_priority("move")) {
            Toast.makeText(root.getContext(), "权限不足", Toast.LENGTH_SHORT).show();
        } else {
            robot.sendStop();
        }
    }

}