package com.qijiabin.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ========================================================
 * 日 期：2016年4月14日 上午10:45:56
 * 作 者：jiabin.qi
 * 版 本：1.0.0
 * 类说明：
 * TODO
 * ========================================================
 * 修订日期     修订人    描述
 */
public class UdpServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 1. 构建DatagramSocket实例，指定本地端口。  
		DatagramSocket socket = new DatagramSocket(8888);  
		System.out.println("服务端已在监听8888端口。。。。。。");
		  
		// 2. 构建需要收发的DatagramPacket报文  
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);  
		  
		while(true)  
		{  
		    // 3. 收报文  
		    socket.receive(packet);  
		    System.out.println("Handling client at " + packet.getAddress().getHostAddress() + " on port " + packet.getPort());  
		    // 4. 发报文  
		    socket.send(packet);  
		    packet.setLength(1024);  
		}
	}
	
}
