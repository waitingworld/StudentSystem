package com.gs.utils;


import java.net.*;
import java.io.*;

public class Server{
    Server(){
        try{
            // create server 7920 
            ServerSocket server= new ServerSocket(7920);

            while(true){
                Socket socket = server.accept(); //wait for client

                // Deprecated
                // DataInputStream dis = new DataInputStream(new BufferedInputStream(
                //		socket.getInputStream()));
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(socket.getOutputStream()));

                // receive data
                String str = br.readLine();
                str = str.trim();
                String arr[] = str.split("\\s+");

                // calculate
                int sum = 0;
                for(String num:arr){
                    // num = new String(num.getBytes("ascii"));
                    sum += Integer.parseInt(num);
                }

                // send sum
                dos.writeBytes(""+sum+"\n");
                dos.flush();

                // print
                // System.out.println(str);
                // System.out.println(sum);


                // close all
                br.close();
                dos.close();
                socket.close();
            }

        }catch(Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        new Server();
    }
}