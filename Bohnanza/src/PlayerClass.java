import java.util.ArrayList;
import java.util.List;

public class PlayerClass  implements LogicOfTheGame.Player
{

    
    List<LogicOfTheGame.Card> listWhichHoldsTheCardsWhichWereMadeIntoCoins;

    public PlayerClass()
    {
        listWhichHoldsTheCardsWhichWereMadeIntoCoins = new ArrayList<>();
    }
    public void plant(LogicOfTheGame.Card cardsToPlant, LogicOfTheGame.Field fieldOfThePlayerToPlantTheseCards, LogicOfTheGame.Hand discardPile)
    {
        String theCardAboutToBePlanted = cardsToPlant.returnTheTypeOfTheCard();
        String theCardTypeOfTheField = fieldOfThePlayerToPlantTheseCards.getTheTypeOfCardInThisField();

        if(fieldOfThePlayerToPlantTheseCards.getTheNumberOfCardsInThisField() == 0)
        {
            fieldOfThePlayerToPlantTheseCards.addCardsToTheField(cardsToPlant);
        }

        else if(theCardAboutToBePlanted.equals(theCardTypeOfTheField))
        {
            fieldOfThePlayerToPlantTheseCards.addCardsToTheField(cardsToPlant);
        }

        else if(fieldOfThePlayerToPlantTheseCards.getTheNumberOfCardsInThisField() > 0)
        {
            harvest(fieldOfThePlayerToPlantTheseCards, discardPile);
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



    public void drawCardsFromTheDrawPileIntoTheHand(LogicOfTheGame.DrawPile drawPile, LogicOfTheGame.Hand handOfThisPlayer)
    {
        if(drawPile.isDrawPileEmpty() == false)
        {
            handOfThisPlayer.AddACardToTheBackOfTheHand(drawPile.getOneCardFromTheDrawPile());
        }
    }

    public void addTwoCardsToTheTurnOverCardsAreaFromTheDrawPileAndTurnThemOver(LogicOfTheGame.DrawPile drawPile, LogicOfTheGame.AreasToKeepTheTurnedOverAndTradedCards areaToKeepTheTurnedOverCards)
    {
        for(int i = 0; i < 2; i++)
        {
            if(drawPile.isDrawPileEmpty() == false)
            {
                areaToKeepTheTurnedOverCards.addACardToTheTurnedOverCardsArea(drawPile.getOneCardFromTheDrawPile());
            }
        }

    }

    public int returnTheNumberOfCoinsThatThePlayerCurrentlyHas()
    {
        return listWhichHoldsTheCardsWhichWereMadeIntoCoins.size();
    }







}
