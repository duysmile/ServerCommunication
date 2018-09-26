/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermanager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author duy21
 */
public class Client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 8080);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ten can tim: ");
            String input = sc.nextLine();
            dos.writeUTF(input);
            dos.writeBoolean(true);
            System.out.println(dis.readUTF());
        } catch (Exception e) {
        }
    }
}
