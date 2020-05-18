package com.example.appforros.ui.robot;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

public class RobotDialog extends Dialog {

    private Context  context;

    public RobotDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }
}
