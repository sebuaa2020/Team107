package com.example.appforros.ui.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appforros.R;
import com.example.appforros.Robot;
import com.example.appforros.RobotList;

import java.util.Arrays;
import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {
    private Context context;
    private List<String> list;
    private String command;
    private String[] forward = {"forward", "move forward", "前进"};
    private String[] left = {"left", "turn left", "左转"};
    private String[] right = {"right", "turn right", "右转"};
    private String[] back = {"back", "backoff", "move back", "后退"};
    private RobotList robotList = RobotList.getInstance();
    private Robot robot;

    public RightAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RightViewHolder holder = new RightViewHolder(LayoutInflater.from(
                context).inflate(R.layout.chat_right_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RightAdapter.RightViewHolder holder, final int position) {
        holder.right_chat.setText(command);
        if (robotList.getChosed_id() != -1) {
            robot = robotList.getChosed_robot();
            checkCommand(holder);
        } else {
            holder.left_chat.setText("请连接机器人");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(int position, String command) {
        list.add("test" + position);
        this.command = command;
        notifyItemInserted(position);
    }

    private void checkCommand(RightAdapter.RightViewHolder holder) {
        if (Arrays.asList(forward).contains(command)) {
            robot.move("forward");
            holder.left_chat.setText("收到指令，机器人前进");
        } else if (Arrays.asList(back).contains(command)) {
            robot.move("backoff");
            holder.left_chat.setText("收到指令，机器人后退");
        } else if (Arrays.asList(left).contains(command)) {
            robot.move("turnleft");
            holder.left_chat.setText("收到指令，机器人左转");
        } else if (Arrays.asList(right).contains(command)) {
            robot.move("turnright");
            holder.left_chat.setText("收到指令，机器人右转");
        } else {
            holder.left_chat.setText("错误指令");
        }
    }


    class RightViewHolder extends RecyclerView.ViewHolder {
        TextView right_chat;
        TextView left_chat;
        public RightViewHolder(View view) {
            super(view);
            right_chat = view.findViewById(R.id.right_mes);
            left_chat = view.findViewById(R.id.left_mes);
        }
    }
}