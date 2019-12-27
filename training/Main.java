package training;

class emi{
	int downpay;
	int principle;
	int duration;
	final double rate;
	public emi(int downpay, int principle,int duration,double rate) {
		this.downpay = downpay;
		this.principle = principle;
		this.duration = duration;
		this.rate = rate;
	}
	public double interest() {
		
		int amt = downpay - principle;
		double interest = (amt*rate)/100;
		
		return interest;
		
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		emi o = new emi(25000,13000,24,5.0);
		double r = o.interest();
		System.out.println("Hello User.....Your EMI details are: ");
		System.out.println("EMI = "+r+" (per month)for "+o.duration+" months");

	}

}
