public class TheClassWhichHasThePlayerHandAndFields {
    LogicOfTheGame.Player player;
    LogicOfTheGame.Hand hand;
    LogicOfTheGame.Field fieldOne;
    LogicOfTheGame.Field fieldTwo;
    LogicOfTheGame.Field fieldThree;
    LogicOfTheGame.AreasToKeepTheTurnedOverAndTradedCards theAreaToKeepTheTurnedOverAndTradedCards;
    Boolean isTheThirdFieldAvailable;

    TheClassWhichHasThePlayerHandAndFields(LogicOfTheGame.Player player, LogicOfTheGame.Hand hand, LogicOfTheGame.Field fieldOne, LogicOfTheGame.Field fieldTwo, LogicOfTheGame.Field fieldThree, LogicOfTheGame.AreasToKeepTheTurnedOverAndTradedCards theAreastoKeepTheTurnedOverAndTradedcards, Boolean isTheThirdFieldAvailable)

    {
        this.player = player;
        this.hand = hand;
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
        this.fieldThree = fieldThree;
        this.theAreaToKeepTheTurnedOverAndTradedCards = theAreastoKeepTheTurnedOverAndTradedcards;
        this.isTheThirdFieldAvailable = isTheThirdFieldAvailable;

    }
}
