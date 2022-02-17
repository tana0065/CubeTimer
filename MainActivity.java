package com.newtana.rubikscube;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

//AppCompatActivity

public class MainActivity extends Activity implements Runnable, View.OnClickListener{

    private int count;//ストップウォッチのスタート処理とストップ処理を分けるための条件で使用するcount
    private long startTime;//スタート時刻をミリ秒で代入するための変数宣言

    private Button startButton;//startボタンのインスタンスを生成
    private Button scButton;//scrambleボタンのインスタンスを生成
    private Button button3D;//3Dボタンのインスタンスの生成
    private Button resetButton;//resetボタンのインスタンスの生成
    private Button wayButton;//詳細ボタンのインスタンスの生成

    private TextView timerText;
    private TextView timerResult;
    private TextView timerAve;


    private final Handler handler = new Handler(Looper.getMainLooper());
    private volatile boolean stopRun = false;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss,SS", Locale.JAPAN);

    private String str = null;//スクランブルの回転記号を入れるための箱の宣言
    private short[] scnumber = {//scnumberの初期化、スクランブルしていない状態
            0,0,0,0,0,0,0,0,0,
            1,1,1,1,1,1,1,1,1,
            2,2,2,2,2,2,2,2,2,
            3,3,3,3,3,3,3,3,3,
            4,4,4,4,4,4,4,4,4,
            5,5,5,5,5,5,5,5,5
    };

    private short resultCount = 0;//タイムの結果を処理するために使用する変数宣言
    private long[] df = new long[12];//12回のタイムをミリ秒で保管するための配列を宣言、ミリ秒のためlong

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timerText = findViewById(R.id.textTimer);
        timerText.setText(dateFormat.format(0));

        startButton = findViewById(R.id.startbutton);//スタートボタン
        startButton.setOnClickListener(this);

        scButton = findViewById(R.id.scrambleButton);//スクランブルボタン
        scButton.setOnClickListener(this);

        resetButton = findViewById(R.id.resetButton);//リセットボタン
        resetButton.setOnClickListener(this);

        button3D = findViewById(R.id.drawing3D);//3Dボタン
        button3D.setOnClickListener((View v) ->{
            Intent intent = new Intent(this,SubActivity.class);
            intent.putExtra("SEND_DATA",scnumber);//SubActivityにscnumberを渡す
            startActivity(intent);

        });

