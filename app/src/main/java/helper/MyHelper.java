package helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHelper extends SQLiteOpenHelper {
    private static final String databaseName = "DictionaryDB";
    private static final int dbVersion =1;

    public MyHelper(Context context) {
        super(context, databaseName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE words " +
                "(" +
                "WordID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "Word TEXT, " +
                "Meaning TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String word,String meaning,SQLiteDatabase db){
        try{
            String query = "insert into words(Word,Meaning) values('"+ word +"','"+ meaning +"')";
            db.execSQL(query);
            return true;
        }catch (Exception e){
            Log.d("error : ",e.toString());
            return false;
        }

    }
}
