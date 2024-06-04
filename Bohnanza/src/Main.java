public class Main {
    public static void main(String[] args)
    {
        for(int i = 0; i < 4; i++)
        {
            PlayerClass playerClassObject = new PlayerClass();
            HandClass handClassObject = new HandClass();
            FieldClass fieldClassObjectOne = new FieldClass();
            FieldClass fieldClassObjectTwo = new FieldClass();
            HandClass theAreaTokeepTheTurnedOverCards = new HandClass();

            TheClassWhichHasThePlayerHandAndFields playerObject = new TheClassWhichHasThePlayerHandAndFields(playerClassObject, handClassObject, fieldClassObjectOne, fieldClassObjectTwo, theAreaTokeepTheTurnedOverCards);
        }

    }
}
