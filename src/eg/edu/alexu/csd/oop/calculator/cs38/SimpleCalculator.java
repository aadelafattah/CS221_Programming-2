package eg.edu.alexu.csd.oop.calculator.cs38;
import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class SimpleCalculator implements Calculator {
	
	public static Formatter saveInfo;
	public static String current [][] = new String [1][4]; 
	public static String memory [][] = new String [5][4];
	public static int now = 0;
	public static int error = 0;
	public static int N=0;
	
	public void arrangeMemory() {
		now=0;
		for(int j=4;j>0;j--) {
			memory[j][0]=String.valueOf(memory[j-1][0]);
			memory[j][1]=String.valueOf(memory[j-1][1]);
			memory[j][2]=String.valueOf(memory[j-1][2]);
			memory[j][3]=String.valueOf(memory[j-1][3]);
		}
		memory[0][0]=String.valueOf(current[0][0]);
		memory[0][1]=String.valueOf(current[0][1]);
		memory[0][2]=String.valueOf(current[0][2]);
		memory[0][3]=String.valueOf(current[0][3]);
	}
	
	@Override
	public void input(String s) {
		
		error=1;
		
		if(s.equals("prev") || s.equals("PREV")){
			prev();
			error=0;
		}
		else if(s.equals("next") || s.equals("NEXT")){
			next();
			error=0;
		}
		else if(s.equals("current") || s.equals("CURRENT")){
			current();
			error=0;
		}
		else if(s.equals("save") || s.equals("SAVE")){
			save();
			error=0;
		}
		else {
			String temp[][]=new String[1][4];
			String number1 ="\\d+\\.\\d+|\\d+";
			String symbols = "[+/*-]";
			Pattern num1 = Pattern.compile(number1);
			Pattern sym = Pattern.compile(symbols);
			Matcher m1 = num1.matcher(s);
			Matcher mS = sym.matcher(s);
			int i = 0;
			N=0;
			while (m1.find()) {
				temp[0][i]= m1.group();
				i++;
				N++;
				if(mS.find()) {
					if(N==1) {
						temp[0][i] = (mS.group());
						i++;
						error=0;
					}
					else {
						error=1;
						break;
					}
				}
			}
			if(error==0) {
				arrangeMemory();
				current[0][0]=String.valueOf(temp[0][0]);
				current[0][1]=String.valueOf(temp[0][1]);
				current[0][2]=String.valueOf(temp[0][2]);
				current[0][3]=String.valueOf(temp[0][3]);
			}
		}		
	}

	@Override
	public String getResult() {
		double n1=Double.valueOf(current[0][0]);
		double n2=Double.valueOf(current[0][2]);
		String r="";
		if(current[0][1].equals("+")) {
			current[0][3]=String.valueOf(n1+n2);
		}
		else if(current[0][1].equals("-")) {
			current[0][3]=String.valueOf(n1-n2);
		}
		else if(current[0][1].equals("*")) {
			current[0][3]=String.valueOf(n1*n2);
		}
		else if(current[0][1].equals("/")) {
			if(Double.valueOf(current[0][2])==0) {
				current[0][3]="MATH ERROR";
			}
			else{
				current[0][3]=String.valueOf(n1/n2);
			}
		}
		if(Double.valueOf(current[0][3])%1 == 0 && Double.valueOf(current[0][2]) != 0.0) {
			Matcher m = Pattern.compile("\\d+").matcher(current[0][3]);
			m.find();
			current[0][3]=m.group();
		}
		r=current[0][0] + current[0][1] + current[0][2] + "=" + current[0][3];
		return r;
	}

	@Override
	public String current() {
		return current[0][0] + current[0][1] + current[0][2] + "=" + current[0][3] ;
	}

	@Override
	public String prev() {
		if(now==4) {
			return "ERROR: No Prev";
		}
		else {
			current[0][0]=String.valueOf(memory[now][0]);
			current[0][1]=String.valueOf(memory[now][1]);
			current[0][2]=String.valueOf(memory[now][2]);
			current[0][3]=String.valueOf(memory[now][3]);
			now++;
			return current[0][0] + current[0][1] + current[0][2] + "=" + current[0][3];
		}
	}

	@Override
	public String next() {
		if(now==0) {
			return "ERROR: No Next";
		}
		else {
			current[0][0]=String.valueOf(memory[now][0]);
			current[0][1]=String.valueOf(memory[now][1]);
			current[0][2]=String.valueOf(memory[now][2]);
			current[0][3]=String.valueOf(memory[now][3]);
			now--;
			return current[0][0] + current[0][1] + current[0][2] + "=" + current[0][3];
		}
	}

	@Override
	public void save() {
		for(int i=0; i<5;i++) {
			saveInfo.format( String.valueOf(memory[i][0]) , String.valueOf(memory[i][1])
					, String.valueOf(memory[i][2]), String.valueOf(memory[i][3]));
		}
		saveInfo.format( String.valueOf(current[0][0]) , String.valueOf(current[0][1])
				, String.valueOf(current[0][2]), String.valueOf(current[0][3]));
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		
		 try {
			saveInfo = new Formatter ("SaveInfo.txt");
		 }
		 catch(Exception e) {
			 
		 }
		 
		while(true){
			
			String IP= "";
			Scanner sc = new Scanner(System.in);
			System.out.println("prev, next, current, save");
			IP=sc.nextLine();
			SimpleCalculator calc = new SimpleCalculator();
			calc.input(IP);
			if(error==1 || N < 2) {
				System.out.println("INVALID INPUT");
				continue;
			}
			String result = calc.getResult();
			System.out.println(result);
			System.out.println("");
		}
	}

}
