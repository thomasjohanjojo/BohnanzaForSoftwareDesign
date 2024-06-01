import java.util.Collections;
import java.util.List;

public class DrawPileClass implements LogicOfTheGame.DrawPile
{
    List<LogicOfTheGame.Card> cardsOfTheDrawPile;
    int lengthOfTheDrawPileCardArray;

    DrawPileClass(List<LogicOfTheGame.Card> cardsOfTheDrawPile)
    {


        int i = 0;
        LogicOfTheGame.Card temporaryStorageInTheLoop;
        for(i = 0; i<cardsOfTheDrawPile.size();i++)
        {
            Collections.copy(this.cardsOfTheDrawPile, cardsOfTheDrawPile);
        }
        lengthOfTheDrawPileCardArray = cardsOfTheDrawPile.size();
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

    }
}
