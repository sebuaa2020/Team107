package com.example.appforros.ui.control;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appforros.R;
import com.example.appforros.Robot;
import com.example.appforros.RobotList;
import com.google.android.material.snackbar.Snackbar;
import com.kongqw.rockerlibrary.view.RockerView;

public class ControlFragment extends Fragment {
    private RobotList robotList = RobotList.getInstance();
    private View root;
    private SurfaceView mSurfaceView;
    private Button forward;
    private Button backoff;
    private Button turnleft;
    private Button turnright;
    private int chosed_id = -1;
    private Robot robot = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_control, container, false);
//        forward = root.findViewById(R.id.forward);
//        backoff  = root.findViewById(R.id.backoff);
//        turnleft = root.findViewById(R.id.turn_left);
//        turnright = root.findViewById(R.id.turn_right);

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
            }
        });


        chosed_id = robotList.getChosed_id();
        if (chosed_id != -1) {
            robot = robotList.getChosed_robot();
        }

        //buttonClick();
        return root;
    }

    private void sendAngle(String angle) {
        if (chosed_id != -1) {
            robot.sendAngle(angle);
        } else {
            Toast.makeText(root.getContext(), "请连接机器人", Toast.LENGTH_SHORT).show();
        }
    }

    private void buttonClick() {
        forward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (chosed_id != -1) {
                    robot.move("forward");
                    Snackbar.make(v,"机器人" + chosed_id + "发送前进指令", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Snackbar.make(v,"请连接机器人", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        backoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (chosed_id != -1) {
                    robot.move("back");
                    Snackbar.make(v,"机器人" + chosed_id + "发送后退指令", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Snackbar.make(v,"请连接机器人", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        turnleft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (chosed_id != -1) {
                    robot.move("left");
                    Snackbar.make(v,"机器人" + chosed_id + "发送左转指令", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Snackbar.make(v,"请连接机器人", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        turnright.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (chosed_id != -1) {
                    robot.move("right");
                    Snackbar.make(v,"机器人" + chosed_id + "发送右转指令", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Snackbar.make(v,"请连接机器人", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

}