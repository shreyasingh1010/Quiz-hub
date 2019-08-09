package jecrc.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Term_Condition extends AppCompatActivity {

    Button skp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term__condition);
        skp=(Button)findViewById(R.id.button3);
        skp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj=new Intent(Term_Condition.this,Quiz.class);

                startActivity(obj);
            }
        });
    }
}
