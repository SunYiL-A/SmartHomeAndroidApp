package com.example.sll;



import com.InterNet.www.Net;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	Net tt=new Net();
	Handler h;
	TextView tex1;
	TextView tex2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tex1=(TextView) findViewById(R.id.te4);//温度
        tex2=(TextView) findViewById(R.id.te3);//湿度
        
        h=new Handler(){
        	@Override
       	public void handleMessage(Message msg) {
        		
        		super.handleMessage(msg);
        		Bundle b=msg.getData();
      		String str=b.getString("wendu");
        		tex1.setText(str);
        		String str1=b.getString("shidu");
        		tex2.setText(str1);
        	}
        };
        
        
        tt.NetLink(h);//等待客户端接入
        
    }
    

}
