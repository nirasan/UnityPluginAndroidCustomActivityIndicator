package com.example.activityindicator;
import android.app.Activity;

import com.unity3d.player.UnityPlayer;

public class ActivityIndicator {

    private static MyCustomProgressDialog _dialog;

    public static void show() {
        final Activity activity = UnityPlayer.currentActivity;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (_dialog == null) {
                    _dialog = MyCustomProgressDialog.ctor(activity);
                }
                _dialog.show();
            }
        });
    }

    public static void hide() {
        if (_dialog == null) return;
        final Activity activity = UnityPlayer.currentActivity;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                _dialog.hide();
            }
        });
    }
}
