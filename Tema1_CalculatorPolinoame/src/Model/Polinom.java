package Model;
import java.util.*;

import Util.PolinomUtil;

public class Polinom implements Comparable{
	private List<Monom> list = new ArrayList();
	PolinomUtil util = new PolinomUtil();
	
	public Polinom() {
		super();
	}

	public Polinom(String input) throws WrongInputException{
		this.list = util.stringToList(input);

	}
	
	public Polinom(List<Monom> l) {
		this.list = l;
	}
	public List<Monom> getList() {
		return list;
	}

	public void setList(List<Monom> list) {
		this.list = list;
	}
	
	
	public String toString(){
		return util.toString(this.list);
	}

	@Override
	public int compareTo(Object o) {
		Polinom p2 = (Polinom) o;
		return this.list.get(0).compareTo(p2.getList().get(0));
	}
	
}
