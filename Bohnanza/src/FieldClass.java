import java.util.List;
import java.util.Collections;
public class FieldClass implements LogicOfTheGame.Field {
    List<LogicOfTheGame.Card> listOfCardsInTheField;

    public int getTheTotalCoinsThatCanBeGottenFromThisFieldNow()
    {
        return 0;
    }

    public String getTheTypeOfCardInThisField()
    {
        String typeOfCard = "null";
        return typeOfCard;
    }

    public int getTheNumberOfCardsInThisField()
    {
        return 0;
    }

    public void addCardsToTheField(LogicOfTheGame.Card cardToAddToTheField)
    {
        listOfCardsInTheField.add(cardToAddToTheField);
    }

    public LogicOfTheGame.Card removeACardFromTheTopOfTheField()
    {
        LogicOfTheGame.Card cardToBeRemoved;
        return cardToBeRemoved;
    }

    public LogicOfTheGame.Card returnTheCardFromTheFieldWithoutRemovingIt()
    {

    }

    public void displayAllTheCardsInTheField()
    {

    }
}
