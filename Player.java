
public class Player 
{
	//to onoma tou paikth
	private String name;
	
	//Oi kartes sto xeri tu paikth
	private Card[] hand = new Card[10];

	//O arithmos twn kartwn sto xeri tou
	private int numCards;
	
	public Player(String aName)
	{
		this.name = aName;
		
		//Vazw adeio xeri ston paixth
		this.emptyHand();
	}
	
	//Kanw reset to xeri toy paikth
	public void emptyHand()
	{
		for (int c=0; c<10; c++)
		{
			this.hand[c] = null;
		}
		this.numCards = 0;
	}
	
	//adds a card to playesr hand
	//episeis tha chekarw an tha eimaste panw i katw tou 21 an gyrisw false tote perasa to 21
	public boolean addCard(Card aCard)
	{
		//printarw error an exw max cards
		if (this.numCards == 10)
		{
			System.err.printf("%s's hand already full:" + "cannot add another card\n", this.name);
			System.exit(1);
		}
		
		//dinw kai alli karta
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return (this.getHandsum() <= 21);
	}
	
	
	public int getHandsum()
	{
		int handSum = 0;
		int cardNum;
		int numAces = 0;
		
		//metraw to posous pontous prostheti kathe karta sto xeri mou
		for(int c=0; c<this.numCards; c++)
		{
			//get the num for the current card
			cardNum = this.hand[c].getNumber();
			
			if(cardNum==1)
			{
				numAces++;
				handSum+=11;
			}
			else if(cardNum > 10)
			{
				handSum += 10;
			}
			else
			{
				handSum += cardNum;
			}
		}
		
		//se periptosh pou exw ace kai pairnaw to 21 to metatrepw apo 11 se 1
		while(handSum > 21 && numAces > 0)
		{
			handSum -= 10;
			numAces--;
		}
		
		
		return handSum;
	}
	
	//print to xeri tou paikti
	public void printHand(boolean ShowFirstCard)
	{
		System.out.printf("%s's cards:\n", this.name);
		for(int c=0; c<this.numCards; c++)
		{
			if(c == 0 && !ShowFirstCard)
			{
				System.out.printf("  [hidden]");
			}
			else
			{
				System.out.printf(" %s\n", this.hand[c].toString());
			}
		}
	}
}
