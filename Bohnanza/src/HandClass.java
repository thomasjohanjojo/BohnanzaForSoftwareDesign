import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class HandClass implements LogicOfTheGame.Hand {

    List<LogicOfTheGame.Card> listOfCardsInTheHand;

    public HandClass()
    {
        listOfCardsInTheHand = new ArrayList<>();
    }
    public LogicOfTheGame.Card getTheCardAtTheFrontOfTheHand()
    {
        if(listOfCardsInTheHand.size() == 0)
        {
            return null;
        }
        else
        {
            return listOfCardsInTheHand.removeFirst();
        }
    }

    public void AddACardToTheBackOfTheHand(LogicOfTheGame.Card cardToAddToTheBack)
    {
        listOfCardsInTheHand.addLast(cardToAddToTheBack);
    }

    public void DisplayTheCardsInTheHand()
    {
        LogicOfTheGame.Card temporaryHolderObjectForCard;
        for(int i = 0; i < listOfCardsInTheHand.size(); i++)
        {
            temporaryHolderObjectForCard = listOfCardsInTheHand.get(i);
            System.out.print(" " + temporaryHolderObjectForCard.returnTheTypeOfTheCard() );
        }
    }
}
