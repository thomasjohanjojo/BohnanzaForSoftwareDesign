public class BlueBeanClass implements LogicOfTheGame.Card {
    public String returnTheTypeOfTheCard()
    {
        return "BlueBean";
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForFourCoins()
    {
        return 10;
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
        return 4;
    }
}
