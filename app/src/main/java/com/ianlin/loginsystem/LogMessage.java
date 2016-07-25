package com.ianlin.loginsystem;

import android.content.Context;
import android.widget.Toast;

public class LogMessage {

    public static void logInfo(Context c, String message){
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();

    }
}
