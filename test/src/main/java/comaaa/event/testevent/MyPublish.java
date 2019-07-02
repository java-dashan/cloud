package comaaa.event.testevent;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class MyPublish {
    List<MyListener> list = new ArrayList<>();

    public static void main(String[] args) {
        MyPublish myPublish = new MyPublish();
        myPublish.addListener();
        MyEvent myEvent = new MyEvent(myPublish);
        myPublish.begin(1, myEvent);
        try {
            Thread.sleep(1000);
        }catch (Exception e) {

        }
        myPublish.begin(2,myEvent);
    }

    public void addListener() {
        list.add(new MyListener());
    }

    public void begin(int status, MyEvent eventObject) {
        List<MyListener> copy = new ArrayList<>(list);
        for (MyListener myListener : copy) {
            if (status == 1) {
                myListener.onMethodBefore(eventObject);
            }else  {
                myListener.onMethodAfter(eventObject);
            }
        }
    }


}
