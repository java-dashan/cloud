package comaaa.event.testevent;

import java.util.EventListener;

public class MyListener implements EventListener {

    public void onMethodBefore(MyEvent myEvent) {
        myEvent.setTimestamp(System.currentTimeMillis());
    }

    public void onMethodAfter(MyEvent myEvent) {
        System.out.println(System.currentTimeMillis()-myEvent.getTimestamp());
    }
}
