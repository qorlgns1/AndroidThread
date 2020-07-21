package naver.rlgns1129.androidthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnstart;
    private TextView txtdisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtdisplay = (TextView)findViewById(R.id.txtdisplay);
        btnstart = (Button)findViewById(R.id.btnstart);

        //스레드를 사용하지 않고 작업을 수행
        //스레드를 사용하지 않고 호하면 갱시나는 작업을 하면
        //작업이 모두 종료되고 화면 갱신이 수행됩니다.
//        int val = 0;
//        for(int i =0; i<20; i=i+1){
//            try{
//                txtdisplay.setText(val++ + "");
//                Thread.sleep(1000);
//            }catch (Exception e){
//                Log.e("스레드테스트","스레드오류");
//            }
//        }

        Thread th = new Thread(){
            //스레드로 수행할 내용을 작성하는 메소드
            public void run(){
                int val = 0;
                for(int i=0; i<20; i=i+1){
                    try{
                        txtdisplay.setText(val++ + "");
                        Log.e("val", val+"");
                        Thread.sleep(1000);
                    }catch(Exception e){}
                }
            }
        };
        //스레드 시작
        th.start();


    }
}