public class DrawPileClass implements LogicOfTheGame.DrawPile
{
    LogicOfTheGame.Card[] cardsOfTheDrawPile;
    int lengthOfTheDrawPileCardArray;

    DrawPileClass(LogicOfTheGame.Card[] cardsOfTheDrawPile)
    {
        this.cardsOfTheDrawPile = cardsOfTheDrawPile;
        lengthOfTheDrawPileCardArray = cardsOfTheDrawPile.length;
    }
    @Override
    public LogicOfTheGame.Card getOneCardFromTheDrawPile()
    {
        LogicOfTheGame.Card cardToReturn;
        cardToReturn = cardsOfTheDrawPile[lengthOfTheDrawPileCardArray];
        lengthOfTheDrawPileCardArray = lengthOfTheDrawPileCardArray - 1;
        return cardToReturn;
    }
}
