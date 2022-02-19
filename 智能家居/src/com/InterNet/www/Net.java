package com.InterNet.www;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

//等待客户端接入，接收客户端的值。

class data{//数据处理
	public Bundle DataHandle(String tt){
		String get1[];
		String get4[];
		String get5[];
		String get2;
		String get3;
	    get1= tt.split(" " );
	    
	    get2=get1[0];
	    get3=get1[1];
	    get4=get2.split(":");
	    get5=get3.split(":");
	    Bundle b = new Bundle();
		b.putString("wendu", get4[1]);
		b.putString("shidu"  , get5[1]);
		return b;
	}
}

public class Net {

			public void NetLink(final Handler h){
					
				 new Thread( new Runnable() {
					public void run() {
						
						
						try {
										
												ServerSocket socket=new ServerSocket(9080);
																			
												while(true){
																						final Socket con=socket.accept();
																						
																						new Thread(new Runnable() {
																							public void run() {
																							
																							try {
																									
																								InputStream in=con.getInputStream();
																								byte[] data = new byte[128];
																								int len = in.read(data);
																								String str = new String(data,0,len);
																								Message msg = new Message();
																								
																								Bundle b = new Bundle();
																								//b.putString("msg", str);
																								b=new data().DataHandle(str);
																								msg.setData(b);
																								
																								h.sendMessage(msg);
																							
																							} catch (IOException e) {
																								// TODO Auto-generated catch block
																								e.printStackTrace();
																							}	
																							
																							}				
																						}).start();
																						
														
																						
													}
																	
														
													} catch (IOException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												
							}
				}).start();
			
			}	
			
}
