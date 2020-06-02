package com.example.appforros.ui.plan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
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
import com.example.appforros.RobotView;
import com.example.appforros.User;
import com.google.android.material.snackbar.Snackbar;

public class PlanFragment extends Fragment {

    private View root;
    private Robot robot = null;
    private RobotList robotList = RobotList.getInstance();
    private ImageView map_view;
    private final String MAP_MESSAGE = "map";
    private final String RECEIVE_DES = "receive_des";
    private User user = User.getInstance();
    private FrameLayout map_frame;
    private ImageView robot_location;
    private FrameLayout.LayoutParams robot_margin;
    private int map_width = 992;
    private int map_height = 992;
    private RobotView robotView;
    //private String test_image = "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";
    //private String test_image = "AAABAAEAEBAAAAEAIABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAQAQAAAAAAAAAAAAAAAAAAAAAAAB9SR//fUkf/31JH/99SR//fUkf/31JH/99SR//fUkf/31JH/99SR//fUkf/6mHbP+LXDf/fUkf/31JH/99SR//fUkf/31JH/99SR//fUkf/31JH/99SR//i104/5lwT/+RZkP/fksh/6eFaP/8/Pv/mG9N/31JH/99SR//fUkf/31JH/99SR//fUkf/31JH/+tjHL/6uHb//7+/v////////////Xx7v/8+/r//////6N/Yv99SR//fUkf/31JH/99SR//fUkf/35LIf/PvK3///////////////////////////////////////////+vj3b/fUkf/31JH/99SR//fUkf/31JH/++pI/////////////08Oz/vqSQ/8y3p///////////////////////u6CK/31JH/99SR//fUkf/31JH/+IWDL/+vn3///////s5d//iVo1/6B7XP/6+ff/8Orl/9TDtv+5nYb/nXZX/4NRKf9+SyL/fUkf/31JH/99SR//sJF3////////////onxe/35LIv+ge1z/ils1/31JH/99SR//fUkf/6qIbf/dz8T/1MK0/31JH/99SR//fUkf/8WunP///////Pv7/39MIv99SR//fUkf/31JH/99SR//fUkf/31JH//ay7///////+ri2/99SR//fUkf/31JH//Frpv///////38+/9/TCP/fUkf/31JH/99SR//fUkf/31JH/99SR//2szA///////q4dv/fUkf/31JH/99SR//r491////////////pIBi/31JH/99SR//fUkf/31JH/99SR//hVUt//j29P//////1MK1/31JH/99SR//fUkf/4dXMP/59/b//////+7o4/+MXjn/fUkf/31JH/99SR//gE0k/9XFuP///////////6aDZ/99SR//fUkf/31JH/99SR//up+I////////////9vPw/8OrmP+si3D/uZ2G/+ri2////////////97Rx/99SiD/fUkf/31JH/99SR//fUkf/31KIP/KtqX//v7+/////////////////////////////////+Xb0/+HWDH/fUkf/31JH/99SR//fUkf/31JH/99SR//fUkf/6eFaP/l2tL//v7+////////////8evn/7yhi/+BTyb/fUkf/31JH/99SR//fUkf/31JH/99SR//fUkf/31JH/99SR//fUkf/4dXMP+Uakf/jV86/31JH/99SR//fUkf/31JH/99SR//fUkf/31JH/9/SyH/f0sh/39LIf9/SyH/f0sh/39LIf9/SyH/f0sh/39LIf9/SyH/f0sh/39LIf9/SyH/f0sh/39LIf9/SyH/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_plan, container, false);
        Button refresh_map = root.findViewById(R.id.refresh_map);
        Button send_des = root.findViewById(R.id.send_des);
        final EditText des_x = root.findViewById(R.id.des_x);
        final EditText des_y = root.findViewById(R.id.des_y);
        map_view = root.findViewById(R.id.map);
        map_frame = root.findViewById(R.id.map_frame);
        robot_location = root.findViewById(R.id.robot_location);
        robot_margin = (FrameLayout.LayoutParams) robot_location.getLayoutParams();
        robotView = new RobotView(root.getContext());
        map_frame.addView(robotView);

        doRegisterReceiver();
        doRobotLocationReceiver();

        if (robotList.getChosed_id() != -1) {
            robot = robotList.getChosed_robot();
        }

        refresh_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (robotList.getChosed_id() == -1) {
                    Snackbar.make(v, "请连接机器人", Snackbar.LENGTH_SHORT).show();
                } else if (!user.check_priority("plan")){
                    Snackbar.make(v, "权限不足", Snackbar.LENGTH_SHORT).show();
                } else {
                    robot.refresh_map();
                    Snackbar.make(v, "更新地图", Snackbar.LENGTH_SHORT).show();
                }

            }
        });

        send_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = des_x.getText().toString();
                des_x.setText("");
                String y = des_y.getText().toString();
                des_y.setText("");
                String des = x + " " + y;

                if (robotList.getChosed_id() == -1) {
                    Snackbar.make(v, "请连接机器人", Snackbar.LENGTH_SHORT).show();
                } else if (!user.check_priority("plan")) {
                    Snackbar.make(v, "权限不足", Snackbar.LENGTH_SHORT).show();
                } else {
                    if (checkDes(des)) {
                        robot.send_des(des);
                        //setRobotLocation(des);
                        //robot.setDes(des);
                        Snackbar.make(v, "发送地址 " + des, Snackbar.LENGTH_SHORT).show();
                    } else {
                        Snackbar.make(v, "地址错误", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });

        if (robot != null && robot.getMap() != null) {
            map_view.setImageBitmap(stringToBitmap(robot.getMap()));
            setRobotLocation(robot.getDes());
        }

        return root;
    }

    private class ChatMessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String message=intent.getStringExtra(MAP_MESSAGE);
            map_view.setImageBitmap(stringToBitmap(message));
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

    private class RobotLocationReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String message=intent.getStringExtra(RECEIVE_DES);
            setRobotLocation(message);
        }
    }


    /**
     * 动态注册广播
     */
    private void doRobotLocationReceiver() {
        RobotLocationReceiver robotLocationReceiver = new RobotLocationReceiver();
        IntentFilter filter = new IntentFilter(RECEIVE_DES);
        root.getContext().registerReceiver(robotLocationReceiver, filter);
    }

    private boolean checkDes(String des) {
        return true;
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
        map_width = bitmap.getWidth();
        map_height = bitmap.getHeight();

        return bitmap;
    }

    private void setRobotLocation(String des)  {
        int left = 0;
        int top = 0;
        double x = 0;
        double y = 0;
        System.out.println("des--" + des);
        if (des != "") {
            x = Double.valueOf(des.split(" ")[0]);
            y = Double.valueOf(des.split(" ")[1]);
            left = 540 + (int) x*20*1080/map_width;
            top = 540 - (int) y*20*1080/map_height;
            //left = 160 + (int) x*20*320/map_width;
            //top = 160 - (int) y*20*320/map_height;
        }
        System.out.println("des--- " + x + " " + y);
        System.out.println("des--- " + left + " " + top);
        //robot_margin.setMargins(left, top, 0, 0);
        //robot_location.refreshDrawableState();
        robotView.setBitmapX(left);
        robotView.setBitmapY(top);
        robotView.invalidate();
    }
}