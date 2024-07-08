import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HandClassTest extends HandClass {

    CardClass demoCard = new CardClass("RedBean", 2, 3, 4, 5);

    List<LogicOfTheGame.Card> listsOfCardsInTheHand = new ArrayList<>();



    @Test
    void testGetTheCardAtTheFrontOfTheHand() {
        // add the card to the hand
        listsOfCardsInTheHand.add(demoCard);
        // check if the card is in the hand
        assertTrue(listsOfCardsInTheHand.contains(demoCard));

        // remove the card from the front of the hand
        listsOfCardsInTheHand.remove(0);
        // check if the card is no longer in the hand
        assertFalse(listsOfCardsInTheHand.contains(demoCard));

    }


}