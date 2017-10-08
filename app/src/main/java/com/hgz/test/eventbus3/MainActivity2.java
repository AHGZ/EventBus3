package com.hgz.test.eventbus3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hgz.test.eventbus3.bean.Main2Tv1Bean;
import com.hgz.test.eventbus3.bean.Main2Tv2Bean;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/9/27.
 */

public class MainActivity2 extends AppCompatActivity{

    private TextView main2_tv1;
    private TextView main2_tv3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        main2_tv1 = (TextView) findViewById(R.id.main2_tv1);
        TextView main2_tv2 = (TextView) findViewById(R.id.main2_tv2);
        main2_tv3 = (TextView) findViewById(R.id.main2_tv3);
        //注册
//        EventBus.getDefault().register(this);
    }
//    @Subscribe(sticky = true)
//    public void getData(Main2Tv1Bean event){
//        main2_tv3.setText(event.getName());
//    }
    public void tv1(View view) {
        EventBus.getDefault().post(new Main2Tv1Bean("张三",20,"男"));
        finish();
    }

    public void tv2(View view) {
        EventBus.getDefault().post(new Main2Tv2Bean("李四",22));
        finish();
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }
}
