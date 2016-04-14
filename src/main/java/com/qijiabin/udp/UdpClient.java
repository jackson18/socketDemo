package com.qijiabin.udp;

import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ========================================================
 * 日 期：2016年4月14日 上午10:49:03
 * 作 者：jiabin.qi
 * 版 本：1.0.0
 * 类说明：
 * TODO
 * ========================================================
 * 修订日期     修订人    描述
 */
public class UdpClient {

	public static void main(String[] args) throws Exception {
		// 1. 构造UDP DatagramSocket对象  
		DatagramSocket socket = new DatagramSocket();  
		  
		// 2。指定timeout时间，防止进入无限等待状态  
		socket.setSoTimeout(3000);  
		  
		// 3. 构造收发的报文对象  
		byte[] buf = "hello world".getBytes();
		InetSocketAddress iSocketAddress = new InetSocketAddress("192.168.1.87",8888);
		DatagramPacket sendPacket=new DatagramPacket(buf, buf.length, iSocketAddress);
		DatagramPacket receivePacket = new DatagramPacket(buf, buf.length, iSocketAddress);
		  
		// 4.指定尝试的次数  
		int MAXTRIES = 10;
		int tries = 0;  
		boolean receivedResponse = false;  
		do {  
		    socket.send(sendPacket);  
		    try {  
		        socket.receive(receivePacket);  
		        receivedResponse = true;  
		    } catch(InterruptedIOException e) {  
		        tries += 1;  
		        System.out.println("Timed out, " + (MAXTRIES - tries) + "");  
		    }  
		} while ((!receivedResponse) && (tries < MAXTRIES));  
		  
		// 根据是否接收到报文进行反馈  
		if (receivedResponse) {  
		    System.out.println("Received: " + new String(receivePacket.getData()));  
		} else {  
		    System.out.println("No response -- giving up.");  
		}  
		  
		// 5. 关闭socket  
		socket.close();  
	}
	
}
