package com.example.administrator.testapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView)findViewById(R.id.texttest);

        ResolCheckView resolCheckView = (ResolCheckView)findViewById(R.id.resol);
        resolCheckView.setValue("720*1280" , "1920*1080");
        resolCheckView.setDefaultDisplay(0);
        resolCheckView.setOnResolCheckLisenter(new ResolCheckView.OnResolCheckLisenter() {
            @Override
            public void onResolCheck(String value) {
                textView.setText("你选中了 --- "+value);
            }
        });
    }
}
