package com.bharath.trainings.ws.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for(int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback wpc = (WSPasswordCallback) callbacks[i];
			if(wpc.getIdentifier().equals("cxf"));
			wpc.setPassword("cxf");
		}
		return;
	}

}
