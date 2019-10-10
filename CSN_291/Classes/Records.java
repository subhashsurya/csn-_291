import java.util.ArrayList;

public class Records
{
    private static ArrayList<ArrayList<Integer>> rec=new ArrayList<ArrayList<Integer>>();
    public void addData(int familyID,int day,int amount)
    {
        if (rec.size()<familyID)
        {
            rec.add(new ArrayList<Integer>());
            for (int i=0;i<30;i++)
            rec.get(rec.size()-1).add(0);
            rec.get(rec.size()-1).set(day,amount);
        }
        else
        {
            rec.get(familyID-1).set(day,amount);
        }
    }
    public void printData(int familyID)
    {
        System.out.println("For family with familyID "+familyID);
        for (int i=0;i<30;i++)
        {
            System.out.print("At day "+(i+1)+" water consumption was "+rec.get(familyID-1).get(i));
            mailSend(familyID,i);
            System.out.print("\n");
        }
        System.out.println("Total water consumption in the month is "+getAmount(familyID));
    }
    public int getAmount(int familyID)
    {
        int a=0;
        for (int i=0;i<30;i++)
        a+=rec.get(familyID-1).get(i);
        return a;
    }
    public void mailSend(int familyID,int day)
    {
        {   if((rec.get(familyID-1).get(day))>(getAmount(familyID)/30.0)){
                    System.out.print("          your water limit has exceeded than your monthly average");
                }
        }
    }
}