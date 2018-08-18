package com.bharath.trainings.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

import com.bharath.ws.soap.PaymentProcessor;
import com.bharath.ws.soap.PaymentProcessorImplService;
import com.bharath.ws.soap.PaymentProcessorRequest;
import com.bharath.ws.soap.PaymentProcessorResponse;

public class PaymentWSClient {

	public static void main(String[] args) {
		try {
			PaymentProcessorImplService service = new PaymentProcessorImplService(new URL("http://localhost:8080/javafirstws/services/paymentProcessor?wsdl"));
			PaymentProcessor port = service.getPaymentProcessorImplPort();
			
			Client client = ClientProxy.getClient(port);
			Endpoint endpoint = client.getEndpoint();
			Map<String, Object> props = null;
			WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
			endpoint.getOutInterceptors().add(wssOut);
			
			
			PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
			System.out.println(response.isResult());
			
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}

	}

}
