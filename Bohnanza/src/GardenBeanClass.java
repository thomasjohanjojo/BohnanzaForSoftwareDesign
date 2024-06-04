public class GardenBeanClass implements LogicOfTheGame.Card {
    public String returnTheTypeOfTheCard()
    {
        return "GardenBean";
    }


    public int getTheNumberOfCardsOfThisTypeRequiredForOneCoin()
    {
        return -1;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForTwoCoins()
    {
        return 2;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForThreeCoins()
    {
        return 3;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForFourCoins()
    {
        return -1;
    }

}
