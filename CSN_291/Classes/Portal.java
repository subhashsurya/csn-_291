import java.util.*;

public class Portal
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<Family> fam=new ArrayList<Family>();
        Employee e1=new Employee();
        String s="1";
        while (s.trim().equals("1") || s.trim().equals("2") || s.trim().equals("3"))
        {
            System.out.println("\n\n\nWelcome to Water Management Portal");
            System.out.println("Enter 1 to log in, 2 to register, 3 to login as employee and anything else to exit");
            s=sc.nextLine();
            if ((s.trim()).equals("1"))
            {
                if (fam.size()>0)
                {
                    System.out.println("Enter familyID");
                    int n=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter password");
                    String p=sc.nextLine();
                    for (int i=0;i<fam.size();i++)
                    {
                        if (n==fam.get(i).getFamilyID() && p.equals(fam.get(i).getPass()))
                        {
                            int x=1;
                            while (x>=1 && x<=8)
                            {
                                System.out.println("\n\nEnter 1 to see water consumption data");
                                System.out.println("Enter 2 to see bill");
                                System.out.println("Enter 3 to pay bill");
                                System.out.println("Enter 4 to see User data");
                                System.out.println("Enter 5 to generate complaint");
                                System.out.println("Enter 6 to see status of complaint");
                                System.out.println("Enter 7 to update details");
                                System.out.println("Enter 8 to add resident");
                                System.out.println("Enter any other number to log out");
                                x=Integer.parseInt(sc.nextLine());
                                switch(x)
                                {
                                    case 1:
                                    fam.get(n-1).seeRecord();
                                    break;
                                    case 2:
                                    fam.get(n-1).see_Bill();
                                    break;
                                    case 3:
                                    fam.get(n-1).pay_Bill();
                                    break;
                                    case 4:
                                    fam.get(n-1).print();
                                    break;
                                    case 5:
                                    System.out.println("Enter complaint");
                                    String c=sc.nextLine();
                                    fam.get(n-1).Complaint_Add(c);
                                    break;
                                    case 6:
                                    System.out.println("Status of the complaint is");
                                    fam.get(n-1).check_Complaint();
                                    break;
                                    case 7:
                                    System.out.println("Enter address of house");
                                    String a=sc.nextLine();
                                    fam.get(n-1).setAddress(a);
                                    for (int j=0;j<fam.get(i).noOfResidents();j++)
                                    {
                                        System.out.println("For resident "+fam.get(n-1).getResidentName(j));
                                        System.out.println("Enter name");
                                        String nam=sc.nextLine();
                                        System.out.println("Enter phone number");
                                        long phon=Long.parseLong(sc.nextLine());
                                        System.out.println("Enter email");
                                        String email=sc.nextLine();
                                        fam.get(n-1).updateRes(j, nam, phon, email);
                                    }
                                    break;
                                    case 8:
                                    System.out.println("Enter name");
                                    String nam=sc.nextLine();
                                    System.out.println("Enter phone number");
                                    long phon=Long.parseLong(sc.nextLine());
                                    System.out.println("Enter email");
                                    String email=sc.nextLine();
                                    fam.get(n-1).new_Resident(nam, phon, email);
                                    break;
                                }
                            }
                        }
                    }
                    System.out.println("Invalid login");
                }
                else
                System.out.println("No such user");
            }
            else if ((s.trim()).equals("2"))
            {
                System.out.println("Enter address of house");
                String a=sc.nextLine();
                System.out.println("Enter password");
                String p=sc.nextLine();
                System.out.println("Enter number of residents");
                int n=Integer.parseInt(sc.nextLine());
                int i=1;
                do
                {
                    System.out.println("\nEnter name of resident");
                    String na=sc.nextLine();
                    System.out.println("Enter phone number");
                    long phn=Long.parseLong(sc.nextLine());
                    System.out.println("Enter email of resident");
                    String em=sc.nextLine();
                    if (i==1)
                    {
                        fam.add(new Family(a, na, em, p, phn));
                    }
                    else
                    {
                        fam.get(fam.size()-1).new_Resident(na,phn,em);
                    }
                    i++;
                }while(i<=n);
                System.out.println("\n\nDetails of family are");
                fam.get(fam.size()-1).print();
            }
            else if (s.trim().equals("3"))
            {
                System.out.println("Enter your employee ID");
                int eid=Integer.parseInt(sc.nextLine());
                if (eid==e1.getID())
                {
                    System.out.println("Showing all user complaints...");
                    for (int i=0;i<fam.size();i++)
                    {
                        if (!fam.get(i).com.getComplaint().equals("")   &&  !fam.get(i).com.getSolvingOrNot())
                        {
                            System.out.println("\n\nFamily with ID "+fam.get(i).getFamilyID()+" has following complaint");
                            e1.viewComplaint(fam.get(i).com);
                            e1.updateComplaint(fam.get(i).com);
                        }
                    }
                }
                else
                System.out.println("Invalid employee ID");
            }
        }
}
}