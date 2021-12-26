/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author xyzsy
 */
public class Server {
    public final static int SERVER_PORT = 1433; // Cổng mặc định của Echo Server
    public final static byte[] BUFFER = new byte[10000]; // Vùng đệm chứa dữ liệu cho gói tin nhận
 
    private static int q = 353;
    private static int a = 3;
    
    public static void main(String[] args) {
        DatagramSocket ds = null;
        int key = 2;
        //Tạo khóa công khai
        int keyPublic = (int)Math.pow(a, key) % q;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            ds = new DatagramSocket(SERVER_PORT); // Tạo Socket với cổng là 7
            System.out.println("Server started ");
            System.out.println("Waiting for messages from Client ... ");
 
            while (true) { 
                // Tạo gói tin nhận
                DatagramPacket incoming = new DatagramPacket(BUFFER, BUFFER.length);
                ds.receive(incoming); // Chờ nhận gói tin gởi đến
 
                // Lấy dữ liệu khỏi gói tin nhận
                String message = new String(incoming.getData(), 0, incoming.getLength());
                System.out.println("Van ban nhap duoc: " + message);
                
                //kiểm tra yêu cầu
                if(message.equals("Lấy khóa")){
                    //Gửi khóa công khai
                    DatagramPacket outsending = new DatagramPacket((keyPublic+"").getBytes(), (keyPublic+"").getBytes().length,
                        incoming.getAddress(), incoming.getPort());
                    ds.send(outsending);
                }else{
                    //Lấy khóa công khai của client
                    String[] str = message.split("@");
                    int keyClient = Integer.parseInt(str[1]);
                    
                    //Tạo khóa bí mật chung
                    int keyPrivate = (int)Math.pow(keyClient, key) % q;
                    System.out.println("Khoa bi mat chung: " + keyPrivate);
                    
                    //Giải mã
                    String text = decode(str[0], 26-keyPrivate);
                    System.out.println("bản rõ: " + text);

                    //Đếm số lượng 
                    List<String> chucai = new ArrayList<String>();

                    for(int i = 0; i < text.length(); i ++){
                        if(check(chucai, String.valueOf(text.charAt(i)))){
                            chucai.add(String.valueOf(text.charAt(i)));
                        }
                    }

                    String send = "";
                    int dem = 0;
                    for(int i = 0; i < chucai.size(); i ++)
                    {
                        for(int j = 0; j < text.length(); j ++){
                            String kytu = String.valueOf(text.charAt(j));
                            if(chucai.get(i).equals(kytu)){
                                dem ++;
                            }
                        }
                        if(i == chucai.size()-1){
                            send += chucai.get(i)+":"+dem;
                        }else{
                            send += chucai.get(i)+":"+dem+"-";
                        }
                        dem = 0;
                    }


                    // Tạo gói tin gởi chứa dữ liệu vừa nhận được
                    DatagramPacket outsending = new DatagramPacket(send.getBytes(), send.getBytes().length,
                            incoming.getAddress(), incoming.getPort());
                    ds.send(outsending);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
    
    private static String decode(String str, int key){
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                char ch = (char) (((int) str.charAt(i) +
                        key - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) str.charAt(i) +
                        key - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }
    
    private static boolean check(List<String> chucai, String str){
        for(int i = 0; i < chucai.size(); i ++){
            if(chucai.get(i).equals(str)){
                return false;
            }
        }
        return true;
    }
}
