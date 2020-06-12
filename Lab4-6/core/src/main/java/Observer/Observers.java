package Observer;

import java.util.ArrayList;
import java.util.Iterator;

public class Observers<T extends Observer> extends ArrayList<T> {
    public void notifyObjectCreated(Object object) {
        for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
            iter.next().objectCreated(object);
    }
    public void notifyObjectChanged(Object object) {
        for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
            iter.next().objectChanged(object);
    }
}