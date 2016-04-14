package com.qijiabin.tcp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ========================================================
 * 日 期：2016年4月14日 上午9:45:03
 * 作 者：jiabin.qi
 * 版 本：1.0.0
 * 类说明：TCP Server端
 * TODO
 * ========================================================
 * 修订日期     修订人    描述
 */
public class TcpServer {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {
		// 1. 构造ServerSocket实例，指定服务端口。
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("服务端已在监听8888端口。。。。。。");
		
		while (true) {
			// 2. 调用accept方法，建立和客户端的连接
			Socket s = ss.accept();
			
			// 3. 获取连接的InputStream,OutputStream来进行数据读写
			BufferedOutputStream bos=new BufferedOutputStream(s.getOutputStream());
			bos.write(("client connection info is "+s.getInetAddress().getHostAddress()+":"+s.getPort()).getBytes());
			bos.flush();
			bos.close();
			
			// 4. 操作结束，关闭socket.
			s.close();
		}
	}

}

