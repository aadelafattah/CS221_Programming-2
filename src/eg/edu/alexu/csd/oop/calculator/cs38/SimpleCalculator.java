package eg.edu.alexu.csd.oop.calculator.cs38;
import java.util.regex.*;
import java.util.*;

public class SimpleCalculator implements Calculator {

	@Override
	public void input(String s) {
		
		Scanner sc = new Scanner(System.in);
		s=sc.nextLine();
		String number1 ="\\d+\\.\\d+|\\d+";
		String symbols = "[+/*-]";
		Pattern num1 = Pattern.compile(number1);
		Pattern sym = Pattern.compile(symbols);
		Matcher m1 = num1.matcher(s);
		Matcher mS = sym.matcher(s);
		while (m1.find()) {
			System.out.print(m1.group());
			if(mS.find()) {
				System.out.print(mS.group());
			}	
		}
				
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
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
			SimpleCalculator calc = new SimpleCalculator();
			calc.input(IP);
			
		}
	}

}
