package com.newtana.rubikscube;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    private MyGLSurfaceView glView;
    private GestureDetector gesDetector = null;
    public short[] scnumber = new short[54];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        scnumber = intent.getShortArrayExtra("SEND_DATA");//MainActivityからscnumberを受け取る

        //GLサーフェスビュー
        glView=new MyGLSurfaceView(this,scnumber);
        setContentView(glView); //これでviewを設置している


        //glView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        //これを有効にすると，描画させたいタイミングで、
        // 描画させたいタイミングで、GLSurfaceViewのrequestRenderを呼び出す必要がある。

        gesDetector = new GestureDetector(this, (GestureDetector.OnGestureListener) glView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        //glView.requestRender();
        return gesDetector.onTouchEvent(event);
    }

    //アクティビティレジューム時に呼ばれる
    @Override
    public void onResume() {
        super.onResume();
        glView.onResume();
    }

    //アクティビティポーズ時に呼ばれる
    @Override
    public void onPause() {
        super.onPause();
        glView.onPause();
    }
}
