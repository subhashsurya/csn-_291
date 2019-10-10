import java.util.*;
import java.io.*;
public class Family
{
    private String address;
    private int familyID;
    private static int counter=1;
    private static int day=0;
    private static Records RecObj=new Records();
    private ArrayList<Resident> res=new ArrayList<Resident>();
    private String password;
    private Bill b=new Bill();
    Complaint com=new Complaint("");
    public Family(String a,String n,String em,String p,long phn)
    {
        address=a;
        familyID=counter++;
        password=p;
        Resident obj=new Resident(n,phn,em);
        res.add(obj);
        for (int i=0;i<30;i++)
        passToRecord();
    }
    public void setAddress(String a)
    {
        address=a;
    }
    public String getAddress()
    {
        return address;
    }
    public void setFamilyID(int f)
    {
        familyID=f;
    }
    public int getFamilyID()
    {
        return familyID;
    }
    public String getPass()
    {
        return password;
    }
    public void print()
    {
        System.out.println("The family ID is "+familyID);
        System.out.println("The address is "+address);
        for (int i=0;i<res.size();i++)
        {
            System.out.println("For resident "+(i+1));
            System.out.println("Name is "+res.get(i).getName());
            System.out.println("Phone number is "+res.get(i).getPhoneNo());
            System.out.println("Email is "+res.get(i).getEmail());
        }
    }
    public void new_Resident(String n,long phn,String em)
    {
        Resident obj=new Resident(n,phn,em);
        res.add(obj);
    }
    public void seeRecord()
    {
        RecObj.printData(familyID);
    }
    public void passToRecord()
    {
        Random r=new Random();
        RecObj.addData(familyID,day,(10+Math.abs(r.nextInt()%9)));
        day=(day+1)%30;
    }
    public void Complaint_Add(String s)
    {
        com=new Complaint(s);
        System.out.println("The complaint ID is "+com.getID());
    }
    public void check_Complaint()
    {
        com.print();
    }
    public void see_Bill()
    {
        System.out.println("The bill is "+b.calculateBill(familyID));
    }
    public void pay_Bill()
    {
        b.payBill(getFamilyID());
    }
    public int noOfResidents()
    {
        return res.size();
    }
    public String getResidentName(int i) {
        return res.get(i).getName();
    } 
    public void updateRes(int i,String n,long p,String e)
    {
        res.get(i).update(n, p, e);
    }
}