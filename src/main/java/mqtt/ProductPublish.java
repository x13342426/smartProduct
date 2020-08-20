package mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ProductPublish {

    public static void main(String[] args) {

        String topic = "/product/new";
        String content = "Message From Computer:";
        int qos = 2;
        String broker = "tcp://localhost:1883";
        String clientId = "Publisher";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: " + content);
            MqttMessage message = new MqttMessage((content+"New Product").getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
           
            
            sampleClient.publish(topic+"/pen", message); 
            System.out.println("Message published");
            sampleClient.publish(topic+"/paper", message); 
            System.out.println("Message published");
            sampleClient.publish(topic+"/pencil", message); 
            System.out.println("Message published");
            sampleClient.publish(topic+"/parer", message); 
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
            
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
}
