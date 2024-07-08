import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want to play the base game or the extension?:1.Base Game 2.Extension (Enter the number):");
        int choice = scanner.nextInt();
        if(choice == 1)
        {
            System.out.print("How many players are there?(3-5)");
            int choiceOfPlayers = scanner.nextInt();
            List<TheClassWhichHasThePlayerHandAndFields> theListOfPlayers = new ArrayList<>();
            if(choiceOfPlayers == 3)
            {

                for(int i = 0; i < 3; i++)
                {
                    PlayerClass player = new PlayerClass();
                    HandClass hand = new HandClass();
                    FieldClass fieldOne = new FieldClass();
                    FieldClass fieldTwo = new FieldClass();
                    FieldClass fieldThree = new FieldClass();
                    AreasToKeepTheTurnedOverAndTradedCardsClass areasToKeepTheTurnedOverAndTradedCardsClass =  new AreasToKeepTheTurnedOverAndTradedCardsClass();
                    TheClassWhichHasThePlayerHandAndFields playerObject = new TheClassWhichHasThePlayerHandAndFields(
                            player,
                            hand,
                            fieldOne,
                            fieldTwo,
                            fieldThree,
                            areasToKeepTheTurnedOverAndTradedCardsClass,
                            true);
                    theListOfPlayers.add(playerObject);

                }

            }
            else
            {
                for(int i = 0; i < choiceOfPlayers; i++)
                {
                    PlayerClass player = new PlayerClass();
                    HandClass hand = new HandClass();
                    FieldClass fieldOne = new FieldClass();
                    FieldClass fieldTwo = new FieldClass();
                    FieldClass fieldThree = new FieldClass();
                    AreasToKeepTheTurnedOverAndTradedCardsClass areasToKeepTheTurnedOverAndTradedCardsClass =  new AreasToKeepTheTurnedOverAndTradedCardsClass();
                    TheClassWhichHasThePlayerHandAndFields playerObject = new TheClassWhichHasThePlayerHandAndFields(
                            player,
                            hand,
                            fieldOne,
                            fieldTwo,
                            fieldThree,
                            areasToKeepTheTurnedOverAndTradedCardsClass,
                            false);
                    theListOfPlayers.add(playerObject);
                }
            }
            TheClassWhichHasThePlayerHandAndFields[] arrayOfPlayerObjects = theListOfPlayers.toArray(new TheClassWhichHasThePlayerHandAndFields[0]);
            DrawPileClass drawPile = new DrawPileClass();
            HandClass discardPile = new HandClass();

            // Creating the cards and adding them to the drawpile
            for(int i = 0; i < 8 ; i++)
            {
                CardClass redBeanCard = new CardClass("RedBean", 2, 3, 4, 5);
                drawPile.addACardToTheDrawPile(redBeanCard);
            }
            for(int i = 0; i < 10; i++)
            {
                CardClass blackEyedBeanCard = new CardClass("BlackEyedBean",2, 4, 5, 6);
                drawPile.addACardToTheDrawPile(blackEyedBeanCard);
            }
            for(int i = 0; i < 6; i++)
            {
                CardClass gardenBeanCard = new CardClass("GardenBean", 0, 2, 3, 0);
                drawPile.addACardToTheDrawPile(gardenBeanCard);
            }
            for(int i = 0; i < 12; i++)
            {
                CardClass soyBeanCard = new CardClass("SoyBean", 2,4, 6, 7);
                drawPile.addACardToTheDrawPile(soyBeanCard);
            }
            for(int i = 0; i < 14; i++)
            {
                CardClass greenBean = new CardClass("GreenBean", 3,5, 6, 7);
                drawPile.addACardToTheDrawPile(greenBean);
            }
            for(int i = 0; i < 16; i++)
            {
                CardClass stinkBean = new CardClass("StinkBean", 3,5, 7, 8);
                drawPile.addACardToTheDrawPile(stinkBean);
            }
            for(int i = 0; i < 18; i++)
            {
                CardClass chiliBean = new CardClass("ChiliBean", 3,6, 8, 9);
                drawPile.addACardToTheDrawPile(chiliBean);
            }
            for(int i = 0; i < 20; i++)
            {
                CardClass blueBean = new CardClass("BlueBean", 4,6, 8, 10);
                drawPile.addACardToTheDrawPile(blueBean);
            }
            drawPile.shuffleTheDrawPile();
            LogicOfTheGame logicOfTheGame = new LogicOfTheGame();
            logicOfTheGame.theFunctionWhichHasTheLogic(arrayOfPlayerObjects,
                    drawPile,
                    discardPile);


        }
        else // Code for the extension
        {

        }


    }
}
