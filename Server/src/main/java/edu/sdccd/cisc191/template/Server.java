package edu.sdccd.cisc191.template;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This program is a server that takes connection requests on
 * the port specified by the constant LISTENING_PORT.  When a
 * connection is opened, the program sends the current time to
 * the connected socket.  The program will continue to receive
 * and process connections until it is killed (by a CONTROL-C,
 * for example).  Note that this server processes each connection
 * as it is received, rather than creating a separate thread
 * to process the connection.
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Scores score;
    private Scores[] scoreList;
    private int currentAssign;
    private Scanner scnr;
    private Server server;
    private Stage stage;



   /* public void start(int port) throws Exception {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            CustomerRequest request = CustomerRequest.fromJSON(inputLine);
            CustomerResponse response = new CustomerResponse(request.getId(), "Jane", "Doe");
            out.println(CustomerResponse.toJSON(response));
        }

    } */

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public void start() {

        System.out.println("Welcome to the score tracker!");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("To input new scores, type 'n'");
        System.out.println("To check old scores, type 'o");
        System.out.println("To quit, type 'q'");
       menu();

    }
    public static void menu() {
        Scores score = new Scores();
        Scanner scnr = new Scanner(System.in);
        String menuInput = scnr.next();
        char menu = menuInput.charAt(0);
        switch (menu){
            case 'n':
                score.newScores();
                break;

            case 'o':
                System.out.print(score.getScoreList());
                break;
            case 'q':
                System.out.println("Closing....");
                break;

            default:
                System.out.println("Invalid input");
        }
    }
    public void plsWork () {
        Application.launch(GUI.class);
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        Scores scores = new Scores();
        GUI gui = new GUI();
        /*
        try {
            server.start(4444);
            server.stop();
        } catch(Exception e) {
            e.printStackTrace();
        } */

        server.start();
        server.plsWork();





    }
} //end class Server
