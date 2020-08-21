
package jmDns;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

// This code is adapted from https://github.com/jmdns/jmdns
public class ExampleServiceRegistration {

    public static void main(String[] args) throws InterruptedException {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Register a service
            
            ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "product_service", 9090, "test_Service_text");
            jmdns.registerService(serviceInfo);
            Thread.sleep(2000);
            
            
            
            
            ServiceInfo serviceInfo1 = ServiceInfo.create("_grpc._tcp.local.", "print_product_service", 9091, "test_Service_text");
            jmdns.registerService(serviceInfo1);
            
            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
