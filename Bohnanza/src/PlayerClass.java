import java.util.ArrayList;
import java.util.List;

public class PlayerClass  implements LogicOfTheGame.Player
{

    
    List<LogicOfTheGame.Card> listWhichHoldsTheCardsWhichWereMadeIntoCoins;

    public PlayerClass()
    {
        listWhichHoldsTheCardsWhichWereMadeIntoCoins = new ArrayList<>();
    }
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
            LogicOfTheGame.Card aSampleCardOfThisField = aFieldWhichBelongsToThisPlayer.returnTheCardFromTheFieldWithoutRemovingIt();
            if(aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() >= aSampleCardOfThisField.getTheNumberOfCardsOfThisTypeRequiredForFourCoins() )
            {
                if(aSampleCardOfThisField.getTheNumberOfCardsOfThisTypeRequiredForFourCoins() != -1) {


                    for (int i = 0; i < 4; i++) {
                        listWhichHoldsTheCardsWhichWereMadeIntoCoins.add(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }

                    while (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() != 0) {
                        discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }
                }
            }

            else if(aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() >= aSampleCardOfThisField.getTheNumberOfCardsOfThisTypeRequiredForThreeCoins())
            {
                for(int i = 0; i < 3; i++)
                {
                    listWhichHoldsTheCardsWhichWereMadeIntoCoins.add(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                }

                while(aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() != 0)
                {
                    discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                }
            }

            else if(aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() >= aSampleCardOfThisField.getTheNumberOfCardsOfThisTypeRequiredForTwoCoins())
            {
                for(int i = 0; i < 2; i++)
                {
                    listWhichHoldsTheCardsWhichWereMadeIntoCoins.add(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                }

                while(aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() != 0)
                {
                    discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                }
            }

            else if(aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() >= aSampleCardOfThisField.getTheNumberOfCardsOfThisTypeRequiredForOneCoin())
            {
                if(aSampleCardOfThisField.getTheNumberOfCardsOfThisTypeRequiredForOneCoin() != -1)
                {
                    for (int i = 0; i < 1; i++) {
                        listWhichHoldsTheCardsWhichWereMadeIntoCoins.add(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }

                    while (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() != 0) {
                        discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }
                }
                else
                {
                    while (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() != 0) {
                        discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
                    }
                }
            }

            else
            {
                while (aFieldWhichBelongsToThisPlayer.getTheNumberOfCardsInThisField() != 0) {
                    discardPile.AddACardToTheBackOfTheHand(aFieldWhichBelongsToThisPlayer.removeACardFromTheTopOfTheField());
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

    }

    public int returnTheNumberOfCoinsThatThePlayerCurrentlyHas()
    {
        return listWhichHoldsTheCardsWhichWereMadeIntoCoins.size();
    }



}
