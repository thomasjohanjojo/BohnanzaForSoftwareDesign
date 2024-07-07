import java.util.ArrayList;
import java.util.List;
public class ThePlaceToKeepTheRevealedCardsClass implements ThePlaceToKeepTheRevealedCards{
    List<LogicOfTheGame.Card> listOfCardsInSlotOne = new ArrayList<>();
    List<LogicOfTheGame.Card> listOfCardsInSlotTwo = new ArrayList<>();
    List<LogicOfTheGame.Card> listOfCardsInSlotThree = new ArrayList<>();

    public void addACardToSlotOne(LogicOfTheGame.Card cardToAdd)
    {
        listOfCardsInSlotOne.add(cardToAdd);
    }
    public void addACardToSlotTwo(LogicOfTheGame.Card cardToAdd)
    {
        listOfCardsInSlotTwo.add(cardToAdd);
    }
    public void addACardToSlotThree(LogicOfTheGame.Card cardToAdd)
    {
        listOfCardsInSlotThree.add(cardToAdd);
    }


    public LogicOfTheGame.Card removeAndReturnACardFromSlotOne()
    {
        if(listOfCardsInSlotOne.isEmpty() == false)
        {
            return listOfCardsInSlotOne.removeFirst();
        }
        else
        {
            return null;
        }
    }
    public LogicOfTheGame.Card removeAndReturnACardFromSlotTwo()
    {
        if(listOfCardsInSlotTwo.isEmpty() == false)
        {
            return listOfCardsInSlotTwo.removeFirst();
        }
        else
        {
            return null;
        }
    }
    public LogicOfTheGame.Card removeAndReturnACardFromSlotThree()
    {
        if(listOfCardsInSlotThree.isEmpty() == false)
        {
            return listOfCardsInSlotThree.removeFirst();
        }
        else
        {
            return null;
        }
    }

    public String returnTheCardTypeInSlotOne()
    {
        return listOfCardsInSlotOne.getFirst().returnTheTypeOfTheCard();
    }
    public String returnTheCardTypeInSlotTwo()
    {
        return listOfCardsInSlotTwo.getFirst().returnTheTypeOfTheCard();
    }
    public String returnTheCardTypeInSlotThree()
    {
        return listOfCardsInSlotThree.getFirst().returnTheTypeOfTheCard();
    }

    public int returnTheNumberOfCardsInSlotOne()
    {
        return listOfCardsInSlotOne.size();
    }
    public int returnTheNumberOfCardsInSlotTwo()
    {
        return listOfCardsInSlotTwo.size();
    }
    public int returnTheNumberOfCardsInSlotThree()
    {
        return listOfCardsInSlotThree.size();
    }
    public int returnTheTotalNumberOfCardsInAllTheSlots()
    {
        return (listOfCardsInSlotOne.size() + listOfCardsInSlotTwo.size() + listOfCardsInSlotThree.size());
    }
}
