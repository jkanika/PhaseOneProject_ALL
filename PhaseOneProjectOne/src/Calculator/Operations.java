package Calculator;

import java.util.Scanner;

public class Operations {
	
	private float num1;
	private float num2;
	private byte option;
	private float result;
	Scanner scan = new Scanner(System.in);
	
	private float addition(float num1, float num2) {
		return (num1+num2);
	}
	
	private float subtraction(float num1, float num2) {
		if (num1>num2) {
			return (num1-num2);
		}
		else {
			return (num2-num1);
		}
	}
	
	private float multiply(float num1, float num2) {
		return (num1*num2);
	}
	
	private float division(float num1, float num2) {
		if (num2 != 0) {
			return (num1/num2);
		}
		else {
			System.out.println("The divisor cannot be 0, Please enter valid value");
			return (0);
		}
	}
	
	public void acceptNumbers() {
		
		System.out.print("Enter 1st number : ");
		this.num1 = scan.nextFloat();
		System.out.print("Enter 2nd number : ");
		this.num2 = scan.nextFloat();
		
	}
	
	public void ChooseOp() {
		
		System.out.println("Choose operation : ");
		System.out.println("1 for addition");
		System.out.println("2 for subtraction");
		System.out.println("3 for multiplication");
		System.out.println("4 for division");
		this.option = scan.nextByte();
		
		switch(this.option) {
			
		case(1):
			this.result = addition(this.num1,this.num2);
			PrintDetails();
			break;
		
		case(2):
			this.result = subtraction(this.num1,this.num2);
			PrintDetails();
			break;
		
		case(3):
			this.result = multiply(this.num1,this.num2);
			PrintDetails();
			break;
		
		case(4):
			this.result = division(this.num1,this.num2);
			PrintDetails();
			break;
		
		default:
			System.out.println("Please choose a valid option");
		}
		
	}
	
	public void PrintDetails() {
		System.out.println("The result is : "+this.result);
	}
}
