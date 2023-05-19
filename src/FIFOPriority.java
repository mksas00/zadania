import java.util.ArrayList;
import java.util.List;

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

    public String popFirst(){
        if(fifoPriorityList.isEmpty()) return null;
        String valueToReturn = fifoPriorityList.get(0).getValue();
        fifoPriorityList.remove(fifoPriorityList.get(0));
        return valueToReturn;
    }

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
