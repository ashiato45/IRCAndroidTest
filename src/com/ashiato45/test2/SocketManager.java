package com.ashiato45.test2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketManager {
	public Socket soc;

	public SocketManager(){
		try {
			soc = new Socket("192.168.1.230", 6667);
		} catch (UnknownHostException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}




}
