package com.example.administrator.testapplication;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResolCheckView extends LinearLayout {
    private TextView text1;
    private TextView text2;
    private OnResolCheckLisenter onResolCheckLisenter;

    public ResolCheckView(Context context) {
        super(context);
        initView(context);
    }

    public ResolCheckView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ResolCheckView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.resol_check_view, null);
        text1 = (TextView)view.findViewById(R.id.text1);
        text2 = (TextView)view.findViewById(R.id.text2);
        text1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setActivated(true);
                text2.setActivated(false);
                text1.setTextColor(Color.BLACK);
                text2.setTextColor(Color.WHITE);
                if(onResolCheckLisenter != null){
                    onResolCheckLisenter.onResolCheck(text1.getText().toString());
                }


            }
        });
        text2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setActivated(false);
                text2.setActivated(true);
                text2.setTextColor(Color.BLACK);
                text1.setTextColor(Color.WHITE);
                if(onResolCheckLisenter != null){
                    onResolCheckLisenter.onResolCheck(text2.getText().toString());
                }
            }
        });
        LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT);
        addView(view , layoutParams);

    }


    /**
     * set default diplay
     * @param checkId
     */
    public void setDefaultDisplay(int checkId){
        if(checkId == 0){
            text1.setActivated(true);
            text2.setActivated(false);
            text1.setTextColor(Color.BLACK);
            text2.setTextColor(Color.WHITE);
        }else{
            text1.setActivated(false);
            text2.setActivated(true);
            text2.setTextColor(Color.BLACK);
            text1.setTextColor(Color.WHITE);
        }
    }


    /**
     * set value
     * @param str1
     * @param str2
     */
    public void setValue(String str1 , String str2){
        text1.setText(str1);
        text2.setText(str2);
    }


    /**
     * set lisenter
     * @param onResolCheckLisenter
     */
    public void setOnResolCheckLisenter(OnResolCheckLisenter onResolCheckLisenter){
        this.onResolCheckLisenter = onResolCheckLisenter;
    }


    interface OnResolCheckLisenter{
        void onResolCheck(String value);
    }

}
