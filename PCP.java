import java.util.Stack;

public class PCP
{
	public static void main(String args[])
	{
		PCP pt = new PCP();
		pt.pcpResult();
	}

	private int count;
	private String[] patN, patD;
	private Stack<Integer> st;

	private void pcpResult()
	{
		count = 0;	//stores the recursive call count
		st = new Stack<Integer>();
		patN = new String[] {"001", "01", "01", "10"};
		patD = new String[] {"0", "011", "101", "001"};
		if ( iterativeDepening() )
		{
			while ( !st.isEmpty() )
				System.out.print(st.pop() + " ");
		}
		else
		System.out.println("No solution possible.");

	}

	private void iterativeDepening()
	{
		int maxl = 100;	//this represents the maximum depth that is permissible
		boolean result;
		for ( int i = 0 ; i < maxl ; i++ )
		{
			result = pcpUtil("", "", 0, i);
			if ( result == true  )
			{
				return true;
			}
		}
		return false;
	}

	private boolean pcpUtil(String num, String den, int level, int maxl)
	{	
		if ( level > maxl ) return false;
		count++;
		System.out.println(count);
		System.out.println("At level: " + level);
		if ( !num.equals("") && !den.equals("") && num.equals(den) )
		{			
			System.out.print(num+", ");
			System.out.println(den);
			return true;
		}
		
		boolean result = false;
		for ( int i = 0 ; i < patN.length ; i++ )
		{
			result = pcpUtil(num + patN[i], den + patD[i], level+1, maxl);
			if ( result == true )
			{
				st.push(i);
				return true;
			}
		}
		return result;
	}
}