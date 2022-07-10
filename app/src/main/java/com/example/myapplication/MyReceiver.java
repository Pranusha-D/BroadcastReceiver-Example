package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       String intentAction = intent.getAction();

       if(intentAction != null){
           String toastMessage = "unknown intent action";

           switch (intentAction) {
               case Intent.ACTION_POWER_CONNECTED:
                   toastMessage = "Power connected!";
                   break;
               case Intent.ACTION_POWER_DISCONNECTED:
                   toastMessage = "Power disconnected!";
                   break;
               case ACTION_CUSTOM_BROADCAST:
                   int num= intent.getIntExtra("number", 0);
                   toastMessage = "Custom Broadcast Received \n" + "Square of random number received: " + num*num;
                   break;
               case Intent.ACTION_HEADSET_PLUG:
                   int state = intent.getIntExtra("state", -1);
                   switch (state) {
                       case 0:
                           toastMessage = "Headset is unplugged";
                           break;
                       case 1:
                           toastMessage = "Headset is plugged";
                           break;
                       default:
                           toastMessage = "I have no idea what the headset state is";
                   }
                   break;
           }
           Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
       }
    }
}