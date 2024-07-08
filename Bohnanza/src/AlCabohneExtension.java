import java.util.Objects;
import java.util.Scanner;

public class AlCabohneExtension extends LogicOfTheGame  {
    public void logicOfTheAlCabohneExtension(
            TheClassWhichHasThePlayerHandAndFields alCabohne,
            TheClassWhichHasThePlayerHandAndFields donCorlebohne,
            TheClassWhichHasThePlayerHandAndFields joeBohnano,
            TheClassWhichHasThePlayerHandAndFields[] arrayOfPlayers,
            ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards,
            DrawPile drawPile,
            Hand discardPile,
            Boolean isThisASinglePlayerGame
    )
    {
        boolean isThisTheStartOfTheGame = true;
        DistributeInitialCardsToThePlayers(arrayOfPlayers, drawPile, isThisASinglePlayerGame);
        DealTheCardsToTheMafia(alCabohne, donCorlebohne, joeBohnano, drawPile, isThisASinglePlayerGame);
        for(int i = 0; i<3;)
        {
            if(isThisASinglePlayerGame == false)
            {
                for(int activePlayerNumber = 0; i < arrayOfPlayers.length; activePlayerNumber++)
                {
                    System.out.print("\n Start of turn for player:" + (i+1));
                    if (isThisTheStartOfTheGame == false)
                    {
                        System.out.print("\n Phase One: Use the left over cards:\n");
                        PhaseOneUseTheLeftOverCards(alCabohne, donCorlebohne, joeBohnano, arrayOfPlayers[activePlayerNumber], thePlaceToKeepTheRevealedCards, drawPile, discardPile, isThisASinglePlayerGame);
                        System.out.print("\n Phase Two: Give beans to the bean mafia:\n");
                        PhaseTwoGiveBeansToTheBeansMafia(alCabohne, donCorlebohne, joeBohnano, arrayOfPlayers[activePlayerNumber], thePlaceToKeepTheRevealedCards, drawPile, discardPile, isThisASinglePlayerGame);
                        isThisTheStartOfTheGame = false;
                    }
                    System.out.print("\n Phase 3 plant beans from hand:\n");
                    PhaseThreePlantHandsFromTheHand(alCabohne, donCorlebohne, joeBohnano, arrayOfPlayers[activePlayerNumber], thePlaceToKeepTheRevealedCards,drawPile,discardPile,isThisASinglePlayerGame);
                    System.out.print("\n Phase 4 Reveal beans from drawpile:\n");
                    phaseFour(alCabohne, donCorlebohne, joeBohnano, arrayOfPlayers[activePlayerNumber],thePlaceToKeepTheRevealedCards,drawPile,discardPile,isThisASinglePlayerGame);
                    if(drawPile.isDrawPileEmpty() == true)
                    {
                        i++;
                        transferCardsFromTheDiscardPileToTheDrawPileAndShuffleTheDrawPile(drawPile, discardPile);
                    }
                    System.out.print("\n Phase 5 Cultivate the beans:\n");
                    phaseFiveCultivateTheBeans(alCabohne, donCorlebohne, joeBohnano, arrayOfPlayers[activePlayerNumber],thePlaceToKeepTheRevealedCards,drawPile,discardPile,isThisASinglePlayerGame);
                    if(drawPile.isDrawPileEmpty() != false)
                    {
                        System.out.print("\n Phase 6 Draw cards from the drawpile:\n");
                        PhaseSixDrawCardsFromTheDrawPile(alCabohne, donCorlebohne, joeBohnano, arrayOfPlayers[activePlayerNumber], thePlaceToKeepTheRevealedCards, drawPile, discardPile, isThisASinglePlayerGame);
                    }
                    else
                    {
                        i++;
                        transferCardsFromTheDiscardPileToTheDrawPileAndShuffleTheDrawPile(drawPile, discardPile);
                    }
                }
            }


        }
        HarvestAllTheFieldsOfAllThePlayers(arrayOfPlayers, discardPile);
        alCabohne.player.harvest(alCabohne.fieldOne, discardPile);
        donCorlebohne.player.harvest(donCorlebohne.fieldOne, discardPile);
        if(isThisASinglePlayerGame)
        {
            joeBohnano.player.harvest(joeBohnano.fieldOne, discardPile);
        }
        showTheScoresOfAllThePlayers(arrayOfPlayers);
        System.out.print("\n Al Cabohne:" + alCabohne.player.returnTheNumberOfCoinsThatThePlayerCurrentlyHas());
        System.out.print("\n Don Corlebohne:" + donCorlebohne.player.returnTheNumberOfCoinsThatThePlayerCurrentlyHas());
        if(isThisASinglePlayerGame)
        {
            System.out.print("\n Joe Bohnano:" + joeBohnano.player.returnTheNumberOfCoinsThatThePlayerCurrentlyHas());
        }
    }

