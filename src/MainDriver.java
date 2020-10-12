import java.sql.Time;

public class MainDriver {
    public static void main(String[] args) {
        /* Test Inputs */
        /*
        ExperimentList a = new ExperimentList(null);

        a.addExp(new ExperimentList.Experiment("1",new Time(1000000),true, (float) 1.14,1,null));
        a.addExp(new ExperimentList.Experiment("2",new Time(10000000),true,(float)3.14,1,null));

        a.addExp(new ExperimentList.Experiment("3",new Time(10000000),true,(float)2.14,2,null));
        a.addExp(new ExperimentList.Experiment("4",new Time(10000000),true,(float)4.14,2,null));
        a.addExp(new ExperimentList.Experiment("5",new Time(10000000),true,(float)3.15,2,null));
        a.addExp(new ExperimentList.Experiment("6",new Time(10000000),true,(float)7.14,2,null));

        a.addExp(new ExperimentList.Experiment("3-1",new Time(10000000),true,(float)2.11,3,null));
        a.addExp(new ExperimentList.Experiment("3-2",new Time(10000000),true,(float)5.18,3,null));
        a.addExp(new ExperimentList.Experiment("3-3",new Time(10000000),true,(float)32.14,3,null));
        a.addExp(new ExperimentList.Experiment("3-4",new Time(10000000),true,(float)2.10,3,null));
        a.addExp(new ExperimentList.Experiment("3-5",new Time(10000000),true,(float)8.14,3,null));
        a.addExp(new ExperimentList.Experiment("3-6",new Time(10000000),true,(float)9.14,3,null));
        a.addExp(new ExperimentList.Experiment("5-0",new Time(10000000),true,(float)1.05,5,null));
        a.addExp(new ExperimentList.Experiment("4-0",new Time(10000000),true,(float)2.18,4,null));

        */
       /*Sorted List :
       * 5-0
       * 1
       * 3-4
       * 3-1
       * 3
       * 4-0
       * 2
       * 5
       * 4
       * 3-2
       * 6
       * 3-5
       * 3-6
       * 3-3
       * */


        /*Test Of getExp method*/
        /*
        System.out.println(a.getExp(3,0));
        a.listAll();
        */
        /*Test Of remove method*/
        /*
        System.out.println(a.remove(3,2));
        a.listAll();
        */

        /*Test Of removeDay method*/
        /*
        a.removeDay(1);
        a.listAll();
        */

        //a.orderDay(4); /*3-5-4-6 ASC order*/
        //a.listAll();/*3-4,3-1,3-2,3-5,3-6,3-3 k to b*/

        /*Sort Test*/
        /*
        ExperimentList sorted = a.orderExperiments();
        sorted.listAll();
        */
    }
}
