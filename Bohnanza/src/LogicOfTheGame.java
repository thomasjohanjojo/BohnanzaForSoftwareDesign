
public class LogicOfTheGame {

    public interface DrawPile
    {

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
        Card returnTheCardAtTheFrontOfTheHand();
        void AddACardToTheBackOfTheHand(Card cardToAddToTheBack);
    }

    public interface Field
    {
        int returnTheTotalCoinsThatCanBeGottenFromThisFieldNow();
        Card returnTheTypeOfCardInThisField();
    }

    public interface Card
    {
        String returnTheTypeOfTheCard();
        int returnTheNumberOfCardsOfThisTypeRequiredForOneCoin();
        int returnTheNumberOfCardsOfThisTypeRequiredForTwoCoins();
        int returnTheNumberOfCardsOfThisTypeRequiredForThreeCoins();
        int returnTheNumberOfCardsOfThisTypeRequiredForFourPoints();
    }





    public void theFunctionWhichHasTheLogic()
    {

    }

}
