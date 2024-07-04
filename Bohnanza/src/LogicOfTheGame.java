import java.util.Scanner;
public class LogicOfTheGame {

    public interface DrawPile
    {
        void addACardToTheDrawPile(Card cardToBeAddedToTheDrawPile);
        Card getOneCardFromTheDrawPile();
        boolean isDrawPileEmpty();
        void shuffleTheDrawPile();
    }

    public interface Player
    {
        void plant(Card cardsToPlant,Field fieldOfThePlayerToPlantTheseCards, Hand discardPile);
        void harvest(Field aFieldWhichBelongsToThisPlayer, Hand discardPile);
        void drawCardsFromTheDrawPileIntoTheHand(DrawPile drawPile, Hand handOfThisPlayer);
        void addTwoCardsToTheTurnOverCardsAreaFromTheDrawPileAndTurnThemOver(DrawPile drawPile, AreasToKeepTheTurnedOverAndTradedCards areaToKeepTheTurnedOverCards);
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
        int returnTheNumberOfTurnedOverCardsInTheTurnedOverCardsArea();
        int returnTheNumberOfTradedCardsInTheTradedCardsArea();

    }

    public interface Hand
    {
        Card getTheCardAtTheFrontOfTheHand();
        void AddACardToTheBackOfTheHand(Card cardToAddToTheBack);
        void DisplayTheCardsInTheHand();
        Card getACardFromAnyLocationInTheHand(int indexOfTheLocationOfTheCard);
        boolean isTheHandEmpty();
        int getTheNumberOfCardsInTheHand();
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

        for(int i = 0; i < 3;)
        {
            for(int activePlayerNumber = 0; activePlayerNumber < players.length; activePlayerNumber++)
            {
                plantingTheFirstCardAndMaybeAlsoTheSecondCard(players[activePlayerNumber],discardPile);
                gettingTurnedOverCards(players[activePlayerNumber], drawPile, discardPile);
                tradingPhase(activePlayerNumber, players,drawPile, discardPile);
                plantingTurnedOverAndTradedCards(players[activePlayerNumber], players, discardPile);
                DrawThreeCards(players[activePlayerNumber], drawPile);
            }

            if(drawPile.isDrawPileEmpty() == true)
            {
                i++;
                transferCardsFromTheDiscardPileToTheDrawPileAndShuffleTheDrawPile(drawPile, discardPile);
            }

        }

        HarvestAllTheFieldsOfAllThePlayers(players, discardPile);
        showTheScoresOfAllThePlayers(players);

    }

    private void showTheScoresOfAllThePlayers(TheClassWhichHasThePlayerHandAndFields[] players)
    {
        for(int i = 0; i < players.length; i++)
        {
            System.out.print("\n Coins of Player:" + i + " is:" + players[i].player.returnTheNumberOfCoinsThatThePlayerCurrentlyHas());
        }
    }

    private void HarvestAllTheFieldsOfAllThePlayers(TheClassWhichHasThePlayerHandAndFields[] players, Hand discardPile)
    {
        for(int i = 0; i < players.length; i ++)
        {
            players[i].player.harvest(players[i].fieldOne, discardPile);
            players[i].player.harvest(players[i].fieldTwo, discardPile);

            if(players[i].isTheThirdFieldAvailable == true)
            {
                players[i].player.harvest(players[i].fieldThree, discardPile);
            }
        }
    }

