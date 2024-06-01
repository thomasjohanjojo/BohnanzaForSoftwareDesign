
public class LogicOfTheGame {

    public interface DrawPile
    {
        Card getOneCardFromTheDrawPile();
    }

    public interface Player
    {
        void plant(Card cardsToPlant,Field fieldOfThePlayerToPlantTheseCards);
        void harvest(Field aFieldWhichBelongsToThisPlayer, Hand discardPile);
        void giveACardToTheOtherPlayer(Player playerToTradeTheCardsTo, Card cardToTrade);
        void getACardFromTheOtherPlayer(Hand handOfThisPlayer, Player player);
        void drawCardsFromTheDrawPileIntoTheHand(DrawPile drawPile, Hand handOfThisPlayer);
        void addCardsToTheTurnOverCardsAreaFromTheDrawPileAndTurnThemOver(DrawPile drawPile, Hand theAreaToKeepTheTurnedOverCards);
        int returnTheNumberOfCoinsThatThePlayerCurrentlyHas();
    }

    public interface Hand
    {
        Card getTheCardAtTheFrontOfTheHand();
        void AddACardToTheBackOfTheHand(Card cardToAddToTheBack);
        void DisplayTheCardsInTheHand();
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
            players[i].player.plant(players[i].hand.getTheCardAtTheFrontOfTheHand(), players[i].fieldOne);

            //Phase 2
            players[i].player.addCardsToTheTurnOverCardsAreaFromTheDrawPileAndTurnThemOver(drawPile,players[i].theAreaToKeepTheTurnedOverCards);

            //Phase 3
            players[i].player.harvest(players[i].fieldOne, discardPile);
            players[i].player.plant(players[i].theAreaToKeepTheTurnedOverCards.getTheCardAtTheFrontOfTheHand(), players[i].fieldOne);
            players[i].player.harvest(players[i].fieldTwo, discardPile);
            players[i].player.plant(players[i].theAreaToKeepTheTurnedOverCards.getTheCardAtTheFrontOfTheHand(), players[i].fieldTwo);

            //Phase 4
            players[i].player.drawCardsFromTheDrawPileIntoTheHand(drawPile, players[i].hand);
            players[i].player.drawCardsFromTheDrawPileIntoTheHand(drawPile, players[i].hand);
            players[i].player.drawCardsFromTheDrawPileIntoTheHand(drawPile, players[i].hand);
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

}
