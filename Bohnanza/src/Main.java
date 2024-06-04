import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Main {
    public static void main(String[] args)
    {
        List<TheClassWhichHasThePlayerHandAndFields> listOfPlayerObjects = new ArrayList<>();

        for(int i = 0; i < 4; i++)
        {
            PlayerClass playerClassObject = new PlayerClass();
            HandClass handClassObject = new HandClass();
            FieldClass fieldClassObjectOne = new FieldClass();
            FieldClass fieldClassObjectTwo = new FieldClass();
            HandClass theAreaTokeepTheTurnedOverCards = new HandClass();

            TheClassWhichHasThePlayerHandAndFields playerObject = new TheClassWhichHasThePlayerHandAndFields(playerClassObject, handClassObject, fieldClassObjectOne, fieldClassObjectTwo, theAreaTokeepTheTurnedOverCards);
            listOfPlayerObjects.add(playerObject);
        }
        TheClassWhichHasThePlayerHandAndFields[] arrayOfPlayers = listOfPlayerObjects.toArray(new TheClassWhichHasThePlayerHandAndFields[0]);
        DrawPileClass drawPileClassObject = new DrawPileClass();
        HandClass discardPile = new HandClass();



        for(int i = 0; i < 8; i++)
        {
            RedBeanClass redBean = new RedBeanClass();
            drawPileClassObject.addACardToTheDrawPile(redBean);
        }

        for(int i = 0; i < 10; i++)
        {
            BlackEyedBeanClass blackEyedBean = new BlackEyedBeanClass();
            drawPileClassObject.addACardToTheDrawPile(blackEyedBean);
        }

        for(int i = 0; i < 12; i++)
        {
            SoyBeanClass soyBean = new SoyBeanClass();
            drawPileClassObject.addACardToTheDrawPile(soyBean);
        }

        for(int i = 0; i < 14; i++)
        {
            GreenBeanClass greenBean = new GreenBeanClass();
            drawPileClassObject.addACardToTheDrawPile(greenBean);
        }

        for(int i = 0; i < 16; i++)
        {
            StinkBeanClass stinkBean = new StinkBeanClass();
            drawPileClassObject.addACardToTheDrawPile(stinkBean);
        }

        for(int i = 0; i < 18; i++)
        {
            ChiliBeanClass chiliBean = new ChiliBeanClass();
            drawPileClassObject.addACardToTheDrawPile(chiliBean);
        }

        for(int i = 0; i < 20; i++)
        {
            BlueBeanClass blueBean = new BlueBeanClass();
            drawPileClassObject.addACardToTheDrawPile(blueBean);
        }

        for(int i = 0; i < 6; i++)
        {
            GardenBeanClass gardenBean = new GardenBeanClass();
            drawPileClassObject.addACardToTheDrawPile(gardenBean);
        }

        LogicOfTheGame logicOfTheGameObject = new LogicOfTheGame();
        logicOfTheGameObject.theFunctionWhichHasTheLogic(arrayOfPlayers, drawPileClassObject, discardPile);

    }
}
