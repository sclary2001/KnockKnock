import java.net.*;
import java.io.*;

public class KnockKnockServer {
    public static void main(String[] args) throws IOException {
       
        int portNumber = 4444;
        System.out.println("Starting Knock-Knock Server on port " + portNumber);

        // TODO 1: Open a ServerSocket on the portNumber
        ServerSocket serverSocket = new ServerSocket(portNumber);
        // TODO 2: Call accept() to wait for a client to knock on the door
        Socket clientSocket = serverSocket.accept();
        // TODO 3: Set up your PrintWriter (with auto-flush) and BufferedReader
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        // TODO 4: Instantiate the KnockKnockProtocol "brain" (e.g., kkp)
        KnockKnockProtocol kkp = new KnockKnockProtocol();
        
        String inputLine, outputLine;
        

        // TODO 5: Get the very first message from the protocol by passing it 'null'
        
        outputLine = kkp.processInput(null);

        // outputLine = kkp.processInput(null);
        
        // Then, send that outputLine to the client using your PrintWriter!
        out.println(outputLine);

        // TODO 6: Create a while loop that constantly reads from the client (in.readLine())
        while ((inputLine = in.readLine()) != null) {
            // Inside the loop:
            //   - Print what the client says to the console.
            System.out.println("Client " + inputLine);
            //   - Pass the client's input into kkp.processInput()
            outputLine = kkp.processInput(inputLine);
            //   - Send the resulting string back to the client
            out.println(outputLine);
            //   - If the protocol returns "Bye.", break the loop.
            if (outputLine.equals("Bye."))
                break;
        }
        // Inside the loop:

    
        //   - Pass the client's input into kkp.processInput()
        //   - Send the resulting string back to the client
        //   - Pass the client's input into kkp.processInput()
        //   - Send the resulting string back to the client
        //   - If the protocol returns "Bye.", break the loop.

        // TODO 7: Close your sockets and streams!
        // Hi Sean
    }
}