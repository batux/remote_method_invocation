package com.rmi.calculator.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.rmi.calculator.remote.functions.RemoteCalculatorFunctions;

public class RemoteCalculator extends UnicastRemoteObject implements RemoteCalculatorFunctions{

	private static final long serialVersionUID = 7472595791224158363L;

	public RemoteCalculator() throws RemoteException {
		super();
	}

	@Override
	public double sum(double firstNumber, double secondNumber) throws RemoteException {
		
		double result = firstNumber + secondNumber;
		
		printLog("SUM OPERATION", firstNumber, secondNumber, result);
		
		return result;
	}

	@Override
	public double substract(double firstNumber, double secondNumber) throws RemoteException {
		
		double result = firstNumber - secondNumber;
		
		printLog("SUBSTRACT OPERATION", firstNumber, secondNumber, result);
		
		return result;
	}

	@Override
	public double divide(double firstNumber, double secondNumber) throws RemoteException {
		
		if(secondNumber == 0.0 || secondNumber == 0)
			throw new RemoteException("ERROR(1001): Divide by zero");
		
		double result = firstNumber / secondNumber;
		
		printLog("DIVIDE OPERATION", firstNumber, secondNumber, result);
		
		return result;
	}

	@Override
	public double multiply(double firstNumber, double secondNumber) throws RemoteException {
		
		double result = firstNumber * secondNumber;
		
		printLog("MULTIPLY OPERATION", firstNumber, secondNumber, result);
		
		return result;
	}

	private void printLog(String operationName, double firstNumber, double secondNumber, double result) {
		
		System.out.println("[ ********** " + operationName + " ********* ]");
		System.out.println("[First Argument : " + firstNumber + "]");
		System.out.println("[Second Argument: " + secondNumber + "]");
		System.out.println("[Result         : " + result + "]");
		System.out.println("[ ********************************** ]");
		
	}
}