    private void DistributeInitialCardsToThePlayers(TheClassWhichHasThePlayerHandAndFields players[], DrawPile drawPile, Boolean isThisASinglePlayerGame)
    {
        if(isThisASinglePlayerGame == false)
        {
            distributeTheInitialFiveCardsToThePlayer(players, drawPile);


        }
    }

    private void DealTheCardsToTheMafia(TheClassWhichHasThePlayerHandAndFields alCabohne,
                                        TheClassWhichHasThePlayerHandAndFields donCorlebohne,
                                        TheClassWhichHasThePlayerHandAndFields joeBohnano,
                                        DrawPile drawPile,
                                        Boolean isThisASinglePlayerGame)
    {
        if(isThisASinglePlayerGame == false)
        {
            Boolean hasDonCorlebohneBeenDealtACard = false;
            while(hasDonCorlebohneBeenDealtACard == false)
            {
                Card cardToDeal = drawPile.getOneCardFromTheDrawPile();
                if(alCabohne.fieldOne.getTheNumberOfCardsInThisField() != 0)
                {
                    if(Objects.equals(alCabohne.fieldOne.getTheTypeOfCardInThisField(), cardToDeal.returnTheTypeOfTheCard()))
                    {
                        alCabohne.fieldOne.addCardsToTheField(cardToDeal);
                    }
                    else
                    {
                        donCorlebohne.fieldOne.addCardsToTheField(cardToDeal);
                        hasDonCorlebohneBeenDealtACard = true;
                    }
                }
                else
                {
                    alCabohne.fieldOne.addCardsToTheField(cardToDeal);
                }
            }
        }
    }

    private void PhaseOneUseTheLeftOverCards(TheClassWhichHasThePlayerHandAndFields alCabohne,
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
        while(thePlaceToKeepTheRevealedCards.returnTheTotalNumberOfCardsInAllTheSlots() != 0)
        {
            while(thePlaceToKeepTheRevealedCards.returnTheNumberOfCardsInSlotOne()!= 0 )
            {
                System.out.print("\n Do you want to plant the card or discard it?1.Plant 2.Discard:");
                int choice = scanner.nextInt();
                if(choice < 1 || choice > 2)
                {
                    throw new InvalidInputException("Invalid input");
                }
                if(choice == 1)
                {
                    Card cardToPlant = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
                    plantTheCardOnYourOwnField(activePlayer, cardToPlant, discardPile, isThisASinglePlayerGame );
                }
                else if(choice == 2)
                {
                    Card cardToDiscard = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
                    discardPile.AddACardToTheBackOfTheHand(cardToDiscard);
                }
            }

            while(thePlaceToKeepTheRevealedCards.returnTheNumberOfCardsInSlotTwo() != 0)
            {
                System.out.print("\n Do you want to plant the card or discard it?1.Plant 2.Discard:");
                int choice = scanner.nextInt();
                if(choice < 1 || choice > 2)
                {
                    throw new InvalidInputException("Invalid input");
                }
                if(choice == 1)
                {
                    Card cardToPlant = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotTwo();
                    plantTheCardOnYourOwnField(activePlayer, cardToPlant, discardPile, isThisASinglePlayerGame );
                }
                else if(choice == 2)
                {
                    Card cardToDiscard = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotTwo();
                    discardPile.AddACardToTheBackOfTheHand(cardToDiscard);
                }
            }

            while(thePlaceToKeepTheRevealedCards.returnTheNumberOfCardsInSlotThree() != 0)
            {
                System.out.print("\n Do you want to plant the card or discard it?1.Plant 2.Discard:");
                int choice = scanner.nextInt();
                if(choice < 1 || choice > 2)
                {
                    throw new InvalidInputException("Invalid input");
                }
                if(choice == 1)
                {
                    Card cardToPlant = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotThree();
                    plantTheCardOnYourOwnField(activePlayer, cardToPlant, discardPile, isThisASinglePlayerGame );
                }
                else if(choice == 2)
                {
                    Card cardToDiscard = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotThree();
                    discardPile.AddACardToTheBackOfTheHand(cardToDiscard);
                }
            }
        }
    }

