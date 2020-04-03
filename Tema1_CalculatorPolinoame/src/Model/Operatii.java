package Model;
import java.util.*;

public class Operatii {

	public Operatii() {
	
	}
	
	public Polinom addPolinoms(Polinom p1,Polinom p2) {
		List<Monom> resultList= new ArrayList();
		List<Monom> p1List = p1.getList(), p2List = p2.getList();
		int i = 0, j = 0;
		while ( i < p1List.size() && j < p2List.size() ){
			if( p1List.get(i).getGrad() > p2List.get(j).getGrad() ) {
				resultList.add(p1List.get(i++));
			}else if( p1List.get(i).getGrad() < p2List.get(j).getGrad() ) {
				resultList.add(p2List.get(j++));
			}else {
				resultList.add(p1List.get(i++).add( p2List.get(j++)));
			}
		}
		while( i < p1List.size() )
			resultList.add( p1List.get(i++));
		while( j < p2List.size() )
			resultList.add( p2List.get(j++));
		for ( i = 0; i < resultList.size(); i++) {
			if( resultList.get(i).getCoeficient() == 0) {
				resultList.remove(resultList.get(i));
				i--;
			}
		}
		Polinom r = new Polinom(resultList);
		return r;
	}
	
	public Polinom subPolinoms(Polinom p1,Polinom p2) {
		List<Monom> resultList= new ArrayList();
		List<Monom> p1List = p1.getList(), p2List = p2.getList();
		int i = 0, j = 0;
		while ( i < p1List.size() && j < p2List.size() ){
			if( p1List.get(i).getGrad() > p2List.get(j).getGrad() ) {
				resultList.add(p1List.get(i++));
			}else if( p1List.get(i).getGrad() < p2List.get(j).getGrad() ) {
				Monom aux = p2List.get(j++);
				aux.setCoeficient((-1) * aux.getCoeficient());
				resultList.add(aux);
			}else {
				resultList.add(p1List.get(i++).sub( p2List.get(j++)));
			}
		}
		while( i < p1List.size() )
			resultList.add( p1List.get(i++));
		while( j < p2List.size() ) {
			Monom aux = p2List.get(j++);
			aux.setCoeficient((-1) * aux.getCoeficient());
			resultList.add( aux);
		}
		
		for ( i = 0; i < resultList.size(); i++) {
			if( resultList.get(i).getCoeficient() == 0 ){
				resultList.remove(resultList.get(i));
				i--;
			}
		}
		for ( i = 0; i < resultList.size(); i++) {
			if( resultList.get(i).getCoeficient() == 0) {
				resultList.remove(resultList.get(i));
				i--;
			}
		}
		Polinom r = new Polinom(resultList);
		return r;
	}
	
	public Polinom derPolinom(Polinom p1) {
		List<Monom> resultList= new ArrayList();
		List<Monom> p1List = p1.getList();
		for (Monom monom : p1List) {
			
			Monom aux = monom.der();
			resultList.add(aux);
		}
		for (int i = 0; i < resultList.size(); i++) {
			if( resultList.get(i).getCoeficient() == 0) {
				resultList.remove(resultList.get(i));
				i--;
			}
		}
		Polinom r = new Polinom(resultList);
		return r;
	}
	
	public Polinom mulPolinoms(Polinom p1, Polinom p2) {
		Polinom r = new Polinom();
		List<Monom> resultList = new ArrayList();
		List<Monom> p1List = p1.getList(), p2List = p2.getList();
		List<Monom> auxList = new ArrayList();
		resultList.add(new Monom(0,0));
		r.setList(resultList);
		for (Monom monom : p1List) {
			
			for (Monom monom2 : p2List) {
				auxList.add(monom.mul(monom2));
			}
			r = this.addPolinoms(r, new Polinom(auxList));
			auxList.clear();
		}
		return r;
	}
	
	public RezDiv divPolinoms(Polinom p1, Polinom p2) {
		//Exceptie grade
		Polinom result = new Polinom();
		Polinom rest = new Polinom();
		List<Monom> resultList = new ArrayList();
		List<Monom> restList = p1.getList();
		List<Monom> p2List = p2.getList();
		result.setList(resultList);
		rest.setList(restList);
		int  i = 0;
		while( p2.compareTo(rest) >= 0 ){

			resultList.add(restList.get(0).div(p2List.get(0)));
			List<Monom> monom = new ArrayList();
			monom.add(resultList.get(i++));
			Polinom m1 = new Polinom(monom);
			Polinom aux = mulPolinoms(m1, p2);
			Polinom aux2 = subPolinoms(rest,aux);
			restList = aux2.getList();
			rest.setList(restList);
			if( restList.size() == 0 )
				break;
		}
		result.setList(resultList);
		rest.setList(restList);
		
		return new RezDiv(result,rest);

	}

		
	public Polinom intPolinom(Polinom p1) {
		List<Monom> resultList = new ArrayList();
		List<Monom> p1List = p1.getList();
		
		for (Monom monom : p1List) {
			resultList.add(monom.integ());
		}
		for (int i = 0; i < resultList.size(); i++) {
			if( resultList.get(i).getCoeficient() == 0) {
				resultList.remove(resultList.get(i));
				i--;
			}
		}
		return new Polinom(resultList);
	}

}
