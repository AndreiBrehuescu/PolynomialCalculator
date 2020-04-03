package Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.Monom;
import Model.WrongInputException;

public class PolinomUtil {
	
	public List<Monom> stringToList(String orgString) throws WrongInputException{
		String modif = plusAdd(orgString);
		String[] splited = modif.split("\\+");
		checkPolinom(splited);
		List<Monom> x = createPolinom(splited);
		Collections.sort(x);
		return x;
	}
	
	public String plusAdd(String toModif){
		String newString = "";
		
		newString += toModif.charAt(0);
		for( int i = 1; i < toModif.length();i ++) {
			
			if( toModif.charAt(i) == '-' ){
				newString += '+';
			}
			
			newString += toModif.charAt(i);
		}
		
		return newString;
	}
	public void checkPolinom(String[] splited) throws WrongInputException {
		
		String split = "x\\^|x";
		for (String elem : splited) {
			if( elem.equals("") == false) {
				String[] param = elem.split(split);
				
				if( param.length == 1) { 
					if( param[0].matches("^[0-9]*$||^[0-9.]*$||^-[0-9]*$||^[0-9.]*$") == false )
						throw new WrongInputException();
				}
				
				if( elem.contains("x") == false ) {
					if( param.length == 2) {
						
						if( param[0].equals("") == true) {
							
							if( param[1].matches("^[0-9]*$||^[0-9.]*$||^-[0-9]*$||^[0-9.]*$") == false ) {
								throw new WrongInputException();
							}
							
						}else {
							if( param[0].matches("^[0-9]*$||^[0-9.]*$||^-[0-9]*$||^[0-9.]*$") == false ||
									param[1].matches("^[0-9]*$||^[0-9.]*$||^-[0-9]*$||^[0-9.]*$") == false ) {
								throw new WrongInputException();
							}
						}
					}
				}
			}
		}
		
		return ;
	}
	
	public List<Monom> createPolinom(String[] splited) {
		List<Monom> list = new ArrayList();
		
		for (String string : splited) {
			String grad,coef;
			int g = 0;
			double c = 0;
			
			if( string.indexOf('^') != -1 )
				grad = string.substring( string.indexOf('^') + 1);
			else if( string.indexOf('x') != -1)
				grad = new String("1");
			else
				grad = new String("0");
			
			if( string.charAt(0) == '-' && string.charAt(1) == 'x' )
				coef = new String("-1");
			else if( string.indexOf('x') == -1 )
				coef = string;
			else if( string.charAt(0) == 'x')
				coef = new String("1");
			else
				coef = string.substring(0 , string.indexOf('x'));
			
			c = (double)(Integer.parseInt(coef));
			g = Integer.parseInt(grad);
			//System.out.println(c + " " + g);
			
			list.add( new Monom(c,g));
		}
		return list;
		
	}
	
	
	public String toString(List<Monom> list){
		String s = "";
		if( list.size() != 0 ) {
			for (Monom monom : list) {
			//Coeficientul
				if( monom == list.get(0)) {
					if( monom.getCoeficient() != 0 ) {
						if( monom.getCoeficient() == -1 && monom.getGrad() > 0 )
							s += "-";
						else if( monom.getCoeficient() != 1)
							s += monom.getCoeficient();
						else if( monom.getCoeficient() == 1 && monom.getGrad() == 0)
							s += "1";
						
					}
				}
				else {
					if( monom.getCoeficient() != 0 ) {
						if( monom.getCoeficient() == 1 && monom.getGrad() != 0) {
							s += "+";
						}
						else if( monom.getCoeficient() > 0 ) {
							s += "+" + monom.getCoeficient();
						}
						else if( monom.getCoeficient() == -1 && monom.getGrad() > 0){
							s += "-";
						}else {
							s += monom.getCoeficient();
						}
					}
				}
			
			//gradul
				if( monom.getGrad() != 0 && monom.getCoeficient() != 0) {
					if( monom.getGrad() == 1 ) {
						s+= "x";
					}else {
						s+= "x^" + monom.getGrad();				
					}
				}
			}
		}else {
			s += "0";
		}
		
		return s;
	}

}
