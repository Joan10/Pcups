package com.pr.prova;
import java.io.IOException;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	boolean actiu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
    }

    protected void onDestroy() {
        super.onDestroy();
        actiu = false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public void ToggleButton(View view){
    	
    	Thread cpdaemon = new Thread()
    	{
    	    @Override
    	    public void run() {
    	    	Process process = null;
    	        try {
    	            while(actiu) {
    	                sleep(4000);
    	                try {
							process = Runtime.getRuntime().exec("cp -fr /sdcard/DCIM/100ANDRO/ /sdcard/imgcop/");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    	            }
    	        } catch (InterruptedException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	};
    	
    	actiu = !actiu;
    	if (actiu) {
            
            try {
            	Runtime.getRuntime().exec("mkdir /sdcard/imgcop");
            	
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
    		cpdaemon.start();	
    	}
    	
    }
    
}
