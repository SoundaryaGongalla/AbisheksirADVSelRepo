package soundarya;

import java.util.ArrayList;
import java.util.List;

public class Collect {
public static void main(String[] args) {
	List l=new ArrayList();
	List a=new ArrayList();

	for(int i=0;i<=100;i=i+2)
	{
		l.add(i);		
	}
	System.out.println(l);// print onl even and revere it
	for(int j=l.size()-1;j>=0;j--)
	{
		a.add(l.get(j));
		
	}
	System.out.println(a);

	
	
}
}
