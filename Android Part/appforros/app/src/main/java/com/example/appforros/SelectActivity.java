package com.example.appforros;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appforros.ui.robot.RecycleAdapter;
import com.google.android.material.navigation.NavigationView;

public class SelectActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private RecycleAdapter adapter;
    private RobotList robotList = RobotList.getInstance();
    private User user = User.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_user,R.id.nav_robot, R.id.nav_control, R.id.nav_plan, R.id.nav_chat)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_begin:
                if (robotList.getChosed_id() == -1) {
                    Toast.makeText(this, "请连接机器人", Toast.LENGTH_SHORT).show();
                } else if (!user.check_priority("map")) {
                    Toast.makeText(this, "权限不足", Toast.LENGTH_SHORT).show();
                } else {
                    Robot robot = robotList.getChosed_robot();
                    robot.map_begin();
                    Toast.makeText(this, "开始建图", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.map_end:
                if (robotList.getChosed_id() == -1) {
                    Toast.makeText(this, "请连接机器人", Toast.LENGTH_SHORT).show();
                } else if (!user.check_priority("map")) {
                    Toast.makeText(this, "权限不足", Toast.LENGTH_SHORT).show();
                } else {
                    Robot robot = robotList.getChosed_robot();
                    robot.map_end();
                    Toast.makeText(this, "结束建图", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
