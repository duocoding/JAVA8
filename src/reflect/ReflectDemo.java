package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/1 23:18
 * @Version 1.0
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("reflect.Operator");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods){
            method.setAccessible(true);
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields){
            field.setAccessible(true);
        }
        Constructor constructor = clazz.getConstructor();
        Object obj = constructor.newInstance();
//        Constructor constructor = clazz.getConstructor(int.class, int.class);
//        Operator obj = (Operator) constructor.newInstance(10, 10);

        Method method = clazz.getDeclaredMethod("setA", int.class);
        method.setAccessible(true);
        method.invoke(obj, 20);

        Method method1 = clazz.getDeclaredMethod("setB", int.class);
        method1.setAccessible(true);
        method1.invoke(obj, 20);

        Method method2 = clazz.getDeclaredMethod("add", int.class, int.class);
        method2.setAccessible(true);
        Object result =  method2.invoke(obj, 20, 20);
        Integer.valueOf((Integer) result);

    }
}
