package jdbc;
import java.util.*;
import java.sql.*;

public class bank {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dileep","root","qwertyuiop");
		Statement st=con.createStatement();
		Scanner s=new Scanner(System.in);
		int ch;
		do
		{
		System.out.println("1.Create an Account\n2.Withdraw\n3.Deposite\n4.Check Balance");
       int op=s.nextInt();
       switch(op)
       {
       case 1:
    	   System.out.println("enter account no");
    	   int accno=s.nextInt();
    	   System.out.println("enter account passward");
    	   int pass=s.nextInt();
    	   System.out.println("enter account name");
    	   String name=s.next();
    	   System.out.println("enter account balance");
    	   int bal=s.nextInt();
    	   st.execute("INSERT INTO `dileep`.`account` (`accno`, `pin`, `name`,`balance`) VALUES ('"+accno+"', '"+pass+"', '"+name+"','"+bal+"')");
    	   System.out.println("INSERTED SUCCESSFULLY");
    	   break;
       case 2:
    	   ResultSet rs=st.executeQuery("select * from account");
System.out.println("enter accno");
accno=s.nextInt();
System.out.println("enter pass");
pass=s.nextInt();
while(rs.next())
{
	int daccno=rs.getInt("accno");
	int dpass=rs.getInt("pin");
	if(daccno==accno && dpass==pass)
	{
		System.out.println("enter amount");
		int am=s.nextInt();
		if(rs.getInt("balance")>am && am>0)
		{
			int remain=rs.getInt("balance")-am;
			st.execute("UPDATE `dileep`.`account` SET `balance` = '"+remain+"' WHERE (`accno` = '"+accno+"');");
			System.out.println("UPDATED SUCCESSFULLY");
			break;
		}
		else
		{
			System.out.println("wrong ammount");
			break;
		}
	}
	else
	{
		System.out.println("Incorrect Password");
	break;
	}
}
break;
       case 3:
    	   ResultSet rs1=st.executeQuery("select * from account");
    	   System.out.println("enter accno");
    	   accno=s.nextInt();
    	   System.out.println("enter pass");
    	   pass=s.nextInt();
    	   while(rs1.next())
    	   {
    	   	int daccno=rs1.getInt("accno");
    	   	int dpass=rs1.getInt("pin");
    	   	if(daccno==accno && dpass==pass)
    	   	{
    	   		System.out.println("enter amount");
    	   		int am=s.nextInt();
    	   		if(am>0)
    	   		{
    	   			int remain=rs1.getInt("balance")+am;
    	   			st.execute("UPDATE `dileep`.`account` SET `balance` = '"+remain+"' WHERE (`accno` = '"+accno+"')");
    	   			System.out.println("UPDATED SUCCESSFULLY");
    	   			break;
    	   		}
    	   		else
    	   		{
    	   			System.out.println("Wrong amount");
    	   			break;
    	   		}
    	   	}
    	   	else
    	   	{
    	   		System.out.println("Incorrect Password");
    	   		break;
    	   	}
    	   }
    	   break;
    	   
       case 4:
    	   ResultSet rs2=st.executeQuery("select * from account");
    	   System.out.println("enter accno");
    	   accno=s.nextInt();
    	   System.out.println("enter pass");
    	   pass=s.nextInt();
    	   while(rs2.next())
    	   {
    	   	int daccno=rs2.getInt("accno");
    	   	int dpass=rs2.getInt("pin");
    	   	if(daccno==accno && dpass==pass)
    	   	{
    	   		System.out.println("current Balance :"+rs2.getInt("balance"));
    	   		break;
    	   
       }
    	   	else
    	   	{
    	   		System.out.println("Incorrect Password");
    	   		break;
    	   	}
	}
       }
       System.out.println("Are you want run again press 1 or 0");
       ch=s.nextInt();
		}while(ch==1);
       
}
}
