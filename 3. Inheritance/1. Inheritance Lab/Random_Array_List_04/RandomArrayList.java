package Random_Array_List_04;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {

    public Object getRandomElement(){
        int index = new Random().nextInt(super.size());
        return super.get(index);
    }
}
