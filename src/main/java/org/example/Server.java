package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class Server {

    static ArrayList<Food> foods= new ArrayList<>();
    static int portNumber = 1234;
    static PrintWriter out;
    static Gson gson = new Gson();
    static String json;

    public static void main(String[] args) {

        System.out.println("Start Server");


        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println("create socket failed");
            e.printStackTrace();
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed");
            e.printStackTrace();
        }

        buildFoodList();
        System.out.println("Accettato");
        try {
            out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Write failed");
            e.printStackTrace();
        }


        BufferedReader in = null;

        try {
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            System.out.println("reader failed");
            e.printStackTrace();
        }

        String s = "";
        try {
            while ((s = in.readLine()) != null) {

                System.out.println(s);
                for(int i=0;i<foods.size();i++)
                    System.out.println(foods.get(i).getName());

             }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void buildFoodList() {
        foods.add(new Food("Il piatto...",3,"Risotto alla milanese", 25.94));
        foods.add(new Food("Il famoso piatto...",34,"Costata", 33.0));
        foods.add(new Food("Il piatto poco famoso...",50,"Pasta con il pomodoro", 10.0));
    }
}