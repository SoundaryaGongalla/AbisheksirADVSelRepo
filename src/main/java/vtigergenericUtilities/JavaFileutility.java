package vtigergenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaFileutility {
public int random()
{
Random r=new Random();

return r.nextInt();

}
public String date()
{
	Date  d=new Date();
	String[] x=d.toString().split(" ");
	return x[2]+"-"+x[1]+"-"+x[5];
	
	
}
public String generatetime()
{
	Date dd=new Date();
	String []x=dd.toString().split(" ");
	String time=x[3];
	
	
	return time.replace(":", "-");
	
	
	
}
}
