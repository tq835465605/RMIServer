package com.meshine.mcloudframework.rmi;

import java.io.IOException;

import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.Server;

/**
 * RMIServer main method
 * 
 * @author Li
 * 
 */
public class TestMain {

	public static void main(String[] args) throws IOException, LipeRMIException {
		CallHandler callHandler = new CallHandler();
		Compute remoteObject = new ComputeImp();
		callHandler.registerGlobal(Compute.class, remoteObject);

		Server server = new Server();
		int thePortIWantToBind = 6666;
		server.bind(thePortIWantToBind, callHandler);
		System.out.println("serve bind success");
	}
}
