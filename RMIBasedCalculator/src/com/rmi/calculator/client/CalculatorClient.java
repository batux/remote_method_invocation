package com.rmi.calculator.client;

import java.rmi.Naming;
import com.rmi.calculator.remote.functions.RemoteCalculatorFunctions;

public class CalculatorClient {
	
	public static void main(String args[]) {
		
		try {
			
			if(args.length != 4) {
				throw new Exception("ERROR-1004: Less Parameters List Error!");
			}
			
			String host = args[0];
			double firstNumber 	= Double.valueOf(args[1]);
			double secondNumber = Double.valueOf(args[2]);
			int operationType 	= Integer.valueOf(args[3]);
			
			RemoteCalculatorFunctions remoteCalculator = 
					(RemoteCalculatorFunctions) Naming.lookup("rmi://" + host + "/RemoteCalculator");
			
			
			double result = calculate(remoteCalculator, firstNumber, secondNumber, operationType);
			
			System.out.println("[Result Value: " + result + " ]");
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static double calculate(RemoteCalculatorFunctions remoteCalculator, double firstNumber, double secondNumber, int operationType) throws Exception {
		
		double result = 0;
		
		switch (operationType) {
			
			case 1:
				result = remoteCalculator.sum(firstNumber, secondNumber);
				break;
			case 2:
				result = remoteCalculator.substract(firstNumber, secondNumber);
				break;
			case 3:
				result = remoteCalculator.divide(firstNumber, secondNumber);
				break;
			case 4:
				result = remoteCalculator.multiply(firstNumber, secondNumber);
				break;
			default:
				throw new Exception("ERROR(1005): Invalid Calculation Operation Type!");
				
		}
		
		return result;
	}
}
