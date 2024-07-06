import java.util.Objects;
import java.util.Scanner;

public class AlCabohneExtension extends LogicOfTheGame  {
    public void logicOfTheAlCabohneExtension()
    {

    }

    private void phaseFour(
            TheClassWhichHasThePlayerHandAndFields alCabohne,
            TheClassWhichHasThePlayerHandAndFields donCorlebohne,
            TheClassWhichHasThePlayerHandAndFields joeBohnano,
            TheClassWhichHasThePlayerHandAndFields activePlayer,
            ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards,
            DrawPile drawPile,
            Hand discardPile,
            Boolean isThisASinglePlayerGame)
    {
        activePlayerRevealsThreeCards(alCabohne, donCorlebohne, joeBohnano, activePlayer, thePlaceToKeepTheRevealedCards, drawPile, discardPile, isThisASinglePlayerGame);
    }

    private void activePlayerRevealsThreeCards(
            TheClassWhichHasThePlayerHandAndFields alCabohne,
            TheClassWhichHasThePlayerHandAndFields donCorlebohne,
            TheClassWhichHasThePlayerHandAndFields joeBohnano,
            TheClassWhichHasThePlayerHandAndFields activePlayer,
            ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards,
            DrawPile drawPile,
            Hand discardPile,
            Boolean isThisASinglePlayerGame
    )
    {
        //The phase 4 for the first revealed card
        thePlaceToKeepTheRevealedCards.addACardToSlotOne(drawPile.getOneCardFromTheDrawPile());
        while(Objects.equals(alCabohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotOne()))
        {
            Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
            alCabohne.player.plant(cardToTransferToTheBoss, alCabohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotOne(drawPile.getOneCardFromTheDrawPile());
        }
        while(Objects.equals(donCorlebohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotOne()))
        {
            Card cardToTranferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
            donCorlebohne.player.plant(cardToTranferToTheBoss, donCorlebohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotOne(drawPile.getOneCardFromTheDrawPile());
        }
        if(isThisASinglePlayerGame == true)
        {
            while(Objects.equals(joeBohnano.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotOne()))
            {
                Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
                joeBohnano.player.plant(cardToTransferToTheBoss, joeBohnano.fieldOne, discardPile);
                thePlaceToKeepTheRevealedCards.addACardToSlotOne(drawPile.getOneCardFromTheDrawPile());
            }
        }

        while(Objects.equals(thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotOne(), discardPile.getTheTypeOfCardInFrontOfTheHand()))
        {
            Card cardToAddToTheSlot = discardPile.getTheCardAtTheFrontOfTheHand();
            thePlaceToKeepTheRevealedCards.addACardToSlotOne(cardToAddToTheSlot);
        }

        //The phase 4 for the second revealed card
        thePlaceToKeepTheRevealedCards.addACardToSlotTwo(drawPile.getOneCardFromTheDrawPile());
        while(Objects.equals(alCabohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotTwo()))
        {
            Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotTwo();
            alCabohne.player.plant(cardToTransferToTheBoss, alCabohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotTwo(drawPile.getOneCardFromTheDrawPile());
        }
        while(Objects.equals(donCorlebohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotTwo()))
        {
            Card cardToTranferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotTwo();
            donCorlebohne.player.plant(cardToTranferToTheBoss, donCorlebohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotTwo(drawPile.getOneCardFromTheDrawPile());
        }
        if(isThisASinglePlayerGame == true)
        {
            while(Objects.equals(joeBohnano.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotTwo()))
            {
                Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotTwo();
                joeBohnano.player.plant(cardToTransferToTheBoss, joeBohnano.fieldOne, discardPile);
                thePlaceToKeepTheRevealedCards.addACardToSlotTwo(drawPile.getOneCardFromTheDrawPile());
            }
        }

        //The Phase 4 for the third revealed card
        thePlaceToKeepTheRevealedCards.addACardToSlotThree(drawPile.getOneCardFromTheDrawPile());
        while(Objects.equals(alCabohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotThree()))
        {
            Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotThree();
            alCabohne.player.plant(cardToTransferToTheBoss, alCabohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotThree(drawPile.getOneCardFromTheDrawPile());
        }
        while(Objects.equals(donCorlebohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotThree()))
        {
            Card cardToTranferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotThree();
            donCorlebohne.player.plant(cardToTranferToTheBoss, donCorlebohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotThree(drawPile.getOneCardFromTheDrawPile());
        }
        if(isThisASinglePlayerGame == true)
        {
            while(Objects.equals(joeBohnano.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotThree()))
            {
                Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotThree();
                joeBohnano.player.plant(cardToTransferToTheBoss, joeBohnano.fieldOne, discardPile);
                thePlaceToKeepTheRevealedCards.addACardToSlotThree(drawPile.getOneCardFromTheDrawPile());
            }
        }


    }

    private void phaseFiveCultivateTheBeans(
            TheClassWhichHasThePlayerHandAndFields alCabohne,
            TheClassWhichHasThePlayerHandAndFields donCorlebohne,
            TheClassWhichHasThePlayerHandAndFields joeBohnano,
            TheClassWhichHasThePlayerHandAndFields activePlayer,
            ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards,
            DrawPile drawPile,
            Hand discardPile,
            Boolean isThisASinglePlayerGame
    )
    {
        plantingBeansFromTheRevealedBeans(alCabohne, donCorlebohne, joeBohnano, activePlayer, thePlaceToKeepTheRevealedCards, drawPile, discardPile, isThisASinglePlayerGame);
        plantingBeansFromTheHand(alCabohne, donCorlebohne, joeBohnano, activePlayer, thePlaceToKeepTheRevealedCards, drawPile, discardPile, isThisASinglePlayerGame);
        playerCanHarvestAndSellBeans(alCabohne, donCorlebohne, joeBohnano, activePlayer, thePlaceToKeepTheRevealedCards, drawPile, discardPile, isThisASinglePlayerGame);
        playerMustGiveBeanMafiaACardIfTheyHaveNone(alCabohne, donCorlebohne, joeBohnano, activePlayer, thePlaceToKeepTheRevealedCards,drawPile, discardPile, isThisASinglePlayerGame);



    }

    private void plantingBeansFromTheRevealedBeans(
            TheClassWhichHasThePlayerHandAndFields alCabohne,
            TheClassWhichHasThePlayerHandAndFields donCorlebohne,
            TheClassWhichHasThePlayerHandAndFields joeBohnano,
            TheClassWhichHasThePlayerHandAndFields activePlayer,
            ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards,
            DrawPile drawPile,
            Hand discardPile,
            Boolean isThisASinglePlayerGame
    )
    {
        Scanner scanner = new Scanner(System.in);
        if(isThisASinglePlayerGame == false)
        {
            System.out.print("\n How many cards do you want to plant from the revealed cards?:");
            int numberOfCardsToPlant = scanner.nextInt();
            for(int i = 0; i < numberOfCardsToPlant; i++)
            {
                int slotToTakeTheCardFrom;
                System.out.print("\n From which slot do you want to take the card?:");
                slotToTakeTheCardFrom = scanner.nextInt();
                Card cardToPlant = removeACardFromARevealedCardSlotAndReturnIt(slotToTakeTheCardFrom, thePlaceToKeepTheRevealedCards);
                System.out.print("\n Where do you want to plant the card? 1.Your Fields  2.Bosses' Fields:");
                int choiceOnWhereToPlant = scanner.nextInt();
                if(choiceOnWhereToPlant == 1)
                {
                    plantTheCardOnYourOwnField(activePlayer, cardToPlant, discardPile, isThisASinglePlayerGame);
                }
                else if(choiceOnWhereToPlant == 2)
                {
                    plantTheCardOnOneOfTheBossesFields(alCabohne, donCorlebohne, joeBohnano, cardToPlant, discardPile, isThisASinglePlayerGame);
                }

            }
        }
        if(isThisASinglePlayerGame == true)
        {
            while(thePlaceToKeepTheRevealedCards.returnTheTotalNumberOfCardsInAllTheSlots() != 0)
            {
                int slotToTakeTheCardFrom;
                System.out.print("\n From which slot do you want to take the card?:");
                slotToTakeTheCardFrom = scanner.nextInt();
                Card cardToPlant = removeACardFromARevealedCardSlotAndReturnIt(slotToTakeTheCardFrom, thePlaceToKeepTheRevealedCards);
                System.out.print("\n Where do you want to plant the card? 1.Your Fields  2.Bosses' Fields:");
                int choiceOnWhereToPlant = scanner.nextInt();
                if(choiceOnWhereToPlant == 1)
                {
                    plantTheCardOnYourOwnField(activePlayer, cardToPlant, discardPile, isThisASinglePlayerGame);
                }
                else if(choiceOnWhereToPlant == 2)
                {
                    plantTheCardOnOneOfTheBossesFields(alCabohne, donCorlebohne, joeBohnano, cardToPlant, discardPile, isThisASinglePlayerGame);
                }

            }
        }
    }

    private void plantTheCardOnYourOwnField(TheClassWhichHasThePlayerHandAndFields activePlayer, Card cardToPlant, Hand discardPile, Boolean isThisASinglePlayerGame)
    {


            if (activePlayer.isTheThirdFieldAvailable == false)
            {
                if (checkWhetherACardCanBePlantedOnOneFieldInCaseOfTwoTotalFields(activePlayer.fieldOne, activePlayer.fieldTwo, cardToPlant.returnTheTypeOfTheCard()) == false)
                {
                    System.out.print("\n Card cannot be planted due to matching field types, do again");
                }
                plantTheCard(activePlayer, discardPile, cardToPlant);
            }
            else
            {
                if(checkWhetherACardCanBePlantedOnOneFieldInCaseOfThreeFields(activePlayer.fieldOne, activePlayer.fieldTwo, activePlayer.fieldThree, cardToPlant.returnTheTypeOfTheCard()) == false)
                {
                    System.out.print("\n Card cannot be planted due to matching field types, do again");
                }
                plantTheCard(activePlayer, discardPile, cardToPlant);
            }



    }

    private void plantTheCardOnOneOfTheBossesFields(
            TheClassWhichHasThePlayerHandAndFields alCabohne,
            TheClassWhichHasThePlayerHandAndFields donCorlebohne,
            TheClassWhichHasThePlayerHandAndFields joeBohnano,
            Card cardToPlant,
            Hand discardPile,
            Boolean isThisASinglePlayerGame
    )
    {
        Scanner scanner = new Scanner(System.in);
        if(isThisASinglePlayerGame == false)
        {
            System.out.print("\n On which boss's field do you want to plant? 1.Al Cabohne 2.Don Corlebohne:");
            int choiceOfBossToPlantOn = scanner.nextInt();
            if(choiceOfBossToPlantOn < 1 || choiceOfBossToPlantOn > 2)
            {
                System.out.print("\n Wrong input, do again");
                return;
            }
            if(choiceOfBossToPlantOn == 1)
            {
                if(checkWhetherACardCanBePlantedInTheFieldInTermsOfType(cardToPlant.returnTheTypeOfTheCard(), alCabohne.fieldOne) == false)
                {
                    System.out.print("\n Card cannot be planted because of card type, do again");
                    return;
                }
                if(checkWhetherACardCanBePlantedOnOneFieldInCaseOfTwoTotalFields(alCabohne.fieldOne, donCorlebohne.fieldOne, cardToPlant.returnTheTypeOfTheCard()))
                {
                    alCabohne.player.plant(cardToPlant, alCabohne.fieldOne, discardPile);
                }
                else
                {
                    System.out.print("\n Wrong field to plant the card, do again");
                    return;
                }
            }
            else if(choiceOfBossToPlantOn == 2)
            {
                if(checkWhetherACardCanBePlantedInTheFieldInTermsOfType(cardToPlant.returnTheTypeOfTheCard(), donCorlebohne.fieldOne) == false)
                {
                    System.out.print("\n Card cannot be planted because of card type");
                    return;
                }
               if(checkWhetherACardCanBePlantedOnOneFieldInCaseOfTwoTotalFields(donCorlebohne.fieldOne, alCabohne.fieldOne, cardToPlant.returnTheTypeOfTheCard()))
               {
                   donCorlebohne.player.plant(cardToPlant, alCabohne.fieldOne, discardPile);
               }
               else
               {
                   System.out.print("\n Wrong field to plant the card, do again");
                   return;
               }

            }
        }

        else if(isThisASinglePlayerGame == true)
        {
            System.out.print("\n On which boss's field do you want to plant? 1.Al Cabohne 2.Don Corlebohne 3.Joe Bohnano:");
            int choiceOfBoss = scanner.nextInt();
            if( choiceOfBoss < 1 || choiceOfBoss > 3)
            {
                System.out.print("\n Wrong input, do again");
                return;
            }
            if(choiceOfBoss == 1)
            {
                if(checkWhetherACardCanBePlantedInTheFieldInTermsOfType(cardToPlant.returnTheTypeOfTheCard(), alCabohne.fieldOne) == false)
                {
                    System.out.print("Card cannot be planted because of card type, do again");
                }
                if(checkWhetherACardCanBePlantedOnOneFieldInCaseOfThreeFields(alCabohne.fieldOne, donCorlebohne.fieldOne, joeBohnano.fieldOne, cardToPlant.returnTheTypeOfTheCard()))
                {
                    alCabohne.player.plant(cardToPlant, alCabohne.fieldOne, discardPile);
                }
            }

            else if(choiceOfBoss == 2)
            {
                if(checkWhetherACardCanBePlantedInTheFieldInTermsOfType(cardToPlant.returnTheTypeOfTheCard(), donCorlebohne.fieldOne) == false)
                {
                    System.out.print("\n Card cannot be planted because of card type");
                    return;
                }
                if(checkWhetherACardCanBePlantedOnOneFieldInCaseOfThreeFields(donCorlebohne.fieldOne, alCabohne.fieldOne, joeBohnano.fieldOne, cardToPlant.returnTheTypeOfTheCard()))
                {
                    donCorlebohne.player.plant(cardToPlant, donCorlebohne.fieldOne, discardPile);
                }
            }

            else if(choiceOfBoss == 3)
            {
                if(checkWhetherACardCanBePlantedInTheFieldInTermsOfType(cardToPlant.returnTheTypeOfTheCard(), joeBohnano.fieldOne) == false)
                {
                    System.out.print("\n Card cannot be planted because of type, do again");
                    return;
                }
                if(checkWhetherACardCanBePlantedOnOneFieldInCaseOfThreeFields(joeBohnano.fieldOne, alCabohne.fieldOne, donCorlebohne.fieldOne, cardToPlant.returnTheTypeOfTheCard()))
                {
                    joeBohnano.player.plant(cardToPlant, joeBohnano.fieldOne, discardPile);
                }
            }


        }
    }

    private boolean checkWhetherACardCanBePlantedOnOneFieldInCaseOfTwoTotalFields(Field fieldToPlantOn, Field fieldToCheckWith, String cardType)
    {
        if(fieldToPlantOn.getTheNumberOfCardsInThisField() ==0 && fieldToCheckWith.getTheNumberOfCardsInThisField() !=0)
        {
            if (Objects.equals(cardType, fieldToCheckWith.getTheTypeOfCardInThisField()))
            {
                return false;
            }
            else {
                return true;
            }
        }
        else
        {
            return true;
        }
    }

    private boolean checkWhetherACardCanBePlantedOnOneFieldInCaseOfThreeFields(Field fieldToPlantOn, Field firstFieldToCheckWith, Field otherFieldToCheckWith, String typeOfCardToPlant)
    {
        if(fieldToPlantOn.getTheNumberOfCardsInThisField() == 0 && firstFieldToCheckWith.getTheNumberOfCardsInThisField() !=0 && otherFieldToCheckWith.getTheNumberOfCardsInThisField() != 0)
        {
            if(Objects.equals(typeOfCardToPlant, firstFieldToCheckWith.getTheTypeOfCardInThisField()) || Objects.equals(typeOfCardToPlant, otherFieldToCheckWith.getTheTypeOfCardInThisField()))
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        else if(fieldToPlantOn.getTheNumberOfCardsInThisField() == 0 && firstFieldToCheckWith.getTheNumberOfCardsInThisField() ==0 && otherFieldToCheckWith.getTheNumberOfCardsInThisField() != 0)
        {
            if(Objects.equals(typeOfCardToPlant, otherFieldToCheckWith.getTheTypeOfCardInThisField()))
            {
                return false;
            }

            else
            {
                return true;
            }
        }

        else if(fieldToPlantOn.getTheNumberOfCardsInThisField() == 0 && firstFieldToCheckWith.getTheNumberOfCardsInThisField() != 0 && otherFieldToCheckWith.getTheNumberOfCardsInThisField() == 0)
        {
            if(Objects.equals(typeOfCardToPlant, firstFieldToCheckWith.getTheTypeOfCardInThisField()))
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        else if(fieldToPlantOn.getTheNumberOfCardsInThisField() == 0 && firstFieldToCheckWith.getTheNumberOfCardsInThisField() == 0 && otherFieldToCheckWith.getTheNumberOfCardsInThisField() == 0)
        {
            return true;
        }

        else
        {
            return true;
        }
    }

    private boolean checkWhetherACardCanBePlantedInTheFieldInTermsOfType(String typeOfCardToCheck, Field fieldToCheckIn)
    {
        if(fieldToCheckIn.getTheNumberOfCardsInThisField() != 0)
        {
            if (Objects.equals(typeOfCardToCheck, fieldToCheckIn.getTheTypeOfCardInThisField())) {
                return true;
            } else {
                return false;
            }
        }
        else
        {
            return true;
        }
    }




    private Card removeACardFromARevealedCardSlotAndReturnIt(int slotNumber, ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards)
    {
        Card cardToReturn;
        if(slotNumber == 1)
        {
            cardToReturn = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
        }

        else if(slotNumber == 2)
        {
            cardToReturn = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotTwo();
        }

        else if(slotNumber == 3)
        {
            cardToReturn = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotThree();
        }

        else
        {
            System.out.print("\n Wrong slot, returning a card from slot one");
            cardToReturn = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
        }

        return cardToReturn;
    }



    private void plantingBeansFromTheHand(
            TheClassWhichHasThePlayerHandAndFields alCabohne,
            TheClassWhichHasThePlayerHandAndFields donCorlebohne,
            TheClassWhichHasThePlayerHandAndFields joeBohnano,
            TheClassWhichHasThePlayerHandAndFields activePlayer,
            ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards,
            DrawPile drawPile,
            Hand discardPile,
            Boolean isThisASinglePlayerGame
    )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to give the mafia cards from your hand? 1.Yes 2.No (enter the number):");
        int choice = scanner.nextInt();
        if(choice < 1 || choice > 2)
        {
            System.out.print("\n Wrong choice, do again");
            return;
        }
        if(choice == 1)
        {
            Card cardToPlant = activePlayer.hand.getTheCardAtTheFrontOfTheHand();
            plantTheCardOnOneOfTheBossesFields(alCabohne, donCorlebohne, joeBohnano, cardToPlant, discardPile, isThisASinglePlayerGame);
        }
        else
        {
            return;
        }
    }

    private void playerCanHarvestAndSellBeans(
            TheClassWhichHasThePlayerHandAndFields alCabohne,
            TheClassWhichHasThePlayerHandAndFields donCorlebohne,
            TheClassWhichHasThePlayerHandAndFields joeBohnano,
            TheClassWhichHasThePlayerHandAndFields activePlayer,
            ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards,
            DrawPile drawPile,
            Hand discardPile,
            Boolean isThisASinglePlayerGame
    )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Do you want to harvest beans? 1. Yes 2.No");
        int choice = scanner.nextInt();
        if(choice < 1 || choice > 2)
        {
            System.out.print("\n Wrong choice, do again");
            return;
        }
        if(choice == 1)
        {
            if(isThisASinglePlayerGame == true)
            {
                if(activePlayer.isTheThirdFieldAvailable == false)
                {
                    System.out.print("\n Which field do you want to harvest?: 1.Field one 2.Field two:");
                    int choiceOfField = scanner.nextInt();

                    if (choiceOfField < 1 || choiceOfField > 2)
                    {
                        System.out.print("\n Wrong choice, do again");
                        return;
                    }
                    if(choiceOfField == 1)
                    {
                        activePlayer.player.harvest(activePlayer.fieldOne, discardPile);
                    }
                    else if(choiceOfField == 2)
                    {
                        activePlayer.player.harvest(activePlayer.fieldTwo, discardPile);
                    }
                }
                if(activePlayer.isTheThirdFieldAvailable == true)
                {
                    System.out.print("\n Which field do you want to harvest? 1.Field One 2.Field Two 3.Field Three:");
                    int choiceOfField = scanner.nextInt();
                    if(choiceOfField < 1 || choiceOfField > 3)
                    {
                        System.out.print("\n Wrong choice of field, do again");
                        return;
                    }
                    if(choiceOfField == 1)
                    {
                        activePlayer.player.harvest(activePlayer.fieldOne, discardPile);
                    }
                    else if(choiceOfField == 2)
                    {
                        activePlayer.player.harvest(activePlayer.fieldTwo, discardPile);
                    }
                    else if(choiceOfField == 3)
                    {
                        activePlayer.player.harvest(activePlayer.fieldThree, discardPile);
                    }

                }
            }
        }
        if(choice == 2)
        {
            return;
        }
    }

    private void playerMustGiveBeanMafiaACardIfTheyHaveNone(
            TheClassWhichHasThePlayerHandAndFields alCabohne,
            TheClassWhichHasThePlayerHandAndFields donCorlebohne,
            TheClassWhichHasThePlayerHandAndFields joeBohnano,
            TheClassWhichHasThePlayerHandAndFields activePlayer,
            ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards,
            DrawPile drawPile,
            Hand discardPile,
            Boolean isThisASinglePlayerGame
    )
    {
        if(isThisASinglePlayerGame == false)
        {
            if(alCabohne.fieldOne.getTheNumberOfCardsInThisField() == 0)
            {
                if(activePlayer.hand.isTheHandEmpty() == false)
                {
                    String typeOfCardInTheFrontOfthehand = activePlayer.hand.getTheTypeOfCardInFrontOfTheHand();
                    if(checkWhetherACardCanBePlantedOnOneFieldInCaseOfTwoTotalFields(alCabohne.fieldOne, donCorlebohne.fieldOne,typeOfCardInTheFrontOfthehand ) == true)
                    {
                        Card cardToPlant = activePlayer.hand.getTheCardAtTheFrontOfTheHand();
                        alCabohne.player.plant(cardToPlant, alCabohne.fieldOne, discardPile);
                    }
                }
            }

            if(donCorlebohne.fieldOne.getTheNumberOfCardsInThisField() == 0)
            {
                if(activePlayer.hand.isTheHandEmpty() == false)
                {
                    String typeOfCardInTheFrontOfthehand = activePlayer.hand.getTheTypeOfCardInFrontOfTheHand();
                    if(checkWhetherACardCanBePlantedOnOneFieldInCaseOfTwoTotalFields(donCorlebohne.fieldOne, alCabohne.fieldOne, typeOfCardInTheFrontOfthehand ) == true)
                    {
                        Card cardToPlant = activePlayer.hand.getTheCardAtTheFrontOfTheHand();
                        donCorlebohne.player.plant(cardToPlant, donCorlebohne.fieldOne, discardPile);
                    }
                }
            }
        }

        else if(isThisASinglePlayerGame == true)
        {
            if(alCabohne.fieldOne.getTheNumberOfCardsInThisField() == 0)
            {
                if(activePlayer.hand.isTheHandEmpty() == false)
                {
                    String typeOfCardInTheFrontOfthehand = activePlayer.hand.getTheTypeOfCardInFrontOfTheHand();
                    if(checkWhetherACardCanBePlantedOnOneFieldInCaseOfThreeFields(alCabohne.fieldOne, donCorlebohne.fieldOne, joeBohnano.fieldOne,typeOfCardInTheFrontOfthehand ) == true)
                    {
                        Card cardToPlant = activePlayer.hand.getTheCardAtTheFrontOfTheHand();
                        alCabohne.player.plant(cardToPlant, alCabohne.fieldOne, discardPile);
                    }
                }
            }

            if(donCorlebohne.fieldOne.getTheNumberOfCardsInThisField() == 0)
            {
                if (activePlayer.hand.isTheHandEmpty() == false)
                {
                    String typeOfCardInTheFrontOfthehand = activePlayer.hand.getTheTypeOfCardInFrontOfTheHand();
                    if (checkWhetherACardCanBePlantedOnOneFieldInCaseOfThreeFields(donCorlebohne.fieldOne, alCabohne.fieldOne, joeBohnano.fieldOne,typeOfCardInTheFrontOfthehand ) == true)
                    {
                        Card cardToPlant = activePlayer.hand.getTheCardAtTheFrontOfTheHand();
                        donCorlebohne.player.plant(cardToPlant, donCorlebohne.fieldOne, discardPile);
                    }
                }
            }

            if(joeBohnano.fieldOne.getTheNumberOfCardsInThisField() == 0)
            {
                if(activePlayer.hand.isTheHandEmpty() == false)
                {
                    String typeOfCardInTheFrontOfthehand = activePlayer.hand.getTheTypeOfCardInFrontOfTheHand();
                    if (checkWhetherACardCanBePlantedOnOneFieldInCaseOfThreeFields(joeBohnano.fieldOne, alCabohne.fieldOne, donCorlebohne.fieldOne, typeOfCardInTheFrontOfthehand) == true)
                    {
                        Card cardToPlant = activePlayer.hand.getTheCardAtTheFrontOfTheHand();
                        joeBohnano.player.plant(cardToPlant, joeBohnano.fieldOne, discardPile);
                    }
                }
            }
        }
    }






}
