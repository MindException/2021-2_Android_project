package com.androidproject.texipool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Finishmap extends AppCompatActivity {

    private String mykey;
    private String nickname;
    private String nextNum;             //여기에 들어오는 숫자로 1이면 도착지, 2면
    int nextcase = 0;                   //Integer.parseInt()로 String을 int로 만들기 가능함.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishmap);

        setting();
        next();
        back();

    }


    void setting(){

        //먼저 키 값들을 가져온다.
        mykey = getIntent().getStringExtra("mykey");
        nickname = getIntent().getStringExtra("mynickname");
        nextNum = getIntent().getStringExtra("case");

        //여기다가 tmap 관련하여서 코딩





    }

    void next(){

        ImageButton ib = (ImageButton)findViewById(R.id.nextbtn);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(Finishmap.this, PostUI.class);
                it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it.putExtra("mykey", mykey);                //자신의 고유번호를 넘겨준다.
                it.putExtra("mynickname", nickname);        //자신의 닉네임을 넘긴다.
                //시작
                startActivity(it);
            }
        });

    }

    void back(){

        ImageButton ib = (ImageButton)findViewById(R.id.xbtn);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(Finishmap.this, Startmap.class);
                it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it.putExtra("mykey", mykey);                //자신의 고유번호를 넘겨준다.
                it.putExtra("mynickname", nickname);        //자신의 닉네임을 넘긴다.
                it.putExtra("case",nextNum);               //뒤돌아 올 때를 대비하여 넣어줌
                //시작
                startActivity(it);

            }
        });
    }
}