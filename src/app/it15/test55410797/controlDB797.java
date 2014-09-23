package app.it15.test55410797;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class controlDB797 extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "mydata797";
	private static final String TABLE_MEMBER = "member";
	private static final int DATABASE_VERSION = 1;

	public controlDB797(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+"(MemberId INTEGER PRIMARY KEY AUTOINCREMENT ,"
				+"Name TEXT (100) ," + "Tel CHAR (10));");
		Log.d("CREATE TABLE" , "Create Table Successfully");
		
	}
public long InsertData(String strName , String strTel){
	try{
		SQLiteDatabase db;
		db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("Name", strName);
		values.put("Tel", strTel);
		long k = db.insert(TABLE_MEMBER, null,values);
		db.close();
		return k ;
	}catch (Exception e){
		return -1;
	}
	}



	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEMBER);
		onCreate(db);
		
	}
	
	//Check Data
		public String[] CheckData(String strMemberID) {
		    try {
		        String arrData[] = null;
		        SQLiteDatabase db;
		        db = this.getReadableDatabase();

		        Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*" },
		                "MemberId=?", new String[] { String.valueOf(strMemberID) },
		                null, null, null);
		        if (cursor != null) {
		            if (cursor.moveToFirst()) {
		                arrData = new String[cursor.getColumnCount()];
		                arrData[0] = cursor.getString(0);
		                arrData[1] = cursor.getString(1);
		                arrData[2] = cursor.getString(2);
		            }
		        }
		        cursor.close();
		        db.close();
		        return arrData;

		    } catch (Exception e) {
		        return null;
		    }
		}

//Select All	
		public ArrayList<HashMap<String, String>> SelectAllData(){
			try{
				ArrayList<HashMap<String, String>> MyArrayList = new ArrayList<HashMap<String,String>>();
				HashMap<String, String> map;			
				SQLiteDatabase db;
				db = this.getReadableDatabase();
				
				String strSQL = "SELECT * FROM "+ TABLE_MEMBER;
				Cursor cursor = db.rawQuery(strSQL, null);
				if(cursor != null){
					if(cursor.moveToFirst()){
						do{
							map = new HashMap<String, String>();
							map.put("MemberId", cursor.getString(0));
							map.put("Name", cursor.getString(1));
							map.put("Tel", cursor.getString(2));
							MyArrayList.add(map);
						}while (cursor.moveToNext());
					}
				}
				cursor.close();
				db.close();
				return MyArrayList;
			
			}catch (Exception e){
				return null;
			}				
		}
		
}

