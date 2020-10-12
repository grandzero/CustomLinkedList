import java.sql.Time;
import java.util.Iterator;

import static java.lang.System.exit;

public class ExperimentList implements Iterable {

    private Experiment head;
    private Experiment tail;
    private Experiment dayHead;
    private int size = 0;
   static class Experiment {
       String setup;
       int day;
       Time time;
       boolean completed;
       float accuracy;
       Experiment next;
       Experiment dayNext;

       Experiment(String setUp, Time t, boolean c, float a,int d ,Experiment n) {
           setup = setUp;
           time = t;
           completed = c;
           accuracy = a;
           next = n;
           day = d;
           dayNext = null;
       }



       @Override
       public boolean equals(Object obj) {
           Experiment other = (Experiment) obj;
           if (this.setup.equals(other.setup)) {
               return true;
           }
           return false;
       }
       @Override
       public String toString() {
           return "Experiment{" +
                   "setup='" + setup + '\'' +
                   ", day=" + day +
                   ", time='" + time + '\'' +
                   ", accuracy=" + accuracy +
                   ", completed=" + completed +
                   '}';
       }

   }

    /**
     * Constructor for ExperimentList
     * @param h
     */
   ExperimentList(Experiment h){
        head = h;tail =h;dayHead=h;
        if(h!=null)
            size=1;
    }

    /**
     * Helper method to get head of list
     * @return head of List
     */
    public Experiment getHead(){return head;}

    /**
     * Takes a newExp parameter and adds that experiment
     * to where it belongs
     * @param newExp
     */
    public void addExp(Experiment newExp){
        /**
         * Checks for is day is 0
         */
        /*********************************************/
        /*!!!!!!!!!!!!!!!!! Attention !!!!!!!!!!!!!!!*/
        /*Day = 0 is invalid argument for this method*/
        /*********************************************/
       if(newExp.day == 0){
           System.err.println("Your experiments should start from day 1");
           System.err.println("Day 0 will not be accepted");
           exit(-1);
       }
        /*Checks if first added element*/
          if(size==0){
              head = newExp;
              tail = newExp;
              dayHead = newExp;
              size++;
              return;
          }
          /*Checks if new biggest day*/
          if(newExp.day>dayHead.day){
              dayHead.dayNext = newExp;
              dayHead = dayHead.dayNext;

          }
          /*If day equal to last day than adds last of list*/
          if(newExp.day == dayHead.day){
              tail.next = newExp;
              tail = newExp;
              ++size;
              return;
          }
          /*Adds experiment to occasionally in list*/
          if(getExp(newExp.day,0)==null){
              Experiment temp = getExp(newExp.day-1,0);
              Experiment sec = temp;
              /*Finding last index of choosen day-1*/
              while(temp.next.day == temp.day){
                  temp = temp.next;
              }
              newExp.dayNext = sec.dayNext;
              newExp.next = temp.next;
              sec.dayNext = newExp;
              temp.next = newExp;
              ++size;
              return;
          }else {
              Experiment temp = getExp(newExp.day - 1, 0);
              Experiment sec = temp;
              /*Finding last index of choosen day-1*/
              while (temp.next.day == temp.day) {
                  temp = temp.next;
              }
              newExp.next = temp.next;
              temp.next = newExp;
              ++size;
              return;
          }
    }

    /**
     * takes a day and an index from beginning that day
     * @param day specified day
     * @param index starts from days first experiment
     * @return returns an Experiment object
     */
    public Experiment getExp(int day, int index){


        Experiment temp = head;
        for(int i = 1; i< day; ++i){
            temp = temp.dayNext;
        }
        if(temp.day != day)
            return null;
        for(int i = 0; i<index; ++i){
            temp = temp.next;
        }

        return temp;

    }

    /**
     * Since there is not any remove situation
     * This method makes a shallow change on
     * given day and indexed Experiment objects data fields
     * @param day specified day
     * @param index starts from specified days first input
     * @param exp new Experiment which should set over old one
     */
    public void setExp(int day, int index,Experiment exp) {

       Experiment temp = getExp(day,index);
       temp.setup = exp.setup;
       temp.accuracy = exp.accuracy;
       temp.time = exp.time;
       temp.completed = exp.completed;


    }

    /**
     * Removes an object from list
     * @param day specified day
     * @param index starts from specified days first input
     * @return
     */

