import java.util.Scanner;
public class Game 
{

	public static void main(String[] args) 
	{
		//init
		Scanner sc = new Scanner(System.in);
		deck theDeck = new deck(1,true);
		
		boolean keepPlaying = true;
		
		
			//init players
			Player me = new Player("Akis");
			Player dealer = new Player("Dealer");
			
		int first=1; //gia na mhn exw provlima otan ksanaksekinw to paixnidi me to mirasma
		int insideF = 0;//gia na mhn exw provlima otan ksanaksekinw to paixnidi me to mirasma
		while(keepPlaying)
		{  	
			if(first==1)
			{
				me.addCard(theDeck.dealNextCard());
				dealer.addCard(theDeck.dealNextCard());
				me.addCard(theDeck.dealNextCard());
				dealer.addCard(theDeck.dealNextCard());
				
				//print ta prwta xeria
				System.out.println("Cards are dealt\n");
				System.out.println("---------------------------------------");
				me.printHand(true);
				System.out.println("---------------------------------------");
				dealer.printHand(false);
				System.out.println("---------------------------------------");
				System.out.println("\n");
			}
			
			
			
			//flags gia to potee stamatw na pairnw kainourgies kartes
			boolean meDone = false;
			boolean dealerDone = false;
			String ons;
			
			while(!meDone || !dealerDone)
			{
				//Na moirasw kartes
				if(first!=1 && insideF == 0)
				{
					me.addCard(theDeck.dealNextCard());
					dealer.addCard(theDeck.dealNextCard());
					me.addCard(theDeck.dealNextCard());
					dealer.addCard(theDeck.dealNextCard());
					
					//print ta prwta xeria
					System.out.println("Cards are dealt\n");
					System.out.println("---------------------------------------");
					me.printHand(true);
					System.out.println("---------------------------------------");
					dealer.printHand(false);
					System.out.println("---------------------------------------");
					System.out.println("\n");
					insideF++;
				}
				
				//An exw stamathsei
				if(!meDone)
				{
					System.out.println("---------------------------------------");
					System.out.println("Hit or Stay? (Please enter H or S): ");
					ons = sc.next();
					System.out.println();
					
					//An parw karta
					if(ons.compareToIgnoreCase("H") == 0)
					{
						//prosthetw kainourgia karta kai tsekarw an exasa
						System.out.println("---------------------------------------");
						System.out.println("Player Hits\n");
						System.out.println("---------------------------------------");
						meDone = !me.addCard(theDeck.dealNextCard());
						me.printHand(true);
					}
					else
					{
						System.out.println("---------------------------------------");
						System.out.println("Player stays\n");
						meDone = true;
					}
				}
				else
				{
					System.out.println("---------------------------------------");
					System.out.println("Player waits");
					System.out.println("---------------------------------------");
				}

					
				//Gia ton dealer an stamathse
				if(!dealerDone)
				{
					if(dealer.getHandsum() < 16)
					{
							System.out.println("---------------------------------------");
							System.out.println("The Dealer hits\n");
							System.out.println("---------------------------------------");
							dealerDone = !dealer.addCard(theDeck.dealNextCard());
							dealer.printHand(false);
					}
					else
					{
							System.out.println("---------------------------------------");
							System.out.println("The dealer stays\n");
							dealerDone = true;
					}
				 }
				else
				{
					System.out.println("---------------------------------------");
					System.out.println("dealer waits");
					System.out.println("---------------------------------------");
				}
				 System.out.println();
				
			}
				
				
				//print final hands
				System.out.println("Final Hand");
				System.out.println("---------------------------------------");
				me.printHand(true);
				System.out.println("---------------------------------------");
				dealer.printHand(true);
				System.out.println("---------------------------------------");
				
				
				int mySum = me.getHandsum();
				int dealerSum = dealer.getHandsum();
				
				if (mySum > dealerSum && mySum <= 21 || dealerSum > 21 )
				{
					System.out.println("You win\n");
					//gia nadw an tha ksanapeksw
					System.out.println("One more game? (Please enter Y or N)");
					ons = sc.next();
					if(ons.compareToIgnoreCase("Y") == 0 )
					{
						
						keepPlaying = true;
						me.emptyHand();
						dealer.emptyHand();
						insideF = 0;
					}
					else
					{
						keepPlaying = false;
					}
				} 
				else
				{
					System.out.println("Dealer wins\n");
					//gia nadw an tha ksanapeksw
					System.out.println("One more game? (Please enter Y or N)");
					ons = sc.next();
					if(ons.compareToIgnoreCase("Y") == 0 )
					{
						keepPlaying = true;
						dealer.emptyHand();
						me.emptyHand();
						insideF = 0; //to midenizw gt tha ksanapeksw
					}
					else
					{
						keepPlaying = false;
					}
				}
		first++;
		}
		
		//kleinw to scanner
		sc.close();
		System.out.println("---------------------------------------");
		System.out.println("The Game ended. Thanks for playing. :)");
	}

}
