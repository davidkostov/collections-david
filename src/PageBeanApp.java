import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class PageBeanApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> logs = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

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
            else if(gate.equals("previous")||gate.equals("prev")) {
                if (logBook.hasPrevious()) {
                    System.out.println(logBook.previous()+ " - Previous page("+
                            logBook.getCurrentPageNumber()+")");
                }
                else{
                    System.out.println("There is no previous page!");
                }
            }
            else if(gate.equals("first")){
                System.out.println(logBook.firstPage()+ " - First Page");
            }
            else if(gate.equals("last")){
                System.out.println(logBook.lastPage()+ " - Last Page");
            }

        }



    }

}
