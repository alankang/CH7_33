package com.example.alan.ch7_33;

import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private String x1;
    private String x2;
    private String x3;
    private String x4;
    private String x5;

    private String scoreList[] = {"","","","",""};

    private TextView txtCard1;
    private TextView txtCard2;
    private TextView txtCard3;
    private TextView txtCard4;
    private TextView txtCard5;
    private TextView txtScore;
    private GestureDetectorCompat A;
    private String tenList[] = {"10s","10d","10h","10c"};
    private String cardlist[] = {"As","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","Ah","2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh"
    ,"Ac","2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ad","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        A = new GestureDetectorCompat(this, this);
        A.setOnDoubleTapListener(this);
        txtCard1 = (TextView) findViewById(R.id.txtCard1);
        txtCard2 = (TextView)findViewById(R.id.txtCard2);
        txtCard3 = (TextView)findViewById(R.id.txtCard3);
        txtCard4 = (TextView)findViewById(R.id.txtCard4);
        txtCard5 = (TextView)findViewById(R.id.txtCard5);
        txtScore = (TextView)findViewById(R.id.txtScore);
    }

    @Override
    public  boolean onTouchEvent(MotionEvent event){
        this.A.onTouchEvent(event);

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Random n = new Random();
        int x = n.nextInt(52);
        int y = n.nextInt(52);
        int z = n.nextInt(52);
        int h = n.nextInt(52);
        int q = n.nextInt(52);

        x1 = cardlist[x];
        x2 = cardlist[y];
        x3 = cardlist[z];
        x4 = cardlist[h];
        x5 = cardlist[q];

        txtCard1.setText(x1);
        txtCard2.setText(x2);
        scoreList[0] = x1;
        scoreList[1] = x2;


        calculateScore(scoreList);



        return false;
    }

    public boolean calculateScore(String[] B) {
        int r = 0;
        boolean result;


        for (int i = 0; i < B.length; i++) {
            int checker = 0;

            if (B[i].length() > 2) {
                r += 10;
                checker = 1;
            }
            if (B[i].contains("K")) {
                r += 10;
                checker = 1;
            }
            if (B[i].contains("Q")) {
                r += 10;
                checker = 1;
            }
            if (B[i].contains("J")) {
                r += 10;
                checker = 1;
            }
            if(B[i] == ""){
                checker = 1;
            }
            if(B[i].contains( "A" )){
                r += 11;
                checker = 1;
            }

            if (checker == 0) {
                r += Integer.parseInt(B[i].replaceAll("[^0-9]",""));
            }
        }
            //card2value += Integer.parseInt(x2.replace("[\\D]",""));
            String test = String.valueOf(r);

            txtScore.setText("Your Score:" + " " + test);

            if (r > 17) {
                Toast.makeText(getBaseContext(), "You Win!", Toast.LENGTH_SHORT).show();
                return true;
            }
            if(r > 21){
                Toast.makeText(getBaseContext(), "Busted!", Toast.LENGTH_SHORT).show();
                return true;
            }

        return false;

        }



    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        return true;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {


        return true;
    }


    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {

        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {


        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }
}
