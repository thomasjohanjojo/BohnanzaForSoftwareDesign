public class TheClassWhichHasThePlayerHandAndFields {
    LogicOfTheGame.Player player;
    LogicOfTheGame.Hand hand;
    LogicOfTheGame.Field fieldOne;
    LogicOfTheGame.Field fieldTwo;
    LogicOfTheGame.Hand theAreaToKeepTheTurnedOverCards;

    TheClassWhichHasThePlayerHandAndFields(LogicOfTheGame.Player player, LogicOfTheGame.Hand hand, LogicOfTheGame.Field fieldOne, LogicOfTheGame.Field fieldTwo, LogicOfTheGame.Hand theAreaToKeepTheTurnedOverCards)
    {
        this.player = player;
        this.hand = hand;
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
        this.theAreaToKeepTheTurnedOverCards = theAreaToKeepTheTurnedOverCards;
    }
}
