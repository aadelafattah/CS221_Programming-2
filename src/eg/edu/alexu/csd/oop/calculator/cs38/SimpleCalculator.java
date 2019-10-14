package eg.edu.alexu.csd.oop.calculator.cs38;
import java.util.regex.*;
import java.util.*;

public class SimpleCalculator implements Calculator {
	
	String memory [][] = new String [6][4];
	
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
			memory[0][i]= m1.group();
			i++;
			if(mS.find()) {
				memory[0][i] = (mS.group());
				i++;
			}	
		}
				
	}

	@Override
	public String getResult() {
		double n1=Double.valueOf(memory[0][0]);
		double n2=Double.valueOf(memory[0][2]);
		if(memory[0][1].equals("+")) {
			memory[0][3]=String.valueOf(n1+n2);
		}
		else if(memory[0][1].equals("-")) {
			memory[0][3]=String.valueOf(n1-n2);
		}
		else if(memory[0][1].equals("*")) {
			memory[0][3]=String.valueOf(n1*n2);
		}
		else if(memory[0][1].equals("/")) {
			if(Double.valueOf(memory[0][2])==0) {
				memory[0][3]="MATH ERROR";
			}
			else{
				memory[0][3]=String.valueOf(n1/n2);
			}
		}
		if(Double.valueOf(memory[0][3])%1 == 0 && Double.valueOf(memory[0][2]) != 0.0) {
			Matcher m = Pattern.compile("\\d+").matcher(memory[0][3]);
			m.find();
			memory[0][3]=m.group();
		}
		String r=memory[0][0] + memory[0][1] + memory[0][2] + "=" + memory[0][3];
		return r;
	}

	@Override
	public String current() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prev() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		return null;
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
			
		}
	}

}
