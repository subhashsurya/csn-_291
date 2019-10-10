public class Bill{
	static int rate = 5;
	private boolean paid=false;

	public int calculateBill(int familyID){
		Records r1 = new Records();
		int r = r1.getAmount(familyID);
		if (!paid)
			return rate*r;
		else 
			return 0;
	}

	public void payBill(int familyID){
		System.out.println("Rate is "+rate+" per unit of water");
		System.out.println("Bill paid "+calculateBill(familyID));
		this.paid =true;
	}

}