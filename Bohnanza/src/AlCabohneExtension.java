import java.util.Objects;

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




}
