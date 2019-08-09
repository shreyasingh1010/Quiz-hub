package jecrc.quiz;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    int i=1;
     Quiz_db obj;
     TextView q;
     Button submit;
      RadioButton op1,op2,op3,op4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        op1=(RadioButton)findViewById(R.id.radioButton);
        op2=(RadioButton)findViewById(R.id.radioButton2);
        op3=(RadioButton)findViewById(R.id.radioButton3);
        op4=(RadioButton)findViewById(R.id.radioButton4);
        q=(TextView)findViewById(R.id.textView4);
        submit=(Button)findViewById(R.id.button5);

        obj=new Quiz_db(this);

        try{

            Cursor c=obj.get_quiz(i);

            if(c.getCount()==0){

                Toast.makeText(this, "data Not Found", Toast.LENGTH_LONG).show();
            }

            else{

                c.moveToFirst();

                q.setText(c.getString(1));
                op1.setText(c.getString(2));
                op2.setText(c.getString(3));
                op3.setText(c.getString(4));
                op4.setText(c.getString(5));
            }

        }catch (Exception t)
        {

        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i++;
                try{

                    Cursor c=obj.get_quiz(i);

                    if(c.getCount()==0){

                        Toast.makeText(Quiz.this, "data Not Found", Toast.LENGTH_LONG).show();
                    }

                    else{

                        c.moveToFirst();

                        q.setText(c.getString(1));
                        op1.setText(c.getString(2));
                        op2.setText(c.getString(3));
                        op3.setText(c.getString(4));
                        op4.setText(c.getString(5));
                    }

                }catch (Exception t)
                {

                }


            }
        });
    }
}
