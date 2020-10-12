import java.util.Iterator;

public class ExperimentListDayIterator implements Iterator {

    ExperimentList.Experiment current;
    ExperimentList.Experiment back;

    /**
     * Constructor for iterator
     * @param ls
     */
    public ExperimentListDayIterator(ExperimentList ls){
        current = ls.getHead();
        back=null;
    }

    /**
     * Override of interface Iterator hasNext() method
     * Looks if current Experiments has next Experiment or not
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        return current.next!=null;
    }

    /**
     * Override of interface Iterator next() method
     * @return returns next Experiment
     */
    @Override
    public ExperimentList.Experiment next() {
        back = current;
        return current = current.dayNext;
    }

    /**
     * Removes current experiment from list
     */
    @Override
    public void remove() {
        back.next = current.next;
    }
}