    public Experiment remove(int day,int index) {
        Experiment temp = getExp(day,index);
        Experiment previous;
        if(size == 1){
            temp = head;
            head = null;
            tail = null;
            dayHead = null;
            size--;
            return temp;
        }
        if(index!=0){
            previous = getExp(day,index-1);
            previous.next = temp.next;
            size--;
            return temp;
        }else{
            if(day == 1){
                temp.next.dayNext = temp.dayNext;
                head = temp.next;
                size--;
                return temp;
            }
            /*First loop is for finding before dayHead*/
            previous = head;
            for(int i = 1; i< day-1; ++i){
                previous = previous.dayNext;
            }
            previous.dayNext = temp.next;
            while(previous.next.day < day){
                previous = previous.next;
            }
            previous.next = temp.next;
            size--;
            return temp;

        }
    }

    /**
     * Lists all completed experiments in a given day
     * @param day a specified day
     * @return a new list of given days experiments
     */
    public ExperimentList listExp(int day) {
        /*Creating a new list from day*/
       ExperimentList res = new ExperimentList(getExp(day,0));
       Experiment listHead = getExp(day,0);
       listHead.dayNext = null;
       while(listHead.next.day == listHead.day){

           res.addExp(listHead.next);
           listHead = listHead.next;
       }
       /*Prints that day as a list to the console*/
        res.printList();
        return res;
    }

    /**
     *  removes all experiments in a given day
     * @param day specified
     */
    public void removeDay(int day){
        Experiment rm = getExp(day,0);

        while(rm.next.day == rm.day){
            remove(day,0);
            rm = rm.next;
        }
        if(day==1){
            head = head.next;
            --size;
        }else{
            remove(day,0);
        }


    }

    /**
     * sorts the experiments in a given day according to the accuracy, the changes are done on the list
     * @param day
     */
    public void orderDay(int day) {
        int n = 1;
        Experiment temp = getExp(day,0);
        while(temp.day == temp.next.day){
            ++n;
            temp = temp.next;
        }

         temp = getExp(day,0);
         Experiment cmp = temp;
         for(int i = 0; i<n ; ++i){
             cmp = temp;
             while(cmp.next.day != day+1){
                 if(cmp.accuracy > cmp.next.accuracy){
                     swap(cmp.next,cmp);
                 }
                 cmp = cmp.next;

             }

         }

    }

    /**
     * Helper method to swap two experiments data
     * @param e1 first experiment
     * @param e2 second experiment
     */
    private void swap(Experiment e1, Experiment e2) {

            Experiment temp = new Experiment(e1.setup,e1.time,e1.completed,e1.accuracy,e1.day,null);

            e1.setup = e2.setup;
            e1.accuracy = e2.accuracy;
            e1.time = e2.time;
            e1.completed = e2.completed;

            e2.setup = temp.setup;
            e2.completed = temp.completed;
            e2.time = temp.time;
            e2.accuracy = temp.accuracy;

    }

    /**
     * orts all the experiments in the list according to the accuracy,
     * without changing the original list
     * @return
     */
    public ExperimentList orderExperiments(){
       /*Getting a copy of current Experiment List*/
       ExperimentList result = new ExperimentList(null);
       Experiment node = getHead();
       for(int i = 0; i<size; ++i) {
           result.addExp(node);
           node = node.next;
       }

       /*Sorting new List ascending order*/
        Experiment temp = result.getHead();
        Experiment cmp = temp;
        for(int i = 0; i<size ; ++i){
            cmp = temp;
            while(cmp.next != null){
                if(cmp.accuracy > cmp.next.accuracy){
                    swap(cmp.next,cmp);
                }
                cmp = cmp.next;
            }
        }
        return result;
    }

    /**
     * Overrides iterator method to
     * return a ExperimentListIterator
     * @return ExperimentListIterator object
     */
    @Override
    public Iterator iterator() {
        return new ExperimentListIterator(this);
    }

    /**
     * Overrides iterator method to
     * return a ExperimentListIterator
     * @return ExperimentListIterator object
     */
    private Iterator dayIterator(){
       return new ExperimentListDayIterator(this);
    }

    /*For test purposes*/

    /**
     * Helper method to print all Experiments on the list
     */
    private void printList(){
        Experiment temp = head;
        for(int i = size ; i>0 ; --i){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /* For test purpose */

    /**
     * Helper method to print all first Experiments of days on the list
     */
    private void printDayHeads(){
        Experiment temp = head;
        while(temp.dayNext!=null){
            System.out.println(temp);
            temp = temp.dayNext;
        }
        System.out.println(temp);
    }

    /**
     * Method to print all Experiments and day's first Experiments
     */
    public void listAll(){
        printList();
        printDayHeads();
    }
}