    private void PhaseTwoGiveBeansToTheBeansMafia(
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
        //Checking if the cards in the player's field one is similar
        if(Objects.equals(activePlayer.fieldOne.getTheTypeOfCardInThisField(), alCabohne.fieldOne.getTheTypeOfCardInThisField()))
        {
            Card cardToGive = activePlayer.fieldOne.removeACardFromTheTopOfTheField();
            alCabohne.player.plant(cardToGive, alCabohne.fieldOne, discardPile);
        }
        if(Objects.equals(activePlayer.fieldOne.getTheTypeOfCardInThisField(), donCorlebohne.fieldOne.getTheTypeOfCardInThisField()))
        {
            Card cardToGive = activePlayer.fieldOne.removeACardFromTheTopOfTheField();
            donCorlebohne.player.plant(cardToGive, donCorlebohne.fieldOne, discardPile);
        }
        if(isThisASinglePlayerGame == true)
        {
            if(Objects.equals(activePlayer.fieldOne.getTheTypeOfCardInThisField(), joeBohnano.fieldOne.getTheTypeOfCardInThisField()))
            {
                Card cardToGive = activePlayer.fieldOne.removeACardFromTheTopOfTheField();
                joeBohnano.player.plant(cardToGive, joeBohnano.fieldOne, discardPile);
            }
        }

        //Checking if the cards in player's field two is similar
        if(Objects.equals(activePlayer.fieldTwo.getTheTypeOfCardInThisField(), alCabohne.fieldOne.getTheTypeOfCardInThisField()))
        {
            Card cardToGive = activePlayer.fieldTwo.removeACardFromTheTopOfTheField();
            alCabohne.player.plant(cardToGive, alCabohne.fieldOne, discardPile);
        }
        if(Objects.equals(activePlayer.fieldTwo.getTheTypeOfCardInThisField(), donCorlebohne.fieldOne.getTheTypeOfCardInThisField()))
        {
            Card cardToGive = activePlayer.fieldTwo.removeACardFromTheTopOfTheField();
            donCorlebohne.player.plant(cardToGive, donCorlebohne.fieldOne, discardPile);
        }
        if(isThisASinglePlayerGame == true)
        {
            if(Objects.equals(activePlayer.fieldTwo.getTheTypeOfCardInThisField(), joeBohnano.fieldOne.getTheTypeOfCardInThisField()))
            {
                Card cardToGive = activePlayer.fieldTwo.removeACardFromTheTopOfTheField();
                joeBohnano.player.plant(cardToGive, joeBohnano.fieldOne, discardPile);
            }
        }

        //Checking for field three if it is there
        if(activePlayer.isTheThirdFieldAvailable == true)
        {
            if(Objects.equals(activePlayer.fieldThree.getTheTypeOfCardInThisField(), alCabohne.fieldOne.getTheTypeOfCardInThisField()))
            {
                Card cardToGive = activePlayer.fieldThree.removeACardFromTheTopOfTheField();
                alCabohne.player.plant(cardToGive, alCabohne.fieldOne, discardPile);
            }
            if(Objects.equals(activePlayer.fieldThree.getTheTypeOfCardInThisField(), donCorlebohne.fieldOne.getTheTypeOfCardInThisField()))
            {
                Card cardToGive = activePlayer.fieldThree.removeACardFromTheTopOfTheField();
                donCorlebohne.player.plant(cardToGive, donCorlebohne.fieldOne, discardPile);
            }
            if(isThisASinglePlayerGame == true)
            {
                if(Objects.equals(activePlayer.fieldThree.getTheTypeOfCardInThisField(), joeBohnano.fieldOne.getTheTypeOfCardInThisField()))
                {
                    Card cardToGive = activePlayer.fieldThree.removeACardFromTheTopOfTheField();
                    joeBohnano.player.plant(cardToGive, joeBohnano.fieldOne, discardPile);
                }
            }
        }
    }

