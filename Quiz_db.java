package jecrc.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Quiz_db extends SQLiteOpenHelper {
    public Quiz_db(Context context) {
        super(context, "Quiz_projct",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String ques="create table question(id integer primary key autoincrement,q text,op1 text,op2 text,op3 text,op4 text,ans text)";

        String reg="create table regitration(user text primary key,password text)";

        sqLiteDatabase.execSQL(ques);
        sqLiteDatabase.execSQL(reg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void add_quiz(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("q",qs);
        cv.put("op1",p1);
        cv.put("op2",p2);
        cv.put("op3",p3);
        cv.put("op4",p4);
        cv.put("ans",anss);
        d.insert("question",null,cv);
        d.close();

    }


    public void user_reg(String us,String ps){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("user",us);
        cv.put("password",ps);

        d.insert("regitration",null,cv);
        d.close();

    }

    public Cursor get_quiz(int idd){
        SQLiteDatabase d=this.getWritableDatabase();
        String qus="select* from question where id="+idd+"";

        Cursor c= d.rawQuery(qus,null);


        return c;

    }
}
