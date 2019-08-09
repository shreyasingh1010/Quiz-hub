package jecrc.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    SharedPreferences obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=getSharedPreferences("sp",0);

              final String user=obj.getString("k1",null);
        final String password=obj.getString("k2",null);

        Thread th=new Thread()
        {
          public void run(){
              try{
                 sleep(3000);

              }catch (Exception t)
              {

              }finally {

                  if(user!=null && password!=null) {
                      Intent obj = new Intent(Splash.this, Term_Condition.class);

                      startActivity(obj);
                      finish();
                  }

                  else{

                      Intent obj = new Intent(Splash.this, Login.class);

                      startActivity(obj);
                      finish();
                  }
              }


          }

        };
        th.start();
    }
}
