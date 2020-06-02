package com.example.appforros;

import android.content.Context;
import android.content.Intent;
import android.telephony.mbms.MbmsErrors;
import android.util.AndroidException;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

public class Robot {
    private int robot_id = 0;
    private long robot_ip;
    private String form_ip;
    private Socket socket;
    private String uri = "ws://134.175.14.15:8080/demo/websocket/1";
    private String recvMsg = null;
    private WebClient webClient;
    private Context context;
    //private String map;
    private String map = "iVBORw0KGgoAAAANSUhEUgAAA+AAAAPgCAAAAACXTEmhAAAQd0lEQVR4nO3dSXbbSBZAUWUd74n7H3JVWYNMV1mNZQKBJvBw78CW3IAY+OEHGtJ//f0GVP3n7B0A9iNwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmE/zt4BLun5z0+Pc/eCPzLBIUzgECZwCBM4hAmcNVxduwiBM+B59g7wBwKHMIFDmMAhTODMzon+AIEzuacr9gMEzuxM8AECZ5XDxurTPfcRAmd2JvgAgTO1p6fmhgic2ZngAwTOzJ5vJvgQgTPiiOlqgg8QOBN7vr2Z4EMEzuxM8AECZ50j5qq0hwmcaf17i8wSfYDAmdnzzRwfInBm9fMWmQk+QODMzAQfJHAmpestCBzCBM6cDPBNCJyVXPu6AoEzZK9Ba4BvQ+AQJnBmZIBv5MfZOwCfPb/57s3p/wImOIQJnPlYoG9G4BAmcNba7UzYAN+OwCFM4MzGAN+QwCFM4EzGAN+SwBmjx6kJnLk4YGxK4ExF39sSOKt5JHx+AmcmBvjGBA5hAmciBvjWBA5hAmceBvjmBA5hAmcaBvj2BM56294I1/cOBM4gXc5M4EzCgWIPAocwgTOHBQPcM/CvEzhXo+8FBM4UXh/g+l5C4FyLvhcROAM2q+3lAa7vZQTOleh7IYEzgVcHuL6XEjjn0/duBM5l6Hs5gTNq+BnTFzeg7xUEzkXoew2Bc7bXBri+VxH4Dez4Pq3DstP3OgLve25U+HOfA8VLW9X3SgK/hau/11rfawn8Hjaa4ZtsZfk29b2awG9i1hmu730J/C42KXzWwwS/I/Db2Oka2ZgZ9ylF4DcyX03z7VGNwO9kfIh/2sDjq19kGgK/l7lanGtvkgR+M6NNbdmkvvcn8LsZXaar8lJ+nL0DHO65133lhfe0HSoOYILf0NgQ36pLfR/BBL+ljYf4glZ//lFPpx3DBL+nkSE+73PtfCLwuzo3sIe+jyHw21o/xN/9RWvtqQn8xk6cogb4QQR+Z2uHuDwvQ+B93y2iFR4n8Jub8k2kbEbgt7eqcIeFixB4359iNMTDBM6qeeygcA0C73vhTvVIrm6Ez8yz6BmD7yB5/P/L1/6GsK9A4Pxj4mCf7x9sfUy8q9OxROdfP6+1vVrPgWfhz2++41sCzxgfa/MWzloC73gMJ+6GWY7A+dXz7c0ILxE47zyfb+58hQicDxYU/s8IdziYmMBLtknNmXiIwPnsuWyEMy+B84WnZ0kiBM6XXizcCJ+cwFM2nLuvPpK+3SuyA4FDmMAZY4RPTeAMc0FuXgJvOaE1I3xmAocwgTPKCJ+YwBmm8HkJHMIEHuOKNr8SOIQJHMIEDmEChzCBQ5jAIUzgMR464VcChzCBQ5jAIUzgECbwFtfYeEfgECZwCBM4hAk8xSk47wkcwgQOYQKHMIGXOAXnA4FDmMAh7MfZO8BWrM/5zASHMIFDmCV6xsMqnU9McAgTOIQJvMT/PMgHAocwgUOYwCFM4ClOwnlP4BAmcAgTOIQJHMIE3uIqG+8IHMIEDmEChzCBxzgJ51cChzCBQ5jAIUzgECZwCBM4hAk8xicn8yuBQ5jAIUzgECbwFqfgvCNwCBM4hAkcwgQOYQJPcY2N9wQOYQKHsB9n7wCX8Hiz/r8kE7xktwR90ttVmeD8kbyvywTnT/R9YSZ4yC4rdHlfmsArdjr/1ve1CZxvyPvqnIPze2v7fjgwzMIEr/inqS0X6iOVPtw0n4PA+dpA3ub3PCzR+dJopCKfgwnOF4by1PZETHA+2yJRmU/BBOejwTSVPRMTnA8EWiJw3hm+hf349AUnEnjK8N3n4SplPReB83/bPoGm9Qm4yMZPrp0HmeD8S5tFAuft7W2r1fnjm+84gyU6b2+vtfjzz3gfyYWY4Gx3ce3jZozw0wkcHYZZot/ednk7UMzHBL+7XfuW/NlM8HuboMBvd8EFvUECv7P5H1x7SHyMJfqNHTC+x19igjXGlZngt7VxObuFaIiPMMHv6qDJ6AH3cwn8ngYebfl6nu4aocJXE/gtXa0Y/5PCWgK/oR1y+f0Wd3oKltcI/H6u2co19/p0Ar+bXVa7321zq9ezTF9D4PeyTyVDG32+fBdM4csJ/FbmTETh+xH4jezxqS1f/8qS335bUrjEFxL4fUwch2X6XgR+F/sNvz9u+JVXVvg+BH4T03fx8hC3TF9C4Cm/+7e/ZRQfQ9zsNpghvgOB38HZRbz0+k/vGtuBt4v27Zv3llt/nn4oyjHB63Y+Zd12668v03mNwOPmGImv7oVl+tYs0dN2z3v7F7BM35QJXjZPKgv2xDJ9SyZ41yU+U/GzpyG+IRM868KRGOKbEXjUIc97LVl4L9nuU+FbEXjTfnkfkt5zwdtP+I7Aiw56XHvRqyzdJUN8EwLv2TXvX7Lb9yhimb4Jgedc+OLaO5bpWxB4zM6r84EBvmLHDPFhAm/ZeXwfHJxl+rC//j57D7iOX3NbcShZV2vllOMcJjhzM8SHCJyXDQ7wlS/6cK1tgMB51XBn6w4KT0N8gMBZ49ATY9fa1hM4Kxx84csyfTWBc5zVxwXL9LUEznIn3LmyTF9H4Bxo4Mhgmb6KwFnsnEdPLNPXEDiT+nQYeTw91LaYR1V51c/5OZTZ74ewevdggkOYwFlobNKa08cSOIQJnGWM4EsROIsM9+0AcSiBQ5jAWWKD+WuEH0ngECZwFjB9r0bgHM1R4kAC53XSvByBQ5jAedlWA9xC4DgC51W6vCCBczyHisMIHMIEDmEC5wTW6EcROIQJnDMY4QcROHOQ/C4Ezhx85vkuBM4pDOxjCBzCBM45jPBDCBzCBA5hAuck1uhHEDiECRzCBM5ZrNEPIHAIEzinefz2G7YicKag730IHMIEznmM7d0JHMIEzoken75gWwJnBj7uYScChzCBc6bHh5/ZmMCZgSX6TgTOqYzufQkcwgQOYQLnXI9ffmRzAmcGLrLtROAQJnBO9vjfD2xP4MzAEn0nAudspveOBM4MRL4TgTMDS/SdCJzTGd/7ETgz0PhOBM755L0bgUPYX3+fvQfAbkxwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAgTOIQJHMIEDmEChzCBQ5jAIUzgECZwCBM4hAkcwgQOYQKHMIFDmMAhTOAQJnAIEziECRzCBA5hAocwgUOYwCFM4BAmcAj7L203DrqtAugDAAAAAElFTkSuQmCC";
    private String des = "0 0";
    private final String FROM = "android";
    private final String TO = "robot";
    private final String TO_MAP = "map";
    private final String DIRECTION = "direction";
    private final String MAP_BEGIN = "map_begin";
    private final String MAP_END =  "map_end";
    private final String MAP_REFRESH = "map_refresh";
    private final String ANGLE = "angle_speed";
    private final String SEND_DES = "send_des";
    private final String SEND_STOP = "stop";

