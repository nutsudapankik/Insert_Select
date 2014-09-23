package app.it15.test55410797;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
 

public class MainActivity extends Activity {
private Button insert,show;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	insert = (Button) findViewById(R.id.btninsert);
	insert.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent2 = new Intent(getApplicationContext(),AddActivity.class);
			startActivity(intent2);
			
		}
	});
	show = (Button) findViewById(R.id.btnshow);
	show.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent1 = new Intent(getApplicationContext(),ShowDataActivity.class);
			startActivity(intent1);
		}
	});
}
   

   
}
