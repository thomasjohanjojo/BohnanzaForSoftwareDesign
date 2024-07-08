import static org.junit.jupiter.api.Assertions.*;

class CardClassTest extends CardClass {

    public CardClassTest(String typeOfCard, int numberOfCardsOfThisTypeRequiredForOneCoin, int numberOfCardsOfThisTypeRequiredForTwoCoins, int numberOfCardsOfThisTypeRequiredForThreeCoins, int numberOfCardsOfThisTypeRequiredForFourCoins) {
        super(typeOfCard, numberOfCardsOfThisTypeRequiredForOneCoin, numberOfCardsOfThisTypeRequiredForTwoCoins, numberOfCardsOfThisTypeRequiredForThreeCoins, numberOfCardsOfThisTypeRequiredForFourCoins);
    }

    @org.junit.jupiter.api.Test
    void testReturnTheTypeOfTheCard() {
        CardClass card = new CardClass("Red Bean", 1, 2, 3, 4);
        assertEquals("Red Bean", card.returnTheTypeOfTheCard());
    }

    @org.junit.jupiter.api.Test
    void testGetTheNumberOfCardsOfThisTypeRequiredForOneCoin() {
        CardClass card = new CardClass("Red Bean", 1, 2, 3, 4);
        assertEquals(1, card.getTheNumberOfCardsOfThisTypeRequiredForOneCoin());
    }

    @org.junit.jupiter.api.Test
    void testGetTheNumberOfCardsOfThisTypeRequiredForTwoCoins() {
        CardClass card = new CardClass("Red Bean", 1, 2, 3, 4);
        assertEquals(2, card.getTheNumberOfCardsOfThisTypeRequiredForTwoCoins());
    }

    @org.junit.jupiter.api.Test
    void testGetTheNumberOfCardsOfThisTypeRequiredForThreeCoins() {
        CardClass card = new CardClass("Red Bean", 1, 2, 3, 4);
        assertEquals(3, card.getTheNumberOfCardsOfThisTypeRequiredForThreeCoins());
    }

    @org.junit.jupiter.api.Test
    void testGetTheNumberOfCardsOfThisTypeRequiredForFourCoins() {
        CardClass card = new CardClass("Red Bean", 1, 2, 3, 4);
        assertEquals(4, card.getTheNumberOfCardsOfThisTypeRequiredForFourCoins());
    }
}