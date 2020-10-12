import java.util.Iterator;

public class ExperimentListIterator implements Iterator{

    ExperimentList.Experiment current;
    ExperimentList.Experiment back;

    /**
     * Constructor for iterator
     * @param ls
     */
    public ExperimentListIterator(ExperimentList ls){
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
     * @return returns next days first Experiment
     */
    @Override
    public ExperimentList.Experiment next() {
        back = current;
        return current = current.next;
    }

    /**
     * UnSupported Operation
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
