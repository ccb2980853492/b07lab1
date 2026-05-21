public class Polynomial{
	private double[] coeff;
	
	public Polynomial() {
		coeff = new double[1];
		coeff[0] = 0.0;
	}
	
	public Polynomial(double[] coeff) {
		this.coeff = new double[coeff.length];
		for(int i=0; i<coeff.length; i++) {
			this.coeff[i] = coeff[i];
		}
	}
	
	public Polynomial add(Polynomial p) {
		double[] long_coeff, short_coeff;
		if(p.coeff.length >= this.coeff.length) {
			long_coeff = p.coeff;
			short_coeff = this.coeff;
		}
		else {
			long_coeff = this.coeff;
			short_coeff = p.coeff;
		}
		double[] coeff = new double[long_coeff.length];
		for(int i=0; i<short_coeff.length; i++) {
			coeff[i] = short_coeff[i] + long_coeff[i];
		}
		for(int i=short_coeff.length; i<long_coeff.length; i++) {
			coeff[i] = long_coeff[i];
		}
		return new Polynomial(coeff);
	}
	
	public double evaluate(double x) {
		double sum = 0.0;
		double x_pow = 1.0;
		for(int i=0; i<this.coeff.length; i++) {
			sum += this.coeff[i] * x_pow;
			x_pow *= x;
		}
		return sum;
	}
	
	public boolean hasRoot(double x) {
		return this.evaluate(x) == 0.0;
	}
}