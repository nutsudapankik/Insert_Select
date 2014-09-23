package app.it15.test55410797;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class ShowDataActivity extends Activity {
private ListView listView;

@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		listView = (ListView) findViewById(R.id.listView1);
		controlDB797 controldb797 = new controlDB797(this);
		ArrayList<HashMap<String, String>> MyArrayList = controldb797.SelectAllData();
		SimpleAdapter adapter;
		adapter = new SimpleAdapter(ShowDataActivity.this,
		MyArrayList, R.layout.show_item, new String[]{"MemberId","Name","Tel"},new int[]{R.id.colmemberid,R.id.colname,R.id.coltel});
		listView.setAdapter(adapter);
	}

}
