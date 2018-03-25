package com.example.a777.home_project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by 777 on 31.01.2018.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    DrawThread drawThread;


    public MySurfaceView(Context context) {
        super(context);
        holder=getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawThread=new DrawThread(getContext(), holder);
        drawThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        drawThread.threadStop();
        boolean flag=true;
        while (flag){
            try {
                drawThread.join();
                flag=false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
