/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermanager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
/**
 *
 * @author duy21
 */
public class ThreadServer extends Thread{
    Socket socket;
    ArrayList<Person> list;
    int port;
    public ThreadServer(Socket socket, ArrayList<Person> list, int port){
        this.socket = socket;
        this.list = list;
        this.port = port;
    }
    public void run(){
        try {
            System.out.println("Co ket noi!");
            DataInputStream dis = new DataInputStream(this.socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(this.socket.getOutputStream());
            String input = dis.readUTF();
            Boolean check = dis.readBoolean();
            int output = searchPerson(input);
            if (output > 0){
                dos.writeUTF("Tuoi cua " + input + " la :" + output + "");
            } else if(check) {
                Socket soc = new Socket("localhost", port);
                DataOutputStream out = new DataOutputStream(soc.getOutputStream());
                DataInputStream in = new DataInputStream(soc.getInputStream());
                out.writeUTF(input);
                out.writeBoolean(false);
                dos.writeUTF(in.readUTF());
            } else {
                dos.writeUTF("Khong tim thay ten da nhap!");
            }
            this.socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public int searchPerson(String name){
        for (Person person : list) {
            if (person.getName().equals(name)){
                return person.getAge();
            }
        }
        return -1;
    }
}

