import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class PageBeanApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfElements = 10;

        List<String> logs = new ArrayList<>();
        for(int i=0; i<numberOfElements; i++){
            logs.add(scanner.nextLine());
            System.out.println(logs);
        }

        PageBean<String> logBook = new PageBean<>(3,logs);
        System.out.println(logBook.next()+" - First page");
        while(true){

            String gate = scanner.nextLine();

            if(gate.equals("next")) {
                if (logBook.hasNext()) {
                    System.out.println(logBook.next()+ " - Next page("+
                            logBook.getCurrentPageNumber()+")");
                }
                else{
                    System.out.println("There is no next page!");
                }
            }
            else if(gate.equals("previous")) {
                if (logBook.hasPrevious()) {
                    System.out.println(logBook.previous()+ " - Previous page("+
                            logBook.getCurrentPageNumber()+")");
                }
                else{
                    System.out.println("There is no previous page!");
                }
            }

        }



    }

}
