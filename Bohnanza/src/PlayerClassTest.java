import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

public class PlayerClassTest {

    PlayerClass playerObject = new PlayerClass();
    HandClass discardPile = new HandClass();
    FieldClass fieldObject = new FieldClass();
    CardClass card = new CardClass("RedBean", 1, 2, 3, 4);

    @Test
    public void PlantFunctionTest()
    {
        playerObject.plant(card, fieldObject, discardPile);
        assertEquals("RedBean", fieldObject.removeACardFromTheTopOfTheField().returnTheTypeOfTheCard());
    }
}
