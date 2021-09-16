package com.mp1calculator.model;
import java.io.Serializable;

public class CalculatorBean implements Serializable{
	double num1;
	double num2;
	double answer;
	String operation;
	String operationMessage;
	boolean divByZero;
	boolean operationNull;
	boolean invalidOperation;
	
	
	public boolean isDivByZero() {
		return divByZero;
	}
	public void setDivByZero(boolean divByZero) {
		this.divByZero = divByZero;
	}
	public boolean isOperationNull(){
		return operationNull;
	}
	public void setOperationNull(boolean operationNull){
		this.operationNull = operationNull;
	}
	public boolean isInvalidOperation(){
		return invalidOperation;
	}
	public void setInvalidOperation(boolean invalidOp){
		this.invalidOperation = invalidOp;
	}
	public String getOperationMessage() {
		return operationMessage;
	}
	public void setOperationMessage(String operationMessage) {
		this.operationMessage = operationMessage;
	}
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public double getAnswer() {
		return answer;
	}
	public void setAnswer(double answer) {
		this.answer = answer;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public void answerString() {
		switch(operation) {
		case "*":
			setAnswer(getNum1() * getNum2());
			setOperation("multiplication");
			setOperationMessage("Multiplying ");
			break;
		case "+":
			setAnswer(getNum1() + getNum2());
			setOperation("addition");
			setOperationMessage("Adding ");
			break;
		case "/":
			if(getNum1() == 0 || getNum2() == 0) {
				setDivByZero(true);
			}else {
				setAnswer(getNum1() / getNum2());
				setOperation("division");
				setOperationMessage("Dividing ");
			}
	
			break;
		case "-":
			setAnswer(getNum1() - getNum2());
			setOperation("subtraction");
			setOperationMessage("Subtracting ");
			break;
			
		case "":
			setOperationNull(true);
			break;
		
		default: 
			setInvalidOperation(true);
			break;
		}
		
	}
	
	
	

}
