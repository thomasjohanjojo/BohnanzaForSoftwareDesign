public class ChiliBeanClass implements LogicOfTheGame.Card {
    public String returnTheTypeOfTheCard()
    {
        return "ChiliBean";
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForFourCoins()
    {
        return 9;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForThreeCoins()
    {
        return 8;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForTwoCoins()
    {
        return 6;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForOneCoin()
    {
        return 3;
    }
}