    private void transferCardsFromTheDiscardPileToTheDrawPileAndShuffleTheDrawPile(DrawPile drawPile, Hand discardPile)
    {

        while (discardPile.isTheHandEmpty() == false)
        {
            drawPile.addACardToTheDrawPile(discardPile.getTheCardAtTheFrontOfTheHand());
        }
        drawPile.shuffleTheDrawPile();

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

    private void DrawThreeCards(TheClassWhichHasThePlayerHandAndFields activePlayer, DrawPile drawPile)
    {
        for(int i = 0; i < 3; i++) {
            activePlayer.player.drawCardsFromTheDrawPileIntoTheHand(drawPile, activePlayer.hand);
        }
    }





    private void plantingTheFirstCardAndMaybeAlsoTheSecondCard(TheClassWhichHasThePlayerHandAndFields activePlayer, Hand discardPile)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("You must plant a card if you have one");

        if(activePlayer.hand.isTheHandEmpty() == false)
        {
            activePlayer.hand.DisplayTheCardsInTheHand();
            Card cardToPlant = activePlayer.hand.getTheCardAtTheFrontOfTheHand();
            plantTheCard(activePlayer, discardPile, cardToPlant);
        }

        if(activePlayer.hand.isTheHandEmpty() == false)
        {
            System.out.print("Do you want to plant once more? 1:Yes 0:No");
            int choice = scanner.nextInt();
            if(choice < 0 || choice > 1)
            {
                System.out.print("Wrong Choice, Do again");
                return;
            }
            else
            {
                activePlayer.hand.DisplayTheCardsInTheHand();
                Card cardToPlant = activePlayer.hand.getTheCardAtTheFrontOfTheHand();
                plantTheCard(activePlayer, discardPile, cardToPlant);
            }
        }
    }



    private void plantTheCard(TheClassWhichHasThePlayerHandAndFields activePlayer, Hand discardPile, Card cardToPlant)
    {
        Scanner scanner = new Scanner(System.in);
        int fieldToPlantTheCardIn = 1;
        if(activePlayer.isTheThirdFieldAvailable == false)
        {
            System.out.print("\n To Which field do you want to plant 1:Field One  2: Field Two?:");
            fieldToPlantTheCardIn = scanner.nextInt();
            if(fieldToPlantTheCardIn < 1 || fieldToPlantTheCardIn > 2)
            {
                System.out.print("\n Wrong input, do again");
                return;
            }
        }
        else if(activePlayer.isTheThirdFieldAvailable == true)
        {
            System.out.print("\n To Which field do you want to plant 1:Field One 2:Field Two 3:Field Three?:");
            fieldToPlantTheCardIn = scanner.nextInt();
            if(fieldToPlantTheCardIn < 1 || fieldToPlantTheCardIn > 3)
            {
                System.out.print("\n Wrong input, do again");
                return;
            }
        }


        if(fieldToPlantTheCardIn == 1)
        {

            if(activePlayer.isTheThirdFieldAvailable == false)
            {
                if (canYouHarvestThisField(activePlayer.fieldOne, activePlayer.fieldTwo) == true)
                {
                    activePlayer.player.plant(cardToPlant, activePlayer.fieldOne, discardPile);
                }
                else
                {
                    System.out.print("\n Bean protection rule, try again");
                }
            }

            else if(activePlayer.isTheThirdFieldAvailable == true)
            {
                if(canYouHarvestThisField(activePlayer.fieldOne, activePlayer.fieldTwo) == true && canYouHarvestThisField(activePlayer.fieldOne, activePlayer.fieldThree))
                {
                    activePlayer.player.plant(cardToPlant, activePlayer.fieldOne, discardPile);
                }
                else
                {
                    System.out.print("\n Bean protection rule, try again");
                }
            }
        }

        else if(fieldToPlantTheCardIn == 2)
        {
            if(activePlayer.isTheThirdFieldAvailable == false)
            {
                if (canYouHarvestThisField(activePlayer.fieldTwo, activePlayer.fieldOne) == true)
                {
                    activePlayer.player.plant(cardToPlant, activePlayer.fieldTwo, discardPile);
                }
                else
                {
                    System.out.print("\n Bean protection rule, try again");
                }
            }
            else if(activePlayer.isTheThirdFieldAvailable == true)
            {
                if(canYouHarvestThisField(activePlayer.fieldTwo, activePlayer.fieldOne) == true && canYouHarvestThisField(activePlayer.fieldTwo, activePlayer.fieldThree) == true)
                {
                    activePlayer.player.plant(cardToPlant, activePlayer.fieldTwo, discardPile);
                }
                else
                {
                    System.out.print("\n Bean protection rule, try again");
                }
            }
        }

        else if(fieldToPlantTheCardIn == 3)
        {
            if(canYouHarvestThisField(activePlayer.fieldThree, activePlayer.fieldOne) == true && canYouHarvestThisField(activePlayer.fieldThree, activePlayer.fieldTwo) == true)
            {
                activePlayer.player.plant(cardToPlant, activePlayer.fieldThree, discardPile);
            }

            else
            {
                System.out.print("\n Bean protection rule, try again");
            }
        }
    }

