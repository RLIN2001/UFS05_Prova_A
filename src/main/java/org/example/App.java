package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        String hostname="127.0.0.1";
        int portNumber=1234;

        try{
            Socket socket=new Socket(hostname,portNumber);
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));

            String userInput;


            while(true)
            {
                if((userInput = stdIn.readLine())!=null) {

                    out.println(userInput);
                }

            }


        }
        catch (UnknownHostException e)
        {
            System.err.println("don't know about host "+hostname);
            System.exit(1);
        }
        catch (IOException e)
        {
            System.err.println("Couldn't get I/O for the connection to "+hostname);
            System.exit(1);
        }

    }
}
