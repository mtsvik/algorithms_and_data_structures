package DynamicProgrammingTask;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 17.03.14
 */

public class LeaveForest {

    static void setFinalStaticField(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        // удаляем модификатор final с поля и присваиваем новое значение
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, newValue);
    }

    public static void main(String[] args) throws Exception {
        Class<?> truckClass = Class.forName("reflection.Truck");
        Class<?> wheelClass = Class.forName("reflection.Truck$Wheel");
        Object truckInstance = truckClass.newInstance();

        // берем три метода по их именам
        Method isPumpedUp = wheelClass.getMethod("isPumpedUp");
        Method pumpUp = wheelClass.getMethod("pumpUp");
        Method getWheels = truckClass.getMethod("getWheels");
        Method openDoor = truckClass.getMethod("openDoor");
        Method switchLights = truckClass.getMethod("switchLights");
        Method go = truckClass.getMethod("go", int.class);

        Object[] wheels = (Object[]) getWheels.invoke(truckInstance); // берем массив колес
        for (Object wheel : wheels) if (!(Boolean) isPumpedUp.invoke(wheel)) pumpUp.invoke(wheel); // если колесо не накачано, накачиваем его
        for (int i = 0; i < 3; i++) openDoor.invoke(truckInstance); // открываем дверь с третьего раза
        switchLights.invoke(truckInstance); // зажигаем фары
        go.invoke(truckInstance, (int)(6 + Math.random()*58)); // валим из леса на скорости от 6 до 64 м/ч


        // меняем "Супер-секретное супер-важное приватное поле"
        Field trololo = truckInstance.getClass().getDeclaredField("WAT");
        setFinalStaticField(trololo, "Не такое уж и супер-секретное и супер-важное поле однако");
        System.out.println(trololo.get(null));
    }
}


