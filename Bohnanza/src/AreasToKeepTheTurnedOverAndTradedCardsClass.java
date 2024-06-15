import java.util.ArrayList;
public class AreasToKeepTheTurnedOverAndTradedCardsClass implements LogicOfTheGame.AreasToKeepTheTurnedOverAndTradedCards {

    ArrayList<LogicOfTheGame.Card> turnedOverCardsArea = new ArrayList<>();
    ArrayList<LogicOfTheGame.Card> tradedCardsArea = new ArrayList<>();

    public void addACardToTheTurnedOverCardsArea(LogicOfTheGame.Card cardToAdd){
        turnedOverCardsArea.add(cardToAdd);
    }

    public void addACardToTheTradedCardsArea(LogicOfTheGame.Card cardToAdd){
        tradedCardsArea.add(cardToAdd);
    }

    public LogicOfTheGame.Card removeAndReturnATradedAreaCard(int indexOfTheCardWhichYouWantToReturn){
        return tradedCardsArea.remove(indexOfTheCardWhichYouWantToReturn);
    }

    public LogicOfTheGame.Card removeAndReturnATurnedOverAreaCard(int indexOfTheCardWhichYouWantToReturn){

        return turnedOverCardsArea.remove(indexOfTheCardWhichYouWantToReturn);
    }

    public void displayTheTurnedOverCardsInOrder(){
        for (LogicOfTheGame.Card indivCard: turnedOverCardsArea) {
            System.out.println(indivCard.returnTheTypeOfTheCard());
        }
    }

    public void displayTheCardsInTheTradedCardsArea(){
        for (LogicOfTheGame.Card indivCard: tradedCardsArea) {
            System.out.println(indivCard.returnTheTypeOfTheCard());
        }
    }

}
