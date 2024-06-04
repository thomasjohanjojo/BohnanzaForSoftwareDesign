public class BlackEyedBeanClass implements LogicOfTheGame.Card {
    public String returnTheTypeOfTheCard()
    {
        return "BlackEyedBean";
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForFourCoins()
    {
        return 6;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForThreeCoins()
    {
        return 5;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForTwoCoins()
    {
        return 4;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForOneCoin()
    {
        return 2;
    }


}
