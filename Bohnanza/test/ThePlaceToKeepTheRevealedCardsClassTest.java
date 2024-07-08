import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThePlaceToKeepTheRevealedCardsClassTest extends ThePlaceToKeepTheRevealedCardsClass {

    List<LogicOfTheGame.Card> listOfCardsInSlotOne = new ArrayList<>();
    List<LogicOfTheGame.Card> listOfCardsInSlotTwo = new ArrayList<>();
    List<LogicOfTheGame.Card> listOfCardsInSlotThree = new ArrayList<>();

    CardClass demoCard = new CardClass("RedBean", 2, 3, 4, 5);


    @Test
    void testAddACardToSlotOne() {
        // Test to see if the card is added to the list of cards in slot one
        addACardToSlotOne(demoCard);
        assertEquals(demoCard, listOfCardsInSlotOne.get(0));
    }

    @Test
    void testAddACardToSlotTwo() {
        // Test to see if the card is added to the list of cards in slot two
        addACardToSlotTwo(demoCard);
        assertEquals(demoCard, listOfCardsInSlotTwo.get(0));
    }

    @Test
    void testAddACardToSlotThree() {
        // Test to see if the card is added to the list of cards in slot three
        addACardToSlotThree(demoCard);
        assertEquals(demoCard, listOfCardsInSlotThree.get(0));
    }
}