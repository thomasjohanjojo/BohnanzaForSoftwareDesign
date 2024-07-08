import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FieldClassTest extends HandClass {

    CardClass demoCard = new CardClass("RedBean", 2, 3, 4, 5);

    FieldClass field = new FieldClass();


    @Test
    void testGetTheTypeOfCardInThisField() {
        // add the card to the field
        field.addCardsToTheField(demoCard);
        // check the type of the card in the field
        assertEquals("RedBean", field.getTheTypeOfCardInThisField());

    }

}