package Model;

public class Monom implements Comparable{
	private int grad;
	private double coeficient;
	
	
	public Monom(double coeficient,int grad)
	{
		this.grad = grad;
		this.coeficient = coeficient;
	}
	
	public Monom add(Monom m2) {
		return new Monom(this.getCoeficient() + m2.getCoeficient(), m2.getGrad());
	}
	
	public Monom sub(Monom m2) {
		return new Monom( this.getCoeficient() - m2.getCoeficient(), m2.getGrad());
	}
	public Monom mul(Monom m2) {
		return new Monom( this.getCoeficient() * m2.getCoeficient(), this.getGrad() + m2.getGrad());
	}
	public Monom div(Monom m2) {
		double coef = 0;
		int gr = 0;
		gr = this.grad - m2.getGrad();
		coef = this.coeficient / m2.getCoeficient();
		return new Monom(coef,gr);
	}
	
	public Monom der() {
		return new Monom(this.coeficient * this.grad, this.grad - 1);
	}
	
	public Monom integ() {
		if( this.grad == 0 )
			return new Monom(this.coeficient,1);
		else
			return new Monom(this.coeficient / (this.grad + 1) , this.grad + 1);
	}

	public int getGrad() {
		return grad;
	}


	public void setGrad(int grad) {
		this.grad = grad;
	}


	public double getCoeficient() {
		return coeficient;
	}


	public void setCoeficient(double coeficient) {
		this.coeficient = coeficient;
	}

	@Override
	public int compareTo(Object o) {
		Monom p = (Monom) o ;
		if( this.grad < p.getGrad() )
			return 1;
		else if( this.grad == p.getGrad() )
			return 0;
		else 
			return -1;
	}
	
	
}
