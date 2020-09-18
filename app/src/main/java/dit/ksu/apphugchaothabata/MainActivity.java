package dit.ksu.apphugchaothabata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {
    //ประกาศตัวแปร
    Handler handler;
    Runnable runnable;
    long delay_time;
    long time = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ควบคุมการทำงาน
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intent);
                finish();
            }
        };
}  // end oncreate

public void onResume(){
        super.onResume();
        //ควบคุมการทำงาน
    delay_time = time;
    handler.postDelayed(runnable,delay_time);
    time = System.currentTimeMillis();
}  // end onresume

    public void onPause(){
        super.onPause();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }

}