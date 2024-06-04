public class GreenBeanClass implements LogicOfTheGame.Card {
    public String returnTheTypeOfTheCard()
    {
        return "GreenBean";
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForFourCoins()
    {
        return 7;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForThreeCoins()
    {
        return 6;
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
