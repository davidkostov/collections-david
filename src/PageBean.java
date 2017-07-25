import java.util.ArrayList;
import java.util.List;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class PageBean<T> {

    private int pageSize, numberOfPages, currentPageNumber;
    private List<T> elements;

    public PageBean(int pageSize, List<T> listOfElements){

        this.pageSize = pageSize;
        elements = new ArrayList<>();
        elements.addAll(listOfElements);
        currentPageNumber = 0;

        numberOfPages = (elements.size()/pageSize)+
                (elements.size()%pageSize!=0 ? 1:0);

    }

    /**
     * @return the next page of the PageBean
     */
    public List<T> next() {
        return ++currentPageNumber==numberOfPages
                ? elements.subList(getStartingPoint(),elements.size())
                : elements.subList(getStartingPoint(),pageSize*currentPageNumber);
    }

    /**
     * @return the previous page of the PageBean
     */
    public List<T> previous() {
        currentPageNumber--;
        return elements.subList(getStartingPoint(),pageSize*currentPageNumber);
    }

    /**
     * Checks if the PageBean has a next page
     * @return true if there is, false if there is not
     */
    public boolean hasNext() {
        return currentPageNumber + 1 <= numberOfPages;
    }

    /**
     * Checks if the PageBean has a previous page
     * @return true if there is, false if there is not
     */
    public boolean hasPrevious() {
        return currentPageNumber - 1 > 0;
    }

    /**
     * @return the first page of the PageBean
     */
    public List<T> firstPage() {
        currentPageNumber = 1;
        return elements.subList(0,pageSize);
    }

    /**
     * @return the last page of the PageBean
     */
    public List<T> lastPage() {
        currentPageNumber = numberOfPages;
        return elements.subList(getStartingPoint(),elements.size());
    }

    /**
     * @return the number of the current page the client is on
     */
    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    /**
     * A method to shorten code and improve readability
     * @return the starting point for subList method
     */
    private int getStartingPoint(){
        return ((pageSize*currentPageNumber)-(pageSize-1))-1;
    }

}
