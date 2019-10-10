public class Resident{
	private String name;
	private long phoneNo;
	private String email;

	public void setName(String s){
		this.name = s;
	}

	public String getName(){
		return this.name;
	}

	public void setPhoneNo(long s){
		this.phoneNo = s;
	}

	public long getPhoneNo(){
		return this.phoneNo;
	}

	public void setEmail(String e){
		this.email = e;
	}
	
	public String getEmail(){
		return this.email;
	}

	public Resident(String n,long p,String e){
		name = n;
		phoneNo = p;
		email = e;

	}

	public void update(String n,long p,String e){
		this.name = n;
		this.phoneNo = p;
		this.email = e;
	}


}