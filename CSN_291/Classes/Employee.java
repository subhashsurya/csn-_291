import java.util.Scanner;

public class Employee
{
    private int id;
    Employee()
    {
        id=10001;
    }
    public int getID()
    {
        return id;
    }
    public void viewComplaint(Complaint obj)
    {
        System.out.println("Complaint ID is "+obj.getID());
        System.out.println("Complaint is "+obj.getComplaint());
    }
    public void updateComplaint(Complaint obj)
    {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter the new status of complaint");
        String s=sc1.nextLine();
        System.out.println("Enter Y if complaint is resolved , else N");
        String s2=sc1.nextLine();
        boolean b=false;
        if (s2.trim().equalsIgnoreCase("Y"))
        b=true;
        else if (s2.trim().equalsIgnoreCase("N"))
        b=false;
        obj.update(s, b);
    }
}