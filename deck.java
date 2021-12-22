import java.util.Random;

//H trapoula mou
public class deck 
{
	//Array of the cards in the deck
	private Card[] myCards;
	
	//Poses kartes vriskonte sto deck auth thn stigmh
	private int numCards;
	
	public deck()
	{
		//kalw ton allon constructor gia na kanw define ena deck xwris shuffle
		this(1, false);
	}
	
	
	//constructor gia to posa deck tha xrisimopoioume kai an tha prepei na anakatepsoume to deck
	public deck(int numDeck,boolean shuffle)
	{
		this.numCards = numDeck * 52;
		this.myCards = new Card[this.numCards];
		
		//index card
		int c = 0;
		
		//for each deck
		for(int d=0; d<numDeck; d++)
		{
			//for each suit
			for(int s=0 ; s<4; s++)
			{
				//for each number
				for(int n=1; n<=13; n++)
				{
					//vazw kainourgia karta sto deck mou
					this.myCards[c] = new Card(Suit.values()[s], n);
					c++;
				}
			}
		}
		
		//shuffle
		if(shuffle)
		{
			this.shuffle();
		}
	}
	
	//kanw shyffle me random number ggenarator
	public void shuffle()
	{
		Random rng = new Random();
		
		Card temp;
		
		int j;
		for (int i=0; i<this.numCards; i++)
		{
			//pairnw ena j gia na allajw to value tou i
			j=rng.nextInt(this.numCards);
			
			//swap
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
		}
	}
	
	//Moirazw ttis kartes kai tis afairw apo to deck
	public Card dealNextCard()
	{
		//pairnw to top card
		Card top = this.myCards[0];
		
		//Kanw swift tis kartes mou mia fora aristera
		for(int c = 1; c<this.numCards; c++)
		{
			this.myCards[c-1] = this.myCards[c];
		}
		this.myCards[this.numCards-1] = null;
		
		//meiwnw ton arithmo
		this.numCards--;
		
		return top;
	}
	
	//kanw print ta top cards
	public void printDeck(int numToPrint)
	{
		for(int c=0; c<numToPrint; c++)
		{
			System.out.printf("%3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());
		}
		System.out.printf("\t\t[%d other]\n", this.numCards-numToPrint);
	}
	
}
