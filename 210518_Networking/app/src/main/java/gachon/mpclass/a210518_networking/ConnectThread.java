package gachon.mpclass.a210518_networking;

import android.util.Log;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ConnectThread extends Thread{
    String hostname;

    public ConnectThread(String addr) { hostname = addr; }

    public void run(){

        try{

            int port = 7777;

            Socket sock = new Socket(hostname, port);

            InputStream in = sock.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            Log.d("MainActivity", "서버에서 받은 메시지 : " + dis.readUTF());
            dis.close();
            sock.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
