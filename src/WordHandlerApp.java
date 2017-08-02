/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class WordHandlerApp {

    public static void main(String[] args) {

        Sentence handler = new Sentence();
        String sentence = " df lj kg hg df rt ld aa df li qo rt hg nei";

        System.out.println("This sentence - "+sentence+" - contains:\n"+
                handler.wordsQuantity(sentence));

        sentence = "Niki Iliev";
        System.out.println("The most frequent char in - "+sentence+
                " - is: \""+handler.mostFrequentChar(sentence)+"\"");

    }

}
