package com.example.appforros.ui.robot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appforros.R;
import com.example.appforros.Robot;
import com.example.appforros.RobotList;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private Context context;
    //private List<String> list;
    private long ip;
    private String ip_form;
    //private RobotList robotList;
    private ArrayList<Robot> robots;
    private RobotList robotList = RobotList.getInstance();
    
    public RecycleAdapter(Context context, ArrayList<Robot> robotList) {
        this.context = context;
        this.robots = robotList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_home, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //final Robot robot = robotList.getRobotById(position);
        final Robot robot = robots.get(position);
        //holder.tv.setText(list.get(position));
        holder.tv.setText("机器人" + position + ":\t" + robot.getForm_ip());
        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, "删除:" + position, Snackbar.LENGTH_SHORT).show();
                removeData(position, v);

            }
        });
        holder.robot_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robotList.setChosed_id(robot.getRobot_id());

                if (robot.sendHello() == true) {
                    Snackbar.make(v, "连接到:" + robot.getForm_ip(), Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(v, "连接到失败", Snackbar.LENGTH_SHORT).show();
                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return robots.size();
    }

    public void addData(int position/*, long ip, String ip_form*/) {
        /*list.add( "机器人" + position + "\t ip:" + ip_form);
        this.ip = ip;
        this.ip_form = ip_form;*/
        System.out.println(position);
        notifyItemInserted(position);
    }

    public void removeData(int position, View v) {
        //list.remove(position);
        if (robotList.getChosed_id() == position) {
            robotList.setChosed_id(-1);
        }
        robots.remove(position);
        System.out.println(position);
        notifyItemRemoved(position);
        //System.out.println(robotList.getRobot_count() + " " + robotList.size());
        notifyDataSetChanged();
        //System.out.println(robotList.getRobot_count() + " " + robotList.size());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv, tv_delete, robot_connect;
        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
            tv_delete = (TextView) view.findViewById(R.id.tv_delete);
            robot_connect = view.findViewById(R.id.robot_connect);
        }
    }
}
