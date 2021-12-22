//Kanw implementation to card type

public class Card 
{
	private Suit mySuit;
	
	//Ta xartia exoun times apo 2-14 me ton Ace = 14 kai tis figoures = 11-13
	private int myNumber;
	
	
	//Card constructor
	public Card(Suit aSuit, int aNumber) 
	{
		this.mySuit = aSuit;
		
		if (aNumber>=1 && aNumber<=13)
		{
			this.myNumber = aNumber;
		}
		else
		{
			System.err.println(aNumber + "Is not a valid Card number");
			System.exit(1);
		}
	}
	
	//mas dinei ton arithmo tis kartas
	public int getNumber()
	{
		return myNumber;
	}
	
	//Metatrepo tous arithmous se strings
	public String toString()
	{
		String numStr = "error";
		
		switch(this.myNumber)
		{
			case 2:
				numStr = "Two";
				break;
			case 3:
				numStr = "Three";
				break;
			case 4: 
				numStr = "Four";
				break;
			case 5:
				numStr = "Five";
				break;
			case 6:
				numStr = "Six";
				break;
			case 7:
				numStr = "Seven";
				break;
			case 8:
				numStr = "Eight";
				break;
			case 9: 
				numStr = "Nine";
				break;
			case 10:
				numStr = "Ten";
				break;
			case 11: 
				numStr = "Jack";
				break;
			case 12:
				numStr = "Queen";
				break;
			case 13:
				numStr = "King";
				break;
			case 1:
				numStr = "Ace";
				break;
		}
		return numStr + " of " + mySuit.toString();
	}
	

}