    private boolean canYouHarvestThisField(Field fieldToHarvest, Field fieldToCheckWith)
    {
        int numberOfBeansInFieldToHarvest = fieldToHarvest.getTheNumberOfCardsInThisField();
        int numberOfBeansInFieldToCheckWith = fieldToCheckWith.getTheNumberOfCardsInThisField();
        if(numberOfBeansInFieldToHarvest == 1 && (numberOfBeansInFieldToCheckWith > 1))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    private void gettingTurnedOverCards(TheClassWhichHasThePlayerHandAndFields activePlayer,DrawPile drawPile, Hand discardPile)
    {
        activePlayer.player.addTwoCardsToTheTurnOverCardsAreaFromTheDrawPileAndTurnThemOver(drawPile, activePlayer.theAreaToKeepTheTurnedOverAndTradedCards);
    }


    private void tradingPhase(int theIndexOfTheCurrentlyActivePlayerInThePlayersArray, TheClassWhichHasThePlayerHandAndFields[] players, DrawPile drawPile,Hand discardPile)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n With which player do you want to trade: 1, 2, 3, 4 ? :");
        int theIndexOfThePlayerWithWhichTradeMustBeDone = scanner.nextInt();
        if(theIndexOfThePlayerWithWhichTradeMustBeDone == theIndexOfTheCurrentlyActivePlayerInThePlayersArray)
        {
            System.out.print("\n Self trade not possible");
            return;
        }
        System.out.print("\n How many cards do you want to trade? 0 or more :");
        int theNumberOfCardsTheActivePlayerWantsToTradeAway = scanner.nextInt();

        if(theNumberOfCardsTheActivePlayerWantsToTradeAway < 0)
        {
            System.out.print("\n Impossible number of cards, try again with a number zero or above");
            return;
        }

        for(int i = 0; i < theNumberOfCardsTheActivePlayerWantsToTradeAway; i++)
        {

            System.out.print("\n From where do you want to remove the card? 0:Hand, 1:TurnedOverCards :");
            int thePlaceFromWhichToTradeAwayTheCard = scanner.nextInt();

            if(thePlaceFromWhichToTradeAwayTheCard == 0)
            {
                players[theIndexOfTheCurrentlyActivePlayerInThePlayersArray].hand.DisplayTheCardsInTheHand();
                System.out.print("\n Which card do you want to trade away? Index starts from 0:");
                int theIndexOfTheCardToTradeAway = scanner.nextInt();

                if(theIndexOfTheCardToTradeAway < 0 || (theIndexOfTheCardToTradeAway + 1) > players[theIndexOfTheCurrentlyActivePlayerInThePlayersArray].hand.getTheNumberOfCardsInTheHand())
                {
                    System.out.print("\n An incorrect number has been input");
                    return;
                }



                Card theCardToTradeAway = players[theIndexOfTheCurrentlyActivePlayerInThePlayersArray].hand.getACardFromAnyLocationInTheHand(theIndexOfTheCardToTradeAway);
                players[theIndexOfThePlayerWithWhichTradeMustBeDone].theAreaToKeepTheTurnedOverAndTradedCards.addACardToTheTradedCardsArea(theCardToTradeAway);


            }

            else if(thePlaceFromWhichToTradeAwayTheCard == 1)
            {
                players[theIndexOfTheCurrentlyActivePlayerInThePlayersArray].theAreaToKeepTheTurnedOverAndTradedCards.displayTheTurnedOverCardsInOrder();
                System.out.print("\nEnter the index of the card which you want to trade away, starting from 0 ending at 1:");
                int theIndexOfTheCardToTradeAway = scanner.nextInt();

                if(theIndexOfTheCardToTradeAway > 1 || theIndexOfTheCardToTradeAway < 0)
                {
                    System.out.print("\n Wrong index, do again");
                    return;
                }

                Card cardToTradeAway = players[theIndexOfTheCurrentlyActivePlayerInThePlayersArray].theAreaToKeepTheTurnedOverAndTradedCards.removeAndReturnATurnedOverAreaCard(theIndexOfTheCardToTradeAway);
                players[theIndexOfThePlayerWithWhichTradeMustBeDone].theAreaToKeepTheTurnedOverAndTradedCards.addACardToTheTradedCardsArea(cardToTradeAway);


            }



        }

        System.out.print("\n The other player can now trade back to the active player");
        System.out.print("\n How many cards do you want to trade back to the active player? Zero or more:");

        int numberOfCardsThatTheOtherPlayerWantsToTradeBack = scanner.nextInt();

        if(numberOfCardsThatTheOtherPlayerWantsToTradeBack < 0 || numberOfCardsThatTheOtherPlayerWantsToTradeBack > players[theIndexOfThePlayerWithWhichTradeMustBeDone].hand.getTheNumberOfCardsInTheHand())
        {
            System.out.print("\n Wrong input, do again");
            return;
        }

        for(int i = 0; i < numberOfCardsThatTheOtherPlayerWantsToTradeBack; i++)
        {
            players[theIndexOfThePlayerWithWhichTradeMustBeDone].hand.DisplayTheCardsInTheHand();
            System.out.print("\n Enter the index of the card to trade away, starting from zero:");
            int theIndexOfTheCardToTradeAway = scanner.nextInt();

            if(theIndexOfTheCardToTradeAway < 0 || (theIndexOfTheCardToTradeAway + 1) > players[theIndexOfThePlayerWithWhichTradeMustBeDone].hand.getTheNumberOfCardsInTheHand())
            {
                System.out.print("\n Wrong input, do again");
                return;
            }

            Card cardToTradeAway = players[theIndexOfThePlayerWithWhichTradeMustBeDone].hand.getACardFromAnyLocationInTheHand(theIndexOfTheCardToTradeAway);
            players[theIndexOfTheCurrentlyActivePlayerInThePlayersArray].theAreaToKeepTheTurnedOverAndTradedCards.addACardToTheTradedCardsArea(cardToTradeAway);

        }



    }

