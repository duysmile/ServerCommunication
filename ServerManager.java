/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermanager;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author duy21
 */
public class ServerManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ArrayList<Person> listAL = generateData();
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Server Started");
            while(true){
                Socket socket = server.accept();
                ThreadServer thread = new ThreadServer(socket, listAL, 8080);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static ArrayList<Person> generateData(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(13, "Anh"));
        list.add(new Person(15, "Bao"));
        list.add(new Person(16, "Cuc"));
        list.add(new Person(11, "Dao"));
        list.add(new Person(12, "Em"));
        list.add(new Person(17, "Giang"));
        list.add(new Person(18, "Hanh"));
        list.add(new Person(11, "Kien"));
        list.add(new Person(20, "Linh"));
        return list;
    }
}

