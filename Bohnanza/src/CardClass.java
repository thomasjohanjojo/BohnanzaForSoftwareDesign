

public class CardClass implements LogicOfTheGame.Card{
    String typeOfCard;
    int numberOfCardsOfThisTypeRequiredForOneCoin;
    int numberOfCardsOfThisTypeRequiredForTwoCoins;
    int numberOfCardsOfThisTypeRequiredForThreeCoins;
    int numberOfCardsOfThisTypeRequiredForFourCoins;

    public CardClass(String typeOfCard,
                     int numberOfCardsOfThisTypeRequiredForOneCoin,
                     int numberOfCardsOfThisTypeRequiredForTwoCoins,
                     int numberOfCardsOfThisTypeRequiredForThreeCoins,
                     int numberOfCardsOfThisTypeRequiredForFourCoins)
    {
        this.typeOfCard = typeOfCard;
        this.numberOfCardsOfThisTypeRequiredForOneCoin = numberOfCardsOfThisTypeRequiredForOneCoin;
        this.numberOfCardsOfThisTypeRequiredForTwoCoins = numberOfCardsOfThisTypeRequiredForTwoCoins;
        this.numberOfCardsOfThisTypeRequiredForThreeCoins = numberOfCardsOfThisTypeRequiredForThreeCoins;
        this.numberOfCardsOfThisTypeRequiredForFourCoins = numberOfCardsOfThisTypeRequiredForFourCoins;
    }
    public String returnTheTypeOfTheCard()
    {
        return typeOfCard;
    }
    public int getTheNumberOfCardsOfThisTypeRequiredForOneCoin()
    {
        return numberOfCardsOfThisTypeRequiredForOneCoin;
    }
    public int getTheNumberOfCardsOfThisTypeRequiredForTwoCoins()
    {
        return numberOfCardsOfThisTypeRequiredForTwoCoins;
    }
    public int getTheNumberOfCardsOfThisTypeRequiredForThreeCoins()
    {
        return numberOfCardsOfThisTypeRequiredForThreeCoins;
    }
    public int getTheNumberOfCardsOfThisTypeRequiredForFourCoins()
    {
        return numberOfCardsOfThisTypeRequiredForFourCoins;
    }
}
