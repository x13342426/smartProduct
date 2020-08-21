package WelcomeMsg;

import org.omg.CORBA.*; // All CORBA
import java.io.*; // needed for output to the file system .
public class WelcomeMsgClient {
       public static void main(String args[]) {      
        try {             
            // Initialize the ORB
            ORB orb = ORB.init(args, null);
            // Read the object Reference for the HelloServant
            BufferedReader br = new BufferedReader(new FileReader("WelcomeIOR"));
            String ior = br.readLine();
            // Convert the string object reference to an object
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            // Convert the object to the correct type i . e . Hello
            Welcomemsg welcomeRef = WelcomemsgHelper.narrow(obj);
           // Call theoperation on the servant
            String welcome = welcomeRef.welcomeMsg();
            System.out.println(welcome);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}


