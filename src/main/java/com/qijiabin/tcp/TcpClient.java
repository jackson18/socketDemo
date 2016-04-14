package com.qijiabin.tcp;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * ========================================================
 * 日 期：2016年4月14日 上午9:48:42
 * 作 者：jiabin.qi
 * 版 本：1.0.0
 * 类说明：Tcp Client端
 * TODO
 * ========================================================
 * 修订日期     修订人    描述
 */
public class TcpClient {

	public static void main(String[] args) throws IOException {
		// 1.根据指定的server地址和端口，建立socket连接。  
		Socket client = new Socket("192.168.1.87", 8888);  
		  
		// 2. 根据socket实例获取InputStream, OutputStream进行数据读写。  
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeUTF("Hello from " + client.getLocalSocketAddress());
		
		BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
		byte buf[] = new byte[1024];
		int ret ;
		while ((ret = bis.read(buf)) != -1) {
			System.out.println("server say: " + new String(buf, 0, ret));
			ret = bis.read(buf);
		}
		
		//3.操作结束，关闭socket.  
		client.close();  
	}
	
}

