import java.util.ArrayList;
import java.util.List;

/**
 * Klasa FIFOPriority jest implementacją kolejki FIFO która przechowuje elementy typu FIFOElement które przechowują
 * wartości typu String oraz priorytet tych wartości w kolejce
 */
public class FIFOPriority {

    public List<FIFOElement> fifoPriorityList;

    public FIFOPriority() {
        this.fifoPriorityList = new ArrayList<>();
    }

    public void push(String element, int priority){
        if(priority < 0 )priority = 0;
        else if(priority > 99) priority = 99;
        fifoPriorityList.add(new FIFOElement(element, priority));
    }

    /**
     * Funkcja zwraca wartość pierwszego elementu z kolejki.
     * @return
     */
    public String popFirst(){
        if(fifoPriorityList.isEmpty()) return null;
        String valueToReturn = fifoPriorityList.get(0).getValue();
        fifoPriorityList.remove(fifoPriorityList.get(0));
        return valueToReturn;
    }

    /**
     * Funkcja zwraca element o najwyższym priorytecie spośród trzech pierwszych elementów stojących przy "wyjściu" z
     * kolejki. Jeśli dwa lub więcej elementów posiada ten sam priorytet zwracana jest wartość elemtnu stojącego
     * najbliżej "wyjścia".
     * @return
     */
    public String popHighThree(){

        if(fifoPriorityList.isEmpty()) return null;

        List<FIFOElement> topPriority = new ArrayList<>();
        topPriority.add(fifoPriorityList.get(0));

        for(int i = 1; i < 3 && i < fifoPriorityList.size(); i ++){
                if(fifoPriorityList.get(i).getPriority() > topPriority.get(0).getPriority()){
                    topPriority.clear();
                    topPriority.add(fifoPriorityList.get(i));
                }
        }
        fifoPriorityList.remove(topPriority.get(0));
        return topPriority.get(0).getValue();

    }

    /**
     * Funkcja zwraca element o najwyższym priorytetcie spośród wszystkich elemtnów znajdujących się w kolejce, jeśli
     * dwa lub więcej elementów posiada ten sam priorytet zwracana jest wartość elementy stojącego najbliżej wyjścia z
     * kolejki.
     * @return
     */
    public String popHighest(){

        if(fifoPriorityList.isEmpty()) return null;

        List<FIFOElement> topPriority = new ArrayList<>();
        topPriority.add(fifoPriorityList.get(0));

        for(int i = 1; i < fifoPriorityList.size(); i ++){
            if(fifoPriorityList.get(i).getPriority() > topPriority.get(0).getPriority()){
                topPriority.clear();
                topPriority.add(fifoPriorityList.get(i));
            }
        }
        fifoPriorityList.remove(topPriority.get(0));
        return topPriority.get(0).getValue();

    }

    /**
     * Klasa ma zadanie przechowywanie wartości danych zapisywanych w kolejce wraz z ich priorytetami.
     */
    class FIFOElement{

        private int priority;
        private String value;

        public FIFOElement(String value, int priority) {
            this.priority = priority;
            this.value = value;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        FIFOPriority fifoPriority = new FIFOPriority();
        fifoPriority.push("Sebastian", 2);
        fifoPriority.push("Mikołaj", 2);
        fifoPriority.popFirst();

    }

}
