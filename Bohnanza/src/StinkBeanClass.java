public class StinkBeanClass implements LogicOfTheGame.Card {
    public String returnTheTypeOfTheCard()
    {
        return "StinkBean";
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForFourCoins()
    {
        return 8;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForThreeCoins()
    {
        return 7;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForTwoCoins()
    {
        return 5;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForOneCoin()
    {
        return 3;
    }
}
