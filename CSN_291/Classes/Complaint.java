import java.util.*;
import java.lang.*;

public class Complaint{
	public static int count=1;
	private int id;
	private	String status;
	private	String compl;
	private	Boolean solvingOrNot;

	public Complaint(String s){
		this.compl = s; 
		Random r=new Random();
		id=Math.abs(r.nextInt()%10000);
		solvingOrNot=false;
		status="Not Resolved";
	}
	public void update(String status,Boolean b){
		this.status = status;
		solvingOrNot=b;
	}
	public int getID()
	{
		return id;
	}
	public String getComplaint(){
		return this.compl;
	}
	public void print()
	{
		System.out.println("Complaint ID is "+id);
		System.out.println("Complaint is "+compl);
		System.out.println("Complaint status is "+status);
		if (solvingOrNot)
		System.out.println("Solved");
		else
		System.out.println("Not Solved");
	}
	public Boolean getSolvingOrNot(){
		return this.solvingOrNot;
	}
	
}