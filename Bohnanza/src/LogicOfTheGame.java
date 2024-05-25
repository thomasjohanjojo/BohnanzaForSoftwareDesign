
public class LogicOfTheGame {

    public interface DrawPile
    {
        Card[] getCardsFromTheDrawPile(int numberOfCardsToGet);
    }

    public interface Player
    {
        void plant(Card cardsToPlant[],Field fieldOfThePlayerToPlantTheseCards);
        void harvest(Field aFieldWhichBelongsToThisPlayer);
        void tradeWithOtherPlayer(Player playerToTradeTheCardsTo, Card cardsToTrade[]);
        void drawCardsFromTheDrawPileIntoTheHand(DrawPile drawPile, Hand handOfThisPlayer);
        void turnOverCardsFromTheDrawPile(DrawPile drawPile, Card[] theTurnedOverHorizontalCardsOfThisPlayer);
    }

    public interface Hand
    {
        Card getTheCardAtTheFrontOfTheHand();
        void AddACardToTheBackOfTheHand(Card cardToAddToTheBack);
        String DisplayTheCardsInTheHand();
    }

    public interface Field
    {
        int getTheTotalCoinsThatCanBeGottenFromThisFieldNow();
        String getTheTypeOfCardInThisField();
        void getTheNumberOfCardsInThisField();
    }

    public interface Card
    {
        String returnTheTypeOfTheCard();
        int getTheNumberOfCardsOfThisTypeRequiredForOneCoin();
        int getTheNumberOfCardsOfThisTypeRequiredForTwoCoins();
        int getTheNumberOfCardsOfThisTypeRequiredForThreeCoins();
        int getTheNumberOfCardsOfThisTypeRequiredForFourPoints();
    }





    public void theFunctionWhichHasTheLogic()
    {

    }

}
