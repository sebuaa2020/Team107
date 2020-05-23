package com.example.appforros.ui.control;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appforros.R;
import com.example.appforros.Robot;
import com.example.appforros.RobotList;
import com.example.appforros.ui.control.camera.CameraSurfaceHolder;
import com.google.android.material.snackbar.Snackbar;

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

    CameraSurfaceHolder mCameraSurfaceHolder = new CameraSurfaceHolder();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_control, container, false);
        forward = root.findViewById(R.id.forward);
        backoff  = root.findViewById(R.id.backoff);
        turnleft = root.findViewById(R.id.turn_left);
        turnright = root.findViewById(R.id.turn_right);
        mSurfaceView = root.findViewById(R.id.mSurfaceView);
        chosed_id = robotList.getChosed_id();
        if (chosed_id != -1) {
            robot = robotList.getChosed_robot();
        }

        if (checkCameraHardware(root.getContext())) {
            mCameraSurfaceHolder.setCameraSurfaceHolder(root.getContext(), mSurfaceView);
        }

        buttonClick();
        return root;
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

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Toast.makeText(context, "搜索到摄像头硬件", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(context, "搜索到摄像头硬件", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}