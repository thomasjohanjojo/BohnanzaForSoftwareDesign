import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawPileClass implements LogicOfTheGame.DrawPile
{
    List<LogicOfTheGame.Card> cardsOfTheDrawPile;
    int lengthOfTheDrawPileCardArray;

    public DrawPileClass()
    {
        cardsOfTheDrawPile = new ArrayList<LogicOfTheGame.Card>();
    }
    public LogicOfTheGame.Card getOneCardFromTheDrawPile()
    {
        LogicOfTheGame.Card cardToReturn;
        cardToReturn = cardsOfTheDrawPile.removeFirst();
        lengthOfTheDrawPileCardArray = lengthOfTheDrawPileCardArray - 1;
        return cardToReturn;
    }

    public void addACardToTheDrawPile(LogicOfTheGame.Card cardToBeAddedToTheDrawPile)
    {
        cardsOfTheDrawPile.addLast(cardToBeAddedToTheDrawPile);
    }
}
