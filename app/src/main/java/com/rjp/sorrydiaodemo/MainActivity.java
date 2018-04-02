package com.rjp.sorrydiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText msg1 = (EditText) findViewById(R.id.msg1);
        EditText msg2 = (EditText) findViewById(R.id.msg2);
        EditText msg3 = (EditText) findViewById(R.id.msg3);
        EditText msg4 = (EditText) findViewById(R.id.msg4);
        EditText msg5 = (EditText) findViewById(R.id.msg5);
        EditText msg6 = (EditText) findViewById(R.id.msg6);
        EditText msg7 = (EditText) findViewById(R.id.msg7);
        EditText msg8 = (EditText) findViewById(R.id.msg8);
        EditText msg9 = (EditText) findViewById(R.id.msg9);

    }
}
