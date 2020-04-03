package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Operatii;
import Model.Polinom;
import Model.RezDiv;
import Model.WrongInputException;

class TestPolynomials {

	public Polinom p1,p2;
	public RezDiv rez;
	public Operatii op = new Operatii();
	
	@BeforeEach
	void setUp() throws WrongInputException {
		this.p1 = new Polinom("3x^2+5x+2");
		this.p2 = new Polinom("2x+1");
	}
	
	@Test
	void testAdd() {
		String s = op.addPolinoms(p1, p2).toString();
		System.out.println(s);
		if( s.compareTo("3.0x^2+7.0x+3.0") == 0 )
			assertTrue(true);
	}

	@Test 
	void testSub(){
		if( op.subPolinoms(p1, p2).toString().compareTo("3x^2+3x+1") == 0 )
			assertTrue(true);
	}
	
	@Test
	void testMul(){
		if( op.mulPolinoms(p1, p2).toString().compareTo("6x^3+13x^2+9x+2") == 0 )
			assertTrue(true);
	}
	
	@Test 
	void testDiv() {
		rez = op.divPolinoms(p1, p2);
		if( rez.getRezultat().toString().compareTo("1.5x+1.75") == 0 
						&& rez.getRest().toString().compareTo("0.25") == 0)
			assertTrue(true);
	}
	
	@Test
	void testDeriv() {
		if( op.derPolinom(p1).toString().compareTo("6x+5") == 0)
			assertTrue(true);
	}
	
	@Test
	void testInt() {
		if( op.intPolinom(p1).toString().compareTo("x^3+2.5x") == 0)
			assertTrue(true);
	}
	
}
