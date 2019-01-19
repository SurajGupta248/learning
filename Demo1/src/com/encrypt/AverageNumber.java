package com.encrypt;

import java.util.Scanner;

public class AverageNumber {
	
	public static void CheckNumber(int n){
		if(n%2==0)
			System.out.println("even number");
		else
			System.out.println("Odd Number");
	}
	public static void displayPrime(int prime){
		boolean flag=true;
		for(int i=2;i<prime/2;i++){
			if(prime%i==0){
				flag=false;
				break;
			}
		}
			if(flag==true)
				System.out.println("Prime Number");
			else
				System.out.println("Not prime number");
			
		
	}
	public static void main(String[] args) {
		double[] ar={2,3,5,2,7,2,6};
		double sum=0,count=ar.length;
		System.out.println(count);
		for(int i=0;i<count;i++)
			sum=sum+ar[i];
		double average=sum/count;
		System.out.format("Average= %.3f\n ",average);
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter the number");
		int n=scan.nextInt();
		scan.close();
		CheckNumber(n);
		displayPrime(n);
	}

}
