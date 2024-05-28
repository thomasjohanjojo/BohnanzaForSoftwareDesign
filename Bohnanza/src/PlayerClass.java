public class PlayerClass  implements LogicOfTheGame.Player
{

    int theNumberOfCoinsThatThePlayerCurrentlyHas = 0;
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


        if(aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() < 1)
        {
            return;
        }

        else
        {


            while (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() >= 1) {
                LogicOfTheGame.Card cardTypeOfThisField = aFieldWhichBelongsToThisPlayer.returnTheCardFromTheFieldWithoutRemovingIt();
                if (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() > cardTypeOfThisField.getTheNumberOfCardsOfThisTypeRequiredForFourCoins()) {
                    for (int i = 0; i < cardTypeOfThisField.getTheNumberOfCardsOfThisTypeRequiredForFourCoins(); i++) {
                        discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }
                }

                else if (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() > cardTypeOfThisField.getTheNumberOfCardsOfThisTypeRequiredForThreeCoins()) {
                    for (int i = 0; i < cardTypeOfThisField.getTheNumberOfCardsOfThisTypeRequiredForThreeCoins(); i++) {
                        discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }

                }

                else if (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() > cardTypeOfThisField.getTheNumberOfCardsOfThisTypeRequiredForTwoCoins()) {
                    for (int i = 0; i < cardTypeOfThisField.getTheNumberOfCardsOfThisTypeRequiredForTwoCoins(); i++) {
                        discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }
                }

                else if (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() >= cardTypeOfThisField.getTheNumberOfCardsOfThisTypeRequiredForOneCoin()) {
                    for (int i = 0; i < cardTypeOfThisField.getTheNumberOfCardsOfThisTypeRequiredForOneCoin(); i++) {
                        discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }
                }

                else if (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() < cardTypeOfThisField.getTheNumberOfCardsOfThisTypeRequiredForOneCoin())
                {
                    while(aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() > 0)
                    {
                        discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }
                }


            }
        }

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

    public int returnTheNumberOfCoinsThatThePlayerCurrentlyHas()
    {
        return theNumberOfCoinsThatThePlayerCurrentlyHas;
    }



}
