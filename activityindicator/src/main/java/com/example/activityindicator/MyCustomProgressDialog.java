package com.example.activityindicator;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MyCustomProgressDialog extends ProgressDialog {
  private static int layoutId;
  private static int animationId;
  private static int drawableId;

  private AnimationDrawable animation;

  public static MyCustomProgressDialog ctor(Context context) {
    MyCustomProgressDialog dialog = new MyCustomProgressDialog(context);
    dialog.setIndeterminate(true);
    dialog.setCancelable(false);
    layoutId = context.getResources().getIdentifier("view_custom_progress_dialog", "layout", context.getPackageName());
    animationId = context.getResources().getIdentifier("animation", "id", context.getPackageName());
    drawableId = context.getResources().getIdentifier("custom_progress_dialog_animation", "drawable", context.getPackageName());
    return dialog;
  }

  public MyCustomProgressDialog(Context context) {
    super(context);
  }

  public MyCustomProgressDialog(Context context, int theme) {
    super(context, theme);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(layoutId);

    ImageView la = (ImageView) findViewById(animationId);
    la.setBackgroundResource(drawableId);
    animation = (AnimationDrawable) la.getBackground();
  }

  @Override
  public void show() {
    super.show();
    animation.start();
  }

  @Override
  public void dismiss() {
    super.dismiss();
    animation.stop();
  }
}
