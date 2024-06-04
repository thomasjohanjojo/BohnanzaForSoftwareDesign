public class RedBeanClass implements LogicOfTheGame.Card {
    public String returnTheTypeOfTheCard()
    {
        return "RedBean";
    }


    public int getTheNumberOfCardsOfThisTypeRequiredForFourCoins() {
        return 5;
    }


    public int getTheNumberOfCardsOfThisTypeRequiredForThreeCoins() {
        return 4;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForTwoCoins()
    {
        return 3;
    }

    public int getTheNumberOfCardsOfThisTypeRequiredForOneCoin()
    {
        return 2;
    }
}