    private void plantingTurnedOverAndTradedCards(TheClassWhichHasThePlayerHandAndFields activePlayer,TheClassWhichHasThePlayerHandAndFields players[], Hand discardPile)
    {
        plantingTurnedOverCards(activePlayer, discardPile);
        for(int i = 0; i < players.length; i++)
        {
            plantingTradedCards(players[i], discardPile);
        }

    }

    private void plantingTurnedOverCards(TheClassWhichHasThePlayerHandAndFields activePlayer, Hand discardPile)
    {
        Scanner scanner = new Scanner(System.in);
        if(activePlayer.theAreaToKeepTheTurnedOverAndTradedCards.returnTheNumberOfTurnedOverCardsInTheTurnedOverCardsArea() > 0)
        {
            activePlayer.theAreaToKeepTheTurnedOverAndTradedCards.displayTheTurnedOverCardsInOrder();
            while(activePlayer.theAreaToKeepTheTurnedOverAndTradedCards.returnTheNumberOfTurnedOverCardsInTheTurnedOverCardsArea() != 0)
            {
               Card cardToPlant = activePlayer.theAreaToKeepTheTurnedOverAndTradedCards.removeAndReturnATurnedOverAreaCard(0);
               plantTheCard(activePlayer,discardPile, cardToPlant);
            }
        }
    }

    private void plantingTradedCards(TheClassWhichHasThePlayerHandAndFields activePlayer, Hand discardPile)
    {
        Scanner scanner = new Scanner(System.in);
        if(activePlayer.theAreaToKeepTheTurnedOverAndTradedCards.returnTheNumberOfTradedCardsInTheTradedCardsArea() > 0)
        {
            activePlayer.theAreaToKeepTheTurnedOverAndTradedCards.displayTheCardsInTheTradedCardsArea();
            while(activePlayer.theAreaToKeepTheTurnedOverAndTradedCards.returnTheNumberOfTradedCardsInTheTradedCardsArea() != 0)
            {
                Card cardToPlant = activePlayer.theAreaToKeepTheTurnedOverAndTradedCards.removeAndReturnATradedAreaCard(0);
                plantTheCard(activePlayer, discardPile, cardToPlant);
            }
        }
    }



}
