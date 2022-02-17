package com.newtana.rubikscube;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/**
 * Created by Tommy on 2015/06/21.
 */
public class Axes {
    //buffer
    private FloatBuffer vertexBuffer;
    private ByteBuffer indexBuffer;

    private float[] vertexs = {
    //  x, y, z
        0.435f,-0.435f,-0.435f,  //R方向
        0.435f,-0.435f,0.435f,
        0.435f,0.435f,0.435f,
        0.435f,0.435f,-0.435f,
        0.435f,-0.435f,-0.435f,

        0.145f,-0.435f,-0.435f,
        0.145f,-0.435f,0.435f,
        0.145f,0.435f,0.435f,
        0.145f,0.435f,-0.435f,
        0.145f,-0.435f,-0.435f,

        -0.145f,-0.435f,-0.435f,
        -0.145f,-0.435f,0.435f,
        -0.145f,0.435f,0.435f,
        -0.145f,0.435f,-0.435f,
        -0.145f,-0.435f,-0.435f,

        -0.435f,-0.435f,-0.435f,
        -0.435f,-0.435f,0.435f,
        -0.435f,0.435f,0.435f,
        -0.435f,0.435f,-0.435f,
        -0.435f,-0.435f,-0.435f,


        -0.435f,0.435f,-0.435f,//F方向
        0.435f,0.435f,-0.435f,
        0.435f,-0.435f,-0.435f,
        -0.435f,-0.435f,-0.435f,

        -0.435f,-0.435f,-0.145f,
        -0.435f,0.435f,-0.145f,
        0.435f,0.435f,-0.145f,
        0.435f,-0.435f,-0.145f,
        -0.435f,-0.435f,-0.145f,

        -0.435f,-0.435f,0.145f,
        -0.435f,0.435f,0.145f,
        0.435f,0.435f,0.145f,
        0.435f,-0.435f,0.145f,
        -0.435f,-0.435f,0.145f,

        -0.435f,-0.435f,0.435f,
        -0.435f,0.435f,0.435f,
        0.435f,0.435f,0.435f,
        0.435f,-0.435f,0.435f,
        -0.435f,-0.435f,0.435f,


        0.435f,-0.435f,0.435f,//U方向
        0.435f,-0.435f,-0.435f,
        -0.435f,-0.435f,-0.435f,
        -0.435f,-0.435f,0.435f,

        -0.435f,-0.145f,0.435f,
        0.435f,-0.145f,0.435f,
        0.435f,-0.145f,-0.435f,
        -0.435f,-0.145f,-0.435f,
        -0.435f,-0.145f,0.435f,

        -0.435f,0.145f,0.435f,
        0.435f,0.145f,0.435f,
        0.435f,0.145f,-0.435f,
        -0.435f,0.145f,-0.435f,
        -0.435f,0.145f,0.435f,

        -0.435f,0.435f,0.435f,
        0.435f,0.435f,0.435f,
        0.435f,0.435f,-0.435f,
        -0.435f,0.435f,-0.435f,
        -0.435f,0.435f,0.435f,


    };

    //点の番号
    private byte[] indexs= {
            0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,//R方向
            20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,//F方向
            39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57//U方向
    };

    Axes(){makeAxes(1f);}
    Axes(float size){makeAxes(size);}
    public void makeAxes(float size) {
        int i;
        for (i = 0; i < 28 * 3; i++) {
            vertexs[i] *= size;
        }
        vertexBuffer = BufferUtil.makeFloatBuffer(vertexs);
        indexBuffer = BufferUtil.makeByteBuffer(indexs);
    }

    public void draw(float r,float g,float b,float a, float shininess, float linewidth){
        //頂点点列
        GLES20.glVertexAttribPointer(GLES.positionHandle, 3,
                GLES20.GL_FLOAT, false, 0, vertexBuffer);


        //shadingを使わない時に使う単色の設定 (r, g, b,a)
        GLES20.glUniform4f(GLES.objectColorHandle, r, g, b, a);

        //線の太さ
        GLES20.glLineWidth(linewidth);

        //ここから描画
        //P0から58個の連続点で，ひとマスの境の線を一気に描く（都合上同じ線を2度引くところもある）
        indexBuffer.position(0);
        GLES20.glDrawElements(GLES20.GL_LINE_STRIP,
                58, GLES20.GL_UNSIGNED_BYTE, indexBuffer);
    }
}