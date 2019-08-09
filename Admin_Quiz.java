package jecrc.quiz;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Quiz extends AppCompatActivity {

     Quiz_db obj;
     Button k;
     EditText q,op1,op2,op3,op4,ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__quiz);
        q=(EditText)findViewById(R.id.editText6);
        op1=(EditText)findViewById(R.id.editText7);
        op2=(EditText)findViewById(R.id.editText8);
        op3=(EditText)findViewById(R.id.editText9);
        op4=(EditText)findViewById(R.id.editText10);
        ans=(EditText)findViewById(R.id.editText11);
        k=(Button)findViewById(R.id.button4);

        obj=new Quiz_db(this);

        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                obj.add_quiz(q.getText().toString(),op1.getText().toString(),op2.getText().toString(),op3.getText().toString(),op4.getText().toString(),ans.getText().toString());

                Toast.makeText(Admin_Quiz.this, "Inserted...", Toast.LENGTH_LONG).show();

                q.setText(null);
                op1.setText(null);
                op2.setText(null);
                op3.setText(null);
                op4.setText(null);
                ans.setText(null);
            }

        });
    }
}
