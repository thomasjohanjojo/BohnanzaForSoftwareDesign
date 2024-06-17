import java.util.Scanner;
public class LogicOfTheGame {

    public interface DrawPile
    {
        void addACardToTheDrawPile(Card cardToBeAddedToTheDrawPile);
        Card getOneCardFromTheDrawPile();
    }

    public interface Player
    {
        void plant(Card cardsToPlant,Field fieldOfThePlayerToPlantTheseCards);
        void harvest(Field aFieldWhichBelongsToThisPlayer, Hand discardPile);
        void giveACardToTheOtherPlayer(Player playerToTradeTheCardsTo, Card cardToTrade);
        void getACardFromTheOtherPlayer(Hand handOfThisPlayer, Player player);
        void getACardFromTheTurnedOverAreaOfAnotherPlayer(AreasToKeepTheTurnedOverAndTradedCards turnedOverAreaOfTheOtherPlayer, AreasToKeepTheTurnedOverAndTradedCards tradedCardsAreaOfTheReceivingPlayer);
        void drawCardsFromTheDrawPileIntoTheHand(DrawPile drawPile, Hand handOfThisPlayer);
        void addCardsToTheTurnOverCardsAreaFromTheDrawPileAndTurnThemOver(DrawPile drawPile, Hand theAreaToKeepTheTurnedOverCards);
        int returnTheNumberOfCoinsThatThePlayerCurrentlyHas();
    }

    public interface AreasToKeepTheTurnedOverAndTradedCards
    {
        void addACardToTheTurnedOverCardsArea(Card cardToAdd);
        void addACardToTheTradedCardsArea(Card cardToAdd);
        Card removeAndReturnATradedAreaCard(int indexOfTheCardWhichYouWantToReturn);
        Card removeAndReturnATurnedOverAreaCard(int indexOfTheCardWhichYouWantToReturn);
        void displayTheTurnedOverCardsInOrder();
        void displayTheCardsInTheTradedCardsArea();

    }

    public interface Hand
    {
        Card getTheCardAtTheFrontOfTheHand();
        void AddACardToTheBackOfTheHand(Card cardToAddToTheBack);
        void DisplayTheCardsInTheHand();
        Card getACardFromAnyLocationInTheHand(int indexOfTheLocationOfTheCard);
        boolean isTheHandEmpty();
    }

    public interface Field
    {
        int getTheTotalCoinsThatCanBeGottenFromThisFieldNow();
        String getTheTypeOfCardInThisField();
        int getTheNumberOfCardsInThisField();
        void addCardsToTheField(Card cardToAddToTheField);
        Card removeACardFromTheTopOfTheField();
        Card returnTheCardFromTheFieldWithoutRemovingIt();
        void displayAllTheCardsInTheField();
    }

    public interface Card
    {
        String returnTheTypeOfTheCard();
        int getTheNumberOfCardsOfThisTypeRequiredForOneCoin();
        int getTheNumberOfCardsOfThisTypeRequiredForTwoCoins();
        int getTheNumberOfCardsOfThisTypeRequiredForThreeCoins();
        int getTheNumberOfCardsOfThisTypeRequiredForFourCoins();
    }


    public void theFunctionWhichHasTheLogic(TheClassWhichHasThePlayerHandAndFields[] players, DrawPile drawPile, Hand discardPile)
    {
        distributeTheInitialFiveCardsToThePlayer(players, drawPile);
        loopOfPlayersGoingThroughTurns(players, drawPile, discardPile);

    }

