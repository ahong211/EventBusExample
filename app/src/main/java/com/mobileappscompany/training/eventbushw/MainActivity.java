package com.mobileappscompany.training.eventbushw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textView);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnIntent:

                Intent intent = new Intent(this, MyIntentService.class);
                intent.putExtra("tTSK", 5);
                startService(intent);

                break;

            case R.id.btnThread:

                new Thread(){
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            EventBus.getDefault().post(new MyEvent(650, "Thread done"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void myEventHandler(MyEvent event) {
        switch (event.getmEventCode()) {
            case 747:
                textView.setText(event.getmMessage());
                break;

            case 650:
                textView.setText(event.getmMessage());
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