    private void PhaseThreePlantHandsFromTheHand(TheClassWhichHasThePlayerHandAndFields alCabohne,
                                                 TheClassWhichHasThePlayerHandAndFields donCorlebohne,
                                                 TheClassWhichHasThePlayerHandAndFields joeBohnano,
                                                 TheClassWhichHasThePlayerHandAndFields activePlayer,
                                                 ThePlaceToKeepTheRevealedCards thePlaceToKeepTheRevealedCards,
                                                 DrawPile drawPile,
                                                 Hand discardPile,
                                                 Boolean isThisASinglePlayerGame
    )
    {
        if(activePlayer.hand.isTheHandEmpty() != true)
        {
            Card cardToPlant = activePlayer.hand.getTheCardAtTheFrontOfTheHand();
            plantTheCardOnYourOwnField(activePlayer,cardToPlant, discardPile, isThisASinglePlayerGame);
            if(activePlayer.hand.isTheHandEmpty() != true)
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\n Do you want to plant one more card? 1.Yes 2.No:");
                int choice  = scanner.nextInt();
                if(choice < 1 || choice > 2)
                {
                    throw new InvalidInputException("Wrong input for the question : do you want to plant one more card");
                }
                if(choice == 1)
                {
                    plantTheCardOnYourOwnField(activePlayer, cardToPlant, discardPile, isThisASinglePlayerGame);
                }
            }
        }
    }

    private void PhaseSixDrawCardsFromTheDrawPile(
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
       activePlayer.hand.AddACardToTheBackOfTheHand(drawPile.getOneCardFromTheDrawPile());
       activePlayer.hand.AddACardToTheBackOfTheHand(drawPile.getOneCardFromTheDrawPile());
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
        if(drawPile.isDrawPileEmpty())
        {
            return;
        }
        thePlaceToKeepTheRevealedCards.addACardToSlotOne(drawPile.getOneCardFromTheDrawPile());
        while(Objects.equals(alCabohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotOne()))
        {
            Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
            alCabohne.player.plant(cardToTransferToTheBoss, alCabohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotOne(drawPile.getOneCardFromTheDrawPile());
            if(drawPile.isDrawPileEmpty())
            {
                return;
            }
        }
        while(Objects.equals(donCorlebohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotOne()))
        {
            Card cardToTranferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
            donCorlebohne.player.plant(cardToTranferToTheBoss, donCorlebohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotOne(drawPile.getOneCardFromTheDrawPile());
            if(drawPile.isDrawPileEmpty())
            {
                return;
            }
        }
        if(isThisASinglePlayerGame == true)
        {
            if(drawPile.isDrawPileEmpty()) {
            return;
            }
            while(Objects.equals(joeBohnano.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotOne()))
            {
                Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotOne();
                joeBohnano.player.plant(cardToTransferToTheBoss, joeBohnano.fieldOne, discardPile);
                thePlaceToKeepTheRevealedCards.addACardToSlotOne(drawPile.getOneCardFromTheDrawPile());
                if(drawPile.isDrawPileEmpty())
                {
                    return;
                }
            }
        }

        while(Objects.equals(thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotOne(), discardPile.getTheTypeOfCardInFrontOfTheHand()))
        {
            Card cardToAddToTheSlot = discardPile.getTheCardAtTheFrontOfTheHand();
            thePlaceToKeepTheRevealedCards.addACardToSlotOne(cardToAddToTheSlot);
        }

        //The phase 4 for the second revealed card
        if(drawPile.isDrawPileEmpty()){return;}
        thePlaceToKeepTheRevealedCards.addACardToSlotTwo(drawPile.getOneCardFromTheDrawPile());
        while(Objects.equals(alCabohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotTwo()))
        {
            Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotTwo();
            alCabohne.player.plant(cardToTransferToTheBoss, alCabohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotTwo(drawPile.getOneCardFromTheDrawPile());
            if(drawPile.isDrawPileEmpty()){return;}
        }
        if(drawPile.isDrawPileEmpty()){return;}
        while(Objects.equals(donCorlebohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotTwo()))
        {
            Card cardToTranferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotTwo();
            donCorlebohne.player.plant(cardToTranferToTheBoss, donCorlebohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotTwo(drawPile.getOneCardFromTheDrawPile());
            if(drawPile.isDrawPileEmpty()){return;}
        }
        if(isThisASinglePlayerGame == true)
        {
            if(drawPile.isDrawPileEmpty()){return;}
            while(Objects.equals(joeBohnano.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotTwo()))
            {
                Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotTwo();
                joeBohnano.player.plant(cardToTransferToTheBoss, joeBohnano.fieldOne, discardPile);
                thePlaceToKeepTheRevealedCards.addACardToSlotTwo(drawPile.getOneCardFromTheDrawPile());
                if(drawPile.isDrawPileEmpty()){return;}
            }
        }

        //The Phase 4 for the third revealed card
        if(drawPile.isDrawPileEmpty()){return;}
        thePlaceToKeepTheRevealedCards.addACardToSlotThree(drawPile.getOneCardFromTheDrawPile());
        while(Objects.equals(alCabohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotThree()))
        {
            if(drawPile.isDrawPileEmpty()){return;}
            Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotThree();
            alCabohne.player.plant(cardToTransferToTheBoss, alCabohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotThree(drawPile.getOneCardFromTheDrawPile());
            if(drawPile.isDrawPileEmpty()){return;}
        }
        if(drawPile.isDrawPileEmpty()){return;}
        while(Objects.equals(donCorlebohne.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotThree()))
        {
            if(drawPile.isDrawPileEmpty()){return;}
            Card cardToTranferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotThree();
            donCorlebohne.player.plant(cardToTranferToTheBoss, donCorlebohne.fieldOne, discardPile);
            thePlaceToKeepTheRevealedCards.addACardToSlotThree(drawPile.getOneCardFromTheDrawPile());
            if(drawPile.isDrawPileEmpty()){return;}
        }
        if(isThisASinglePlayerGame == true)
        {
            if(drawPile.isDrawPileEmpty()){return;}
            while(Objects.equals(joeBohnano.fieldOne.getTheTypeOfCardInThisField(), thePlaceToKeepTheRevealedCards.returnTheCardTypeInSlotThree()))
            {
                Card cardToTransferToTheBoss = thePlaceToKeepTheRevealedCards.removeAndReturnACardFromSlotThree();
                joeBohnano.player.plant(cardToTransferToTheBoss, joeBohnano.fieldOne, discardPile);
                thePlaceToKeepTheRevealedCards.addACardToSlotThree(drawPile.getOneCardFromTheDrawPile());
                if(drawPile.isDrawPileEmpty()){return;}
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
            if(numberOfCardsToPlant > thePlaceToKeepTheRevealedCards.returnTheTotalNumberOfCardsInAllTheSlots())
            {
                throw new InvalidInputException("You have input the wrong number of cards to plant from the revealed cards");
            }
            for(int i = 0; i < numberOfCardsToPlant; i++)
            {
                int slotToTakeTheCardFrom;
                System.out.print("\n From which slot do you want to take the card?: 1,2,3");
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
