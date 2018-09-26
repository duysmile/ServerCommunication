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
public class ServerManager2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ArrayList<Person> listMZ = generateData();
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server Started");
            while(true){
                Socket socket = server.accept();
                ThreadServer thread = new ThreadServer(socket, listMZ, 8000);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static ArrayList<Person> generateData(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(23, "Minh"));
        list.add(new Person(17, "Nuong"));
        list.add(new Person(14, "Oanh"));
        list.add(new Person(11, "Phuong"));
        list.add(new Person(10, "Ron"));
        list.add(new Person(17, "Son"));
        list.add(new Person(18, "Tien"));
        list.add(new Person(21, "Vy"));
        return list;
    }
}

