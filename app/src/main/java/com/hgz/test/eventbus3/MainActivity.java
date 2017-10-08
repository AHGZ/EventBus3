package com.hgz.test.eventbus3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hgz.test.eventbus3.bean.Main2Tv1Bean;
import com.hgz.test.eventbus3.bean.Main2Tv2Bean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private TextView main_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_tv = (TextView) findViewById(R.id.main_tv);
        //注册
        EventBus.getDefault().register(this);
//        EventBus.getDefault().postSticky(new Main2Tv1Bean("粘性事件测试",0,""));
        //按钮点击事件，跳转界面
        main_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    @Subscribe
    public void getData1(Main2Tv1Bean event){
        main_tv.setText(event.getName()+","+event.getSex()+","+event.getAge());
    }
    @Subscribe
    public void getData2(Main2Tv2Bean event){
        main_tv.setText(event.getName()+","+event.getAge());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解注册
        EventBus.getDefault().unregister(this);
    }
}
