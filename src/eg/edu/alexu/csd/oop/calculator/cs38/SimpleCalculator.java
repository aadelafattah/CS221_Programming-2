package eg.edu.alexu.csd.oop.calculator.cs38;
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class SimpleCalculator implements Calculator {
	
	public static String current [][] = new String [1][4]; 
	public static String memory [][] = new String [5][4];
	public static int now = 0;
	public static int error = 0;
	public static int N=0;
	public static String result=null;
	public static int PREV,NEX = 0;
	
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
		
		String temp[][]=new String[1][4];
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
		else if(s.equals("load") || s.equals("LOAD")){
			load();
			error=0;
		}
		else {
			String number1 ="\\d+\\.\\d+|\\d+|-\\d+\\.\\d+|-\\d+";
			String symbols = "[+/*-]";
			Pattern num1 = Pattern.compile(number1);
			Pattern sym = Pattern.compile(symbols);
			Matcher m1 = num1.matcher(s);
			Matcher mS = sym.matcher(s);
			int i = 0;
			N=0;
			while (m1.find()) {
				temp[0][i]= m1.group();
				double t = 0;
				t= Double.valueOf(String.valueOf(temp[0][i]));
				temp[0][i]= String.valueOf(t);
				Matcher neg = Pattern.compile("-").matcher(temp[0][i]);
				if(neg.find()) {
					mS.find();
				}
				i++;
				N++;
				if(mS.find()) {
					if(N==1) {
						temp[0][i] = (mS.group());
						s=s.substring(mS.start()+1);
						if(temp[0][1].equals("-")) {
							m1=num1.matcher(s);
						}
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
		if(error==1 || N < 2) {
			return "ERROR";
		}
		double n1=Double.valueOf(current[0][0]);
		double n2=Double.valueOf(current[0][2]);
		if(n1%1==0) {
			Matcher m = Pattern.compile("-\\d+|\\d+").matcher(String.valueOf(current[0][0]));
			m.find();
			current[0][0]=String.valueOf(m.group());
		}
		if(n2%1==0) {
			Matcher m = Pattern.compile("-\\d+|\\d+").matcher(String.valueOf(current[0][2]));
			m.find();
			current[0][2]=String.valueOf(m.group());
		}
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
				return current[0][3];
			}
			else{
				current[0][3]=String.valueOf(n1/n2);
			}
		}
		if(Double.valueOf(current[0][3])%1 == 0) {
			Matcher m = Pattern.compile("\\d+|-\\d+").matcher(current[0][3]);
			m.find();
			current[0][3]=m.group();
		}
		r=current[0][3];
		return r;
	}

	@Override
	public String current() {
		if(String.valueOf(current[0][3]).equals("null")) {
			return "ERROR: No Current";
		}
		return current[0][0] + current[0][1] + current[0][2] + "=" + current[0][3] ;
	}

	@Override
	public String prev() {
		PREV=1;
		if(NEX==1) {
			NEX=0;
			now++;
			now++;
		}
		if(now==-1) {
			now++;
		}
		if(now==5 || String.valueOf(memory[now][3]).equals("null")) {
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
		NEX=1;
		if(PREV==1) {
			PREV=0;
			now--;
			now--;
		}
		if(now==5) {
			now--;
		}
		if(now==-1 || String.valueOf(memory[now][3]).equals("null")) {
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
		
		Formatter saveInfo = null;
		try {
			saveInfo = new Formatter ("SaveInfo.txt");
		 }
		 catch(Exception e) {
			 error=1;
		 }
		saveInfo.format("%s%s%s%s%s%s",String.valueOf(current[0][0]),String.valueOf(current[0][1]),String.valueOf(current[0][2]),"=", String.valueOf(current[0][3]),"\n");
		for(int i=0; i<5;i++) {
			saveInfo.format("%s%s%s%s%s%s",String.valueOf(memory[i][0]),String.valueOf(memory[i][1]),String.valueOf(memory[i][2]),"=",String.valueOf(memory[i][3]),"\n");
		}
		saveInfo.close();
		N=2;
		result="SAVED";
	}

	@Override
	public void load() {
		Scanner loadInfo = null;
		int iLoad = 0;
		try {
			loadInfo= new Scanner(new File("SaveInfo.txt"));
		}catch(Exception e){
			error=1;
		}
		String temp = loadInfo.nextLine();
		String number1 ="\\d+\\.\\d+|\\d+|-\\d+\\.\\d+|-\\d+";
		String symbols = "[+/*-]";
		Pattern num1 = Pattern.compile(number1);
		Pattern sym = Pattern.compile(symbols);
		Matcher m1 = num1.matcher(temp);
		Matcher mS = sym.matcher(temp); 
		while (m1.find()) {
			current[0][iLoad]= m1.group();
			iLoad++;
			if(mS.find() && iLoad<3) {
				current[0][iLoad] = (mS.group());
				iLoad++;
			}
		}
		for(int jLoad=0; jLoad<5;jLoad++) {
			temp=loadInfo.nextLine();
			m1 = num1.matcher(temp);
			mS = sym.matcher(temp);
			int k=0;
			while (m1.find()) {
				memory[jLoad][k]= m1.group();
				k++;
				if(mS.find()&& k<3) {
					memory[jLoad][k] = (mS.group());
					k++;
				}
			}
		}
		if(String.valueOf(current[0][3]).equals("null")) {
			current[0][3]="MATH ERROR";
		}
		for(int er=0;er<5;er++) {
			if(String.valueOf(memory[er][3]).equals("null")) {
				memory[er][3]="MATH ERROR";
			}
		}
		loadInfo.close();
		N=2;
		result="LOADED";
	}

	public static void main(String[] args) {
		 
		while(true){
			
			String IP= "";
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("prev, next, current, save, load");
			IP=sc.nextLine();
			SimpleCalculator calc = new SimpleCalculator();
			calc.input(IP);
			result = calc.getResult();
			System.out.println(result);
		}
	}

}
