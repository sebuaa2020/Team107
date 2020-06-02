package com.example.appforros.ui.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appforros.R;
import com.example.appforros.Robot;
import com.example.appforros.RobotList;
import com.example.appforros.User;
import com.example.appforros.ui.plan.PlanFragment;
import com.google.android.material.snackbar.Snackbar;
import com.kongqw.rockerlibrary.view.RockerView;

public class ControlFragment extends Fragment {
    private RobotList robotList = RobotList.getInstance();
    private View root;
    private int chosed_id = -1;
    private Robot robot = null;
    private double velocity = 0.5;
    private User user = User.getInstance();
    private final String REVEIVE_CAMERA = "receive_camera";
    private ImageView camera;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_control, container, false);
        final SeekBar velocitySeekBar = root.findViewById(R.id.velocity);
        final TextView v_value = root.findViewById(R.id.v_value);
        chosed_id = robotList.getChosed_id();
        camera = root.findViewById(R.id.camera);
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

        doRegisterReceiver();

        if (robot != null && robot.getMap() != null) {
            camera.setImageBitmap(stringToBitmap(robot.getCamera()));
        }

        return root;
    }

    private void sendAngle(String angle) {
        if (chosed_id == -1) {
            //Toast.makeText(root.getContext(), "请连接机器人", Toast.LENGTH_SHORT).show();
        } else if (!user.check_priority("move")) {
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

    private class ChatMessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String message=intent.getStringExtra(REVEIVE_CAMERA);
            camera.setImageBitmap(stringToBitmap(message));
        }
    }


    /**
     * 动态注册广播
     */
    private void doRegisterReceiver() {
        ChatMessageReceiver chatMessageReceiver = new ChatMessageReceiver();
        IntentFilter filter = new IntentFilter(REVEIVE_CAMERA);
        root.getContext().registerReceiver(chatMessageReceiver, filter);
    }

    private Bitmap stringToBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("bitmap " + Integer.toHexString(bitmap.getPixel(496, 496)));

        return bitmap;
    }

}