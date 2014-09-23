package app.it15.test55410797;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AddActivity extends Activity{
	private EditText e1,e2 ;
	private Button save ;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.add);
	save = (Button) findViewById(R.id.btnsave);
	save.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			if(v == save){
				save();
		}
			
			
		}
});
}
	
		private Boolean save() {
			e1 = (EditText) findViewById(R.id.k1);
			e2 = (EditText) findViewById(R.id.k2);
			final AlertDialog .Builder adb = new AlertDialog.Builder(this);
			AlertDialog ad = adb.create();
			if(e1.getText().length() == 0){
				ad.setMessage("Please input name");
				e1.requestFocus();
			return false;	
		}
			if(e2.getText().length() == 0){
				ad.setMessage("Please input tel");
				e2.requestFocus();
				return false;
			}
			controlDB797 dbclass = new controlDB797(this);
			long savedata = dbclass.InsertData(e1.getText().toString(), e2.getText().toString());
			if(savedata <= 0){
				ad.setMessage("Error !!!");
				ad.show();
				return false;
			}
			Toast.makeText(getApplicationContext(),"Add Data Successfully", Toast.LENGTH_SHORT).show();
			return true;
		}
			
	
	

	
}

