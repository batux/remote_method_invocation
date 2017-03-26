package com.rmi.calculator.server;

import java.rmi.Naming;

import com.rmi.calculator.implementation.RemoteCalculator;

public class CalculatorServer {
	
	public static void main(String args[]) {
		
		try {
			RemoteCalculator remoteCalculator = new RemoteCalculator();
			Naming.rebind("RemoteCalculator", remoteCalculator);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
