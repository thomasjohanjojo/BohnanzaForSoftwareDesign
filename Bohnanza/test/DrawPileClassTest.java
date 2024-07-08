import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawPileClassTest extends DrawPileClass {

    // Create a new DrawPileClass object
    DrawPileClass drawPile = new DrawPileClass();

    // Create a new Card object
    CardClass demoCard = new CardClass("RedBean", 2, 3, 4, 5);


    @Test
    void testGetOneCardFromTheDrawPile() {
        // Add the card to the draw pile
        drawPile.addACardToTheDrawPile(demoCard);

        // Check if the card is the same as the card that was added to the draw pile
        assertEquals(demoCard, drawPile.getOneCardFromTheDrawPile());
    }


    @Test
    void testIsDrawPileEmpty() {
       // empty the draw pile
        drawPile.cardsOfTheDrawPile.clear();

        // Check if the draw pile is empty
        assertTrue(drawPile.isDrawPileEmpty());

    }


}