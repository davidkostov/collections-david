import java.util.ArrayList;
import java.util.List;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class PageBean<T> {

    private int pageSize, numberOfPages, currentPageNumber;
    private List<T> elements, currentPage;

    public PageBean(int pageSize, List<T> listOfElements){

        this.pageSize = pageSize;
        currentPage = new ArrayList<>();
        elements = new ArrayList<>();
        elements.addAll(listOfElements);
        currentPageNumber = 0;

        if(elements.size()%pageSize != 0){
            numberOfPages = (elements.size()/pageSize)+1;
        }
        else{
            numberOfPages = (elements.size()/pageSize);
        }

    }

    /**
     * @return the next page of the PageBean
     */
    public List<T> next() {

        currentPage.clear();
        if(++currentPageNumber==numberOfPages){
            addToPageUntil(elements.size());
        }
        else {
            addToPageUntil(pageSize*currentPageNumber);
        }
        return currentPage;

    }

    /**
     * @return the previous page of the PageBean
     */
    public List<T> previous() {

        currentPage.clear();
        currentPageNumber--;
        addToPageUntil(pageSize * currentPageNumber);
        return currentPage;

    }

    /**
     * Checks if the PageBean has a next page
     * @return true if there is, false if there is not
     */
    public boolean hasNext() {
        if (currentPageNumber + 1 > numberOfPages) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if the PageBean has a previous page
     * @return true if there is, false if there is not
     */
    public boolean hasPrevious() {
        if (currentPageNumber - 1 <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return the first page of the PageBean
     */
    public List<T> firstPage() {

        currentPage.clear();
        currentPageNumber = 1;
        addToPageUntil(pageSize * currentPageNumber);
        return currentPage;

    }

    /**
     * @return the last page of the PageBean
     */
    public List<T> lastPage() {

        currentPage.clear();
        currentPageNumber = numberOfPages;
        addToPageUntil(pageSize * currentPageNumber);
        return currentPage;

    }

    /**
     * @return the number of the current page the client is on
     */
    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    /**
     * A custom method
     * @param addUntill is the integer untill which elements will be added
     */
    private void addToPageUntil(int addUntill){
        for(int i = ((pageSize*currentPageNumber)-(pageSize-1))-1;
            i < addUntill; i++){
            currentPage.add(elements.get(i));
        }
    }

}
