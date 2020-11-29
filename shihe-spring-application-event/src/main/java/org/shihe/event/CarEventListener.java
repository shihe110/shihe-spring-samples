package org.shihe.event;

/**
 * @ClassName BusEventListener
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 9:43
 * @Version 1.0
 */
public class CarEventListener extends AbstractEventListener{
    public CarEventListener(int order) {
        super(order);
    }

    @Override
    public void onEvent(Event event) {
        System.out.println("Car监听器执行");

        EventObject eventObject = event.getEventObject();
        Order o = eventObject.getO();
        System.out.println(o.getOrderNo());
    }
}
