package com.gs.utils;

import java.net.*;
import java.io.*;
import java.util.Random;

public class Client {
    private Socket socket;
    Client(){
        try{
            socket=new Socket("localhost", 7920);
            Random rand = new Random(System.currentTimeMillis());

            // DataInputStream dis = new DataInputStream(new BufferedInputStream(
            // socket.getInputStream()));
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));

            String str = new String();
            for(int i=1; i<10; i++){
                str += rand.nextInt(100) + " ";
            }
            str += "\n";

            // send data
            dos.writeBytes(str);
            dos.flush();

            // receive
            String res = br.readLine();

            // print res
            res = res.trim();
            // int ans = Integer.parseInt(res);
            System.out.println(res);

            // close all
            dos.close();
            br.close();
            socket.close();

        }catch(Exception e){
            System.out.println("Error client");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Client();
    }
}