    private void loopOfPlayersGoingThroughTurns(TheClassWhichHasThePlayerHandAndFields[] players, DrawPile drawPile,Hand discardPile)
    {
        int i = 0;
        for(i = 0; i < players.length; i++)
        {
            //Phase 1
            System.out.print("\n\nPhase 1 of Player:" + (i+1));
            System.out.print("\nThe hand of the player is: ");
            players[i].hand.DisplayTheCardsInTheHand();
            players[i].player.plant(players[i].hand.getTheCardAtTheFrontOfTheHand(), players[i].fieldOne);
            System.out.print("\nThe cards in field one is: ");
            players[i].fieldOne.displayAllTheCardsInTheField();
            System.out.print("\nThe hand of the Player after Phase 1 is:");
            players[i].hand.DisplayTheCardsInTheHand();

            //Phase 2
            System.out.print("\nPhase 2 of Player:" + (i+1));
            players[i].player.addCardsToTheTurnOverCardsAreaFromTheDrawPileAndTurnThemOver(drawPile,players[i].theAreaToKeepTheTurnedOverCards);
            System.out.print("\nThe turned over cards: ");
            players[i].theAreaToKeepTheTurnedOverCards.DisplayTheCardsInTheHand();

            //Phase 3
            System.out.print("\nPhase 3 of Player:" + (i+1));
            players[i].player.harvest(players[i].fieldOne, discardPile);
            players[i].player.plant(players[i].theAreaToKeepTheTurnedOverCards.getTheCardAtTheFrontOfTheHand(), players[i].fieldOne);
            players[i].player.harvest(players[i].fieldTwo, discardPile);
            players[i].player.plant(players[i].theAreaToKeepTheTurnedOverCards.getTheCardAtTheFrontOfTheHand(), players[i].fieldTwo);
            int coins = players[i].player.returnTheNumberOfCoinsThatThePlayerCurrentlyHas();
            System.out.print("\n The cards in field one are:");
            players[i].fieldOne.displayAllTheCardsInTheField();
            System.out.print("\n The Cards in field two are:");
            players[i].fieldTwo.displayAllTheCardsInTheField();
            System.out.print("\nThe number of coins that the player currently has:" + coins);

            //Phase 4
            System.out.print("\nPhase 4 of Player:" + (i+1));
            players[i].player.drawCardsFromTheDrawPileIntoTheHand(drawPile, players[i].hand);
            players[i].player.drawCardsFromTheDrawPileIntoTheHand(drawPile, players[i].hand);
            players[i].player.drawCardsFromTheDrawPileIntoTheHand(drawPile, players[i].hand);
            System.out.print("\nThe hand of the player is: ");
            players[i].hand.DisplayTheCardsInTheHand();
        }
    }

    private void distributeTheInitialFiveCardsToThePlayer(TheClassWhichHasThePlayerHandAndFields[] players, DrawPile drawPile)
    {
        int i = 0;
        for(i = 0; i < players.length; i++)
        {
            int j = 0;
            for(j = 0; j < 5; j++)
            {
                players[i].hand.AddACardToTheBackOfTheHand(drawPile.getOneCardFromTheDrawPile());
            }
        }
    }


    public void theGameLoopWithInputFromPlayers(TheClassWhichHasThePlayerHandAndFields[] players, DrawPile drawPile,Hand discardPile)
    {
        Scanner scanner = new Scanner(System.in);


        int numberOfTimesTheDrawPileHasBeenEmptied = 0;
        while(numberOfTimesTheDrawPileHasBeenEmptied < 3)
        {
            for(int i = 0; i < 4; i ++)
            {
                //Phase 1
                System.out.print("\n Turn of player:" + i);
                System.out.print("\n Phase 1, the card at the front of the hand will be planted now:");
                System.out.print("\nThe hand of the player is: ");
                players[i].hand.DisplayTheCardsInTheHand();
                System.out.print(("\n Select the field which you want to plant it in (1 or 2):"));
                int choice = scanner.nextInt();
                if(choice == 1)
                {
                    players[i].player.plant(players[i].hand.getTheCardAtTheFrontOfTheHand(), players[i].fieldOne);
                }
                else if(choice == 2)
                {
                    players[i].player.plant(players[i].hand.getTheCardAtTheFrontOfTheHand(), players[i].fieldTwo);
                }
                System.out.print("\n The card has been planted, the fields are:");
                System.out.print("\n Field One:");
                players[i].fieldOne.displayAllTheCardsInTheField();
                System.out.print("\n Field Two");
                players[i].fieldTwo.displayAllTheCardsInTheField();
                System.out.print(("\n The hand is now:"));
                players[i].hand.DisplayTheCardsInTheHand();
                System.out.print("\n Do you want to plant one more card? (1 for yes, 0 for no) ?:");
                choice = scanner.nextInt();
                if(choice == 1)
                {
                    System.out.print("Select the field which you want to plant to (1 for field one, 2 for field two):");
                    choice = scanner.nextInt();
                    if(choice == 1)
                    {
                        players[i].player.plant(players[i].hand.getTheCardAtTheFrontOfTheHand(), players[i].fieldOne);
                        System.out.print("\n The field one is now:");
                        players[i].fieldOne.displayAllTheCardsInTheField();
                    }
                    else if(choice == 2)
                    {
                        players[i].player.plant(players[i].hand.getTheCardAtTheFrontOfTheHand(), players[i].fieldTwo);
                        System.out.print("\n The field two is now:");
                        players[i].fieldTwo.displayAllTheCardsInTheField();
                    }

                }

                else if(choice == 0)
                {
                    System.out.print("Hand after phase 1:");
                    players[i].hand.DisplayTheCardsInTheHand();
                }
                else {
                    System.out.print("\n Enter a valid number:");
                }




            }
        }
    }


    public void phaseOne()
    {
        
    }

}