    public Robot() {

    }

    public Robot(int robot_id, long robot_ip, String form_ip, Context context) {
        this.robot_id = robot_id;
        this.form_ip = form_ip;
        this.robot_ip = robot_ip;
        this.context = context;
        try {
            webClient = new WebClient(new URI(uri), context);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public int getRobot_id() {
        return robot_id;
    }

    public long getRobot_ip() {
        return robot_ip;
    }

    public String getForm_ip() {
        return form_ip;
    }

    public String getMap() {
        return map;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setMap(String map) {
        this.map = map;
    }

    /**检查连接情况
     */
    public boolean sendHello() {
        Message msg = new Message(FROM, TO, "hello", "hello");
        //System.out.println("webclient");
        sendMessage(msg);
        //sendMessage("hello");
        return true;
    }

    public void sendStop() {
        Message msg = new Message(FROM, TO, SEND_STOP, SEND_STOP);
        sendMessage(msg);
    }

    /**方向控制
     */
    public void move(String direction) {
        Message msg = new Message(FROM, TO, DIRECTION, direction);
        sendMessage(msg);
        //sendMessage(direction);
    }

    public void sendAngle(String angle) {
        Message msg = new Message(FROM, TO, ANGLE, angle);
        sendMessage(msg);
    }

    public void map_begin() {
        Message msg = new Message(FROM, TO, MAP_BEGIN, MAP_BEGIN);
        sendMessage(msg);
    }

    public void map_end() {
        Message msg = new Message(FROM, TO, MAP_END, MAP_END);
        sendMessage(msg);
    }

    /**更新地图
     */
    public void refresh_map() {
        Message msg = new Message(FROM, TO_MAP, MAP_REFRESH, MAP_REFRESH);
        sendMessage(msg);
    }

    /**发送导航点坐标
     */
    public void send_des(String des) {
        Message msg = new Message(FROM, TO, SEND_DES, des);
        sendMessage(msg);
    }

    private void sendMessage(Message msg) {
        webClient.send(msg.MessageToJson());
        //System.out.println("send" + Msg.toString());
    }

    private void sendMessage(String msg) {
        webClient.send(msg);
    }

}