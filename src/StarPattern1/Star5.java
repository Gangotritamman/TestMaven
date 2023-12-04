package StarPattern1;

public class Star5 
{
	public static void main(String[] args) 
	{
		int star=9;
	for(int i=1; i<=5; i++)
	{
		for(int j=1; j<=star; j++)
		{
			System.out.print("*");
		}
		System.out.println();
		star=star-2;
	}
	}
}
