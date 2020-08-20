
package mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;


class Subscriber implements MqttCallback {

    public Subscriber() {
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        System.out.println(mm + " added to system " + string);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
    }
    
}