        wayButton = findViewById(R.id.waybutton);//詳細ボタン
        wayButton.setOnClickListener((View v) ->{
            Intent intent = new Intent(this,WayActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onClick(View v) {
        Button btn3 = (Button)MainActivity.this.findViewById(R.id.startbutton);
        if(v == startButton){
            Thread thread;
            TextView stv = findViewById(R.id.startbutton);
            count++;
            Button btn1 = (Button)MainActivity.this.findViewById(R.id.scrambleButton);
            Button btn2 = (Button)MainActivity.this.findViewById(R.id.drawing3D);
            LinearLayout lay = (LinearLayout)MainActivity.this.findViewById(R.id.Result);

            if(count == 2){//startボタンを2回押したとき
                stopRun = true;
                timerText.setText(dateFormat.format(0));
                count = 0;
                stv.setText("START!");

                btn1.setVisibility(View.VISIBLE);//Scrambleボタン表示
                btn2.setVisibility(View.VISIBLE);//3Dボタン表示

                lay.setVisibility(View.VISIBLE);//秒数結果一覧を表示
                if(resultCount == 12){//12回のタイムを計測したら、スタートボタンを非表示
                    btn3.setVisibility(View.INVISIBLE);
                }

            }else{
                resultCount++;//秒数を表示させた回数をカウントする
                switch (resultCount){
                    case 1:
                        timerResult = findViewById(R.id.timerResult1);
                        break;
                    case 2:
                        timerResult = findViewById(R.id.timerResult2);
                        break;
                    case 3:
                        timerResult = findViewById(R.id.timerResult3);
                        break;
                    case 4:
                        timerResult = findViewById(R.id.timerResult4);
                        break;
                    case 5:
                        timerResult = findViewById(R.id.timerResult5);
                        break;
                    case 6:
                        timerResult = findViewById(R.id.timerResult6);
                        break;
                    case 7:
                        timerResult = findViewById(R.id.timerResult7);
                        break;
                    case 8:
                        timerResult = findViewById(R.id.timerResult8);
                        break;
                    case 9:
                        timerResult = findViewById(R.id.timerResult9);
                        break;
                    case 10:
                        timerResult = findViewById(R.id.timerResult10);
                        break;
                    case 11:
                        timerResult = findViewById(R.id.timerResult11);
                        break;
                    case 12:
                        timerResult = findViewById(R.id.timerResult12);
                        break;
                }

                stopRun = false;
                thread = new Thread(this);//スタート処理
                thread.start();
                startTime = System.currentTimeMillis();

                btn1.setVisibility(View.INVISIBLE);//Scrambleボタン非表示
                btn2.setVisibility(View.INVISIBLE);//3Dボタン非表示

                lay.setVisibility(View.INVISIBLE);//秒数結果一覧を非表示

                stv.setText("STOP!");
            }
        }else if(v == scButton){
            //Scrambleのインスタンス生成
            Scramble s = new Scramble();

            //strにscrambleSignから持ってきた文字列を代入
            str = s.scrambleSign();
            str = str.replace(",", " ");
            str = str.replace("[", "");
            str = str.replace("]", "");

            TextView tv;
            tv = findViewById(R.id.scrambleText);
            //scrambleTextにセットする
            tv.setText(str);

            //SignTransformationインスタンス生成
            SignTransformation st = new SignTransformation(str);
            scnumber = st.num;


        }else if(v == resetButton){
            btn3.setVisibility(View.VISIBLE);//スタートボタンを表示
            resultCount = 0;//resultCountをリセット

            //全てのタイムをリセット
            timerResult = findViewById(R.id.timerResult1);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult2);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult3);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult4);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult5);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult6);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult7);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult8);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult9);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult10);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult11);
            timerResult.setText("---");
            timerResult = findViewById(R.id.timerResult12);
            timerResult.setText("---");
            timerResult = findViewById(R.id.ao5Text);
            timerResult.setText("---");
            timerResult = findViewById(R.id.ao12Text);
            timerResult.setText("---");
        }
    }

    @Override
    public void run(){
        //10msec order
        int period = 10;

        while(!stopRun){
            //sleep: period msec
            try{
                Thread.sleep(period);
            }catch (InterruptedException e){
                e.printStackTrace();
                stopRun = true;
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    long endTime = System.currentTimeMillis();
                    //カウント時間　＝　経過時間　-　開始時間
                    long diffTime = (endTime - startTime);

                    timerText.setText(dateFormat.format(diffTime));

                    switch (resultCount){
                        case 1:
                            timerResult.setText("[1]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 2:
                            timerResult.setText("[2]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 3:
                            timerResult.setText("[3]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 4:
                            timerResult.setText("[4]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 5:
                            timerResult.setText("[5]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 6:
                            timerResult.setText("[6]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 7:
                            timerResult.setText("[7]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 8:
                            timerResult.setText("[8]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 9:
                            timerResult.setText("  [9]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 10:
                            timerResult.setText("[10]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 11:
                            timerResult.setText("[11]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                        case 12:
                            timerResult.setText("[12]" + dateFormat.format(diffTime));
                            df[resultCount - 1] = diffTime;
                            break;
                    }

                    if(resultCount == 5 && stopRun == true){//タイムを計測したのが5回目の時、かつ、ストップボタンを押された時
                        long aveTime = 0L;
                        long[] result5 = new long[5];//新しく配列を宣言
                        for(int i = 0 ; i < 5 ; i++){
                            result5[i] = df[i];//その配列にタイムを代入する
                        }
                        Arrays.sort(result5);//result5配列を昇順にソートする

                        for(int i = 0; i < 3 ; i++){
                            aveTime = aveTime + result5[1+i];//最初と最後の要素を除く要素を代入することで、最も早いタイムと最も遅いタイムを省くことができる
                        }
                        long ao5Time = (long)(aveTime/3L);//合計3個のタイムの平均をとる
                        timerAve = findViewById(R.id.ao5Text);
                        timerAve.setText("[ao5]" + dateFormat.format(ao5Time));//ao5テキストにセット

                    }else if(resultCount == 12 && stopRun == true){
                        long aveTime = 0L;
                        long[] result12 = new long[12];//新しく配列を宣言
                        for(int i = 0 ; i < 12 ; i++){
                            result12[i] = df[i];//その配列にタイムを代入する
                        }
                        Arrays.sort(result12);//result12配列を昇順にソートする

                        for(int i = 0; i < 10 ; i++){
                            aveTime = aveTime + result12[1+i];//最初と最後の要素を除く要素を代入することで、最も早いタイムと最も遅いタイムを省くことができる
                        }
                        long ao12Time = (aveTime/10L);//合計10個のタイムの平均をとる
                        timerAve = findViewById(R.id.ao12Text);
                        timerAve.setText("[ao12]" + dateFormat.format(ao12Time));//ao12テキストにセット
                    }

                }
            });

        }

    }

}