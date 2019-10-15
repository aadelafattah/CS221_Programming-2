package eg.edu.alexu.csd.oop.calculator.cs38;
import java.util.regex.*;
import java.util.*;

public class SimpleCalculator implements Calculator {
	
	public static String memory [][] = new String [6][4];
	public static int current = 0;
	
	public static void addOne() {
		if (current == 5) {
			current =0;
		}else {
			current++;
		}
	}
	public static void removeOne() {
		if (current == 0) {
			current =5;
		}else {
			current--;
		}
	}
	
	@Override
	public void input(String s) {
		
		String number1 ="\\d+\\.\\d+|\\d+";
		String symbols = "[+/*-]";
		Pattern num1 = Pattern.compile(number1);
		Pattern sym = Pattern.compile(symbols);
		Matcher m1 = num1.matcher(s);
		Matcher mS = sym.matcher(s);
		int i = 0;
		while (m1.find()) {
			memory[current][i]= m1.group();
			i++;
			if(mS.find()) {
				memory[current][i] = (mS.group());
				i++;
			}	
		}
				
	}

	@Override
	public String getResult() {
		double n1=Double.valueOf(memory[current][0]);
		double n2=Double.valueOf(memory[current][2]);
		String r="";
		if(memory[current][1].equals("+")) {
			memory[current][3]=String.valueOf(n1+n2);
		}
		else if(memory[current][1].equals("-")) {
			memory[current][3]=String.valueOf(n1-n2);
		}
		else if(memory[current][1].equals("*")) {
			memory[current][3]=String.valueOf(n1*n2);
		}
		else if(memory[current][1].equals("/")) {
			if(Double.valueOf(memory[current][2])==0) {
				memory[current][3]="MATH ERROR";
			}
			else{
				memory[current][3]=String.valueOf(n1/n2);
			}
		}
		if(Double.valueOf(memory[current][3])%1 == 0 && Double.valueOf(memory[current][2]) != 0.0) {
			Matcher m = Pattern.compile("\\d+").matcher(memory[current][3]);
			m.find();
			memory[current][3]=m.group();
		}
		r=memory[current][0] + memory[current][1] + memory[current][2] + "=" + memory[current][3];
		return r;
	}

	@Override
	public String current() {
		removeOne();
		
		return memory[current][0] + memory[current][1] + memory[current][2] + "=" + memory[current][3] ;
	}

	@Override
	public String prev() {
		removeOne();
		removeOne();
		return memory[current][0] + memory[current][1] + memory[current][2] + "=" + memory[current][3];
	}

	@Override
	public String next() {
		addOne();
		return memory[current][0] + memory[current][1] + memory[current][2] + "=" + memory[current][3];
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		while(true){
			
			String IP= "";
			Scanner sc = new Scanner(System.in);
			IP=sc.nextLine();
			SimpleCalculator calc = new SimpleCalculator();
			calc.input(IP);
			String result = calc.getResult();
			System.out.println(result);
			System.out.println("");
			addOne();
			
		}
	}

}
