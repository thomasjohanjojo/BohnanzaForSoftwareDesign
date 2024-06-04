import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

public class FieldClass implements LogicOfTheGame.Field {
    List<LogicOfTheGame.Card> listOfCardsInTheField;

    public FieldClass()
    {
        listOfCardsInTheField = new ArrayList<>();
    }

    public int getTheTotalCoinsThatCanBeGottenFromThisFieldNow()
    {
        return 0;
    }

    public String getTheTypeOfCardInThisField()
    {
        if(listOfCardsInTheField.size() != 0)
        {
            LogicOfTheGame.Card temporaryHolderObject;
            temporaryHolderObject = listOfCardsInTheField.get(0);
            return temporaryHolderObject.returnTheTypeOfTheCard();
        }

        else
        {
            return null;
        }

    }

    public int getTheNumberOfCardsInThisField()
    {
        return listOfCardsInTheField.size();
    }

    public void addCardsToTheField(LogicOfTheGame.Card cardToAddToTheField)
    {
        if(listOfCardsInTheField.size() == 0)
        {
            listOfCardsInTheField.add(cardToAddToTheField);
        }

        else
        {
            LogicOfTheGame.Card temporaryHolder;
            temporaryHolder = listOfCardsInTheField.get(0);
            if(Objects.equals(temporaryHolder.returnTheTypeOfTheCard(), cardToAddToTheField.returnTheTypeOfTheCard()))
            {
                listOfCardsInTheField.add(cardToAddToTheField);
            }
        }
    }

    public LogicOfTheGame.Card removeACardFromTheTopOfTheField()
    {
        if(listOfCardsInTheField.size() != 0)
        {
            return listOfCardsInTheField.removeFirst();
        }
        else
        {
            return null;
        }
    }

    public LogicOfTheGame.Card returnTheCardFromTheFieldWithoutRemovingIt()
    {
        LogicOfTheGame.Card temporaryHolderObjectForCard;
        temporaryHolderObjectForCard = listOfCardsInTheField.getFirst();
        return temporaryHolderObjectForCard;
    }

    public void displayAllTheCardsInTheField()
    {
        for(int i = 0; i < listOfCardsInTheField.size(); i++)
        {
            System.out.print(" " + listOfCardsInTheField.get(i).returnTheTypeOfTheCard());
        }
    }
}
