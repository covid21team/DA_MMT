/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 *
 * @author xyzsy
 */
public class Client {
    public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 1433; // Cổng mặc định của Echo Server
    public final static byte[] BUFFER = new byte[10000]; // Vùng đệm chứa dữ liệu cho gói tin nhận
 
    private static int q = 353;
    private static int a = 3;;
    
    public static void main(String[] args) {
        DatagramSocket ds = null;
        String str = "";
        int key;
        int keyServer = 1;
        int checkSend = 0;
        try {
            ds = new DatagramSocket(); // Tạo DatagramSocket
            System.out.println("Client started ");
 
            InetAddress server = InetAddress.getByName(SERVER_IP);
            while (true) {
                if(checkSend == 0){
                    // Tạo gói tin gởi
                    DatagramPacket khoa = new DatagramPacket("Lấy khóa".getBytes(), "Lấy khóa".getBytes().length, server, SERVER_PORT);
                    ds.send(khoa); // Send gói tin sang Echo Server

                     // nhận khóa công khai từ server
                    DatagramPacket incoming1 = new DatagramPacket(BUFFER, BUFFER.length);
                    ds.receive(incoming1); // Chờ nhận dữ liệu từ EchoServer gởi về

                    keyServer = Integer.parseInt(new String(incoming1.getData(), 0, incoming1.getLength()));
                    System.out.println("Khoa cong khai server: " + new String(incoming1.getData(), 0, incoming1.getLength()));
                    
                    checkSend = 1;
                }
                
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhap van ban: ");
                str = sc.nextLine();
                System.out.print("Nhap khoa: ");
                key = sc.nextInt();
                
                //Tạo khóa công khai
                int keyPublic  = (int)Math.pow(a, tinh(key)) % q;
                //Tạo khóa bí mật chung
                int keyPrivate = (int)Math.pow(keyServer, key) % q;
                
                String text = encode(str, keyPrivate);
                byte[] data = (text+"@"+keyPublic).getBytes(); // Đổi chuỗi ra mảng bytes
 
                // Tạo gói tin gởi
                DatagramPacket dp = new DatagramPacket(data, data.length, server, SERVER_PORT);
                ds.send(dp); // Send gói tin sang Echo Server
 
                // Gói tin nhận
                DatagramPacket incoming = new DatagramPacket(BUFFER, BUFFER.length);
                ds.receive(incoming); // Chờ nhận dữ liệu từ EchoServer gởi về
 
                // Đổi dữ liệu nhận được dạng mảng bytes ra chuỗi và in ra màn hình
                System.out.println("So luong xuat hien cua cac chu cai: " + new String(incoming.getData(), 0, incoming.getLength()));
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
    
    private static String encode(String str, int key){
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
    
    private static int tinh(int a){
        int tong = 0;
        do{
            int temp = a%10;
            a = a/10;
            tong += temp;
        }while(a > 0);
        
        return tong;
    }
}
