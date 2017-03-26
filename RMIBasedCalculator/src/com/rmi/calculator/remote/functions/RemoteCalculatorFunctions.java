package com.rmi.calculator.remote.functions;

import java.rmi.Remote;
import java.rmi.RemoteException;

// INFO: "RemoteCalculatorFunctions" Interface have to extend "java.rmi.Remote" Interface
public interface RemoteCalculatorFunctions extends Remote{

	// INFO: Abstract and Remote functions of Calculator
	public double sum(double firstNumber, double secondNumber) throws RemoteException; 
	public double substract(double firstNumber, double secondNumber) throws RemoteException;
	public double divide(double firstNumber, double secondNumber) throws RemoteException;
	public double multiply(double firstNumber, double secondNumber) throws RemoteException;
	
}
