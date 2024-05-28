public class PlayerClass  implements LogicOfTheGame.Player
{
    public void plant(LogicOfTheGame.Card cardsToPlant, LogicOfTheGame.Field fieldOfThePlayerToPlantTheseCards)
    {
        String theCardAboutToBePlanted = cardsToPlant.returnTheTypeOfTheCard();
        String theCardTypeOfTheField = fieldOfThePlayerToPlantTheseCards.getTheTypeOfCardInThisField();
        if(theCardAboutToBePlanted.equals(theCardTypeOfTheField))
        {
            fieldOfThePlayerToPlantTheseCards.addCardsToTheField(cardsToPlant);
        }
        else if(fieldOfThePlayerToPlantTheseCards.getTheNumberOfCardsInThisField() == 0)
        {
            fieldOfThePlayerToPlantTheseCards.addCardsToTheField(cardsToPlant);
        }
    }

    public void harvest(LogicOfTheGame.Field aFieldWhichBelongsToThisPlayer, LogicOfTheGame.Hand discardPile)
    {
        
    }

    public void giveACardToTheOtherPlayer(LogicOfTheGame.Player playerToTradeTheCardsTo, LogicOfTheGame.Card cardToTrade)
    {

    }

    public void getACardFromTheOtherPlayer(LogicOfTheGame.Hand handOfThisPlayer, LogicOfTheGame.Player player)
    {

    }

    public void drawCardsFromTheDrawPileIntoTheHand(LogicOfTheGame.DrawPile drawPile, LogicOfTheGame.Hand handOfThisPlayer)
    {
        handOfThisPlayer.AddACardToTheBackOfTheHand(drawPile.getOneCardFromTheDrawPile());
    }

    public void addCardsToTheTurnOverCardsAreaFromTheDrawPileAndTurnThemOver(LogicOfTheGame.DrawPile drawPile, LogicOfTheGame.Hand theAreaToKeepTheTurnedOverCards)
    {
        theAreaToKeepTheTurnedOverCards.AddACardToTheBackOfTheHand(drawPile.getOneCardFromTheDrawPile());
        theAreaToKeepTheTurnedOverCards.AddACardToTheBackOfTheHand(drawPile.getOneCardFromTheDrawPile());
        theAreaToKeepTheTurnedOverCards.DisplayTheCardsInTheHand();
    }



}
