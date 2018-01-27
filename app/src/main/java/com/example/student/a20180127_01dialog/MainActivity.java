package com.example.student.a20180127_01dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     TextView tv,tv2, tv3;
     int ch1, temp1;
     boolean chk1[] = new boolean[4];
     boolean temp2[] = new boolean[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
    }

    public void click5 (View v){
        final String data[] = {"香蕉", "芭樂", "蘋果", "橘子"};
        temp2 = chk1.clone();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("多選");
        builder.setMultiChoiceItems(data, temp2, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            StringBuilder sb = new StringBuilder();
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chk1 = temp2.clone();
                for (int i = 0 ; i<=3; i++){
                    if(chk1[i]){
                        sb.append(data[i]);
                    }
                }
                tv3.setText(sb.toString());
            }
        });
        builder.show();
    }


    public void click6(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogv = inflater.inflate(R.layout.mydialog, null);
        Button btn6 = dialogv.findViewById(R.id.button6);
        final TextView tv4 = dialogv.findViewById(R.id.textView4);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv4.setText("Hello");
            }
        });
        builder.setView(dialogv);

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下確定", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    public void click1 (View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("這是標題");
        builder.setMessage("內容");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下確定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("幫助?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下幫助", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void click2 (View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("請輸入文字");
        final EditText ed = new EditText(this);
        builder.setView(ed);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText(ed.getText().toString());
            }
        });
        builder.show();
    }

    public void click3 (View v){
        final String data[] = {"香蕉", "芭樂", "蘋果", "橘子"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("請選擇");
        builder.setCancelable(false);
        builder.setItems(data, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, data[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    public void click4 (View v){
        final String data[] = {"香蕉", "芭樂", "蘋果", "橘子"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("單選");
        temp1 = ch1;
        builder.setSingleChoiceItems(data, temp1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                temp1 = which;
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ch1 = temp1;
                Toast.makeText(MainActivity.this, which + "你選擇了 : " + ch1 + data[ch1], Toast.LENGTH_SHORT).show();
                tv2.setText(data[ch1]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, which + "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }



}
