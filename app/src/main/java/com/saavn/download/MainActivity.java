package com.saavn.download;

import android.app.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.*;
import java.io.*;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);		
		
	}
	
	public void save(View v) throws IOException
	{
		EditText ed=(EditText)findViewById(R.id.et);
		File a= new File(Environment.getExternalStorageDirectory()+File.separator+"Android"+File.separator+"data"+File.separator+"com.saavn.android"+File.separator+"songs");
		File b=new File(a,"curr.mp3");
		File c=new File (a,"curr.mp4");
		File d= new File(Environment.getExternalStorageDirectory(),ed.getText().toString()+".mp3");
		
		if(b.exists()==true){
		copy co=new copy(b,d);}
		else if(c.exists()==true){
			copy co=new copy(c,d);
		}
		else{
			ed.setText("please play song");
		}
	}


	public void clr(View v){
		EditText ed=(EditText)findViewById(R.id.et);
		ed.setText("");
		
	}
	
	
}



 class copy{
	
	 copy(File src, File dst) throws IOException {
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);

		// Transfer bytes from in to out
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}
	
}
