public interface ThePlaceToKeepTheRevealedCards {
    void addACardToSlotOne(LogicOfTheGame.Card cardToAdd);
    void addACardToSlotTwo(LogicOfTheGame.Card cardToAdd);
    void addACardToSlotThree(LogicOfTheGame.Card cardToAdd);

    LogicOfTheGame.Card removeAndReturnACardFromSlotOne();
    LogicOfTheGame.Card removeAndReturnACardFromSlotTwo();
    LogicOfTheGame.Card removeAndReturnACardFromSlotThree();

    String returnTheCardTypeInSlotOne();
    String returnTheCardTypeInSlotTwo();
    String returnTheCardTypeInSlotThree();

    int returnTheNumberOfCardsInSlotOne();
    int returnTheNumberOfCardsInSlotTwo();
    int returnTheNumberOfCardsInSlotThree();
    int returnTheTotalNumberOfCardsInAllTheSlots();

}
