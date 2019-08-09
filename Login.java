package jecrc.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SharedPreferences s;
     EditText u,p;
      TextView admin;
       Button lg,rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lg=(Button)findViewById(R.id.button);
        rg=(Button)findViewById(R.id.button2);
        u=(EditText)findViewById(R.id.editText);
        p=(EditText)findViewById(R.id.editText2);
        admin=(TextView)findViewById(R.id.textView3);

        s=getSharedPreferences("sp", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit=s.edit();

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=u.getText().toString();
                String pass=p.getText().toString();

                if(user.equals("admin")&& pass.equals("1234")){

                        edit.putString("k1",user);
                        edit.putString("k2",pass);
                        edit.commit();

                        u.setText(null);
                        p.setText(null);
                        u.requestFocus();

                    Intent i=new Intent(Login.this,Term_Condition.class);
                    startActivity(i);

                }

                else{

                    Toast.makeText(Login.this, "invalid pass.?", Toast.LENGTH_LONG).show();
                }
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Login.this,Admin_Quiz.class);
                startActivity(i);
            }
        });
    }
}
