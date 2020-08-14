package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Constructor constructor = clazz.getConstructor(int.class, int.class);
        Operator obj = (Operator) constructor.newInstance(10, 10);
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.asList(methods).stream()
                .forEach( m -> m.setAccessible(true));
//        Optional<Method> oneMethod = Arrays.asList(methods).stream()
//                .filter(m -> m.getName().equals("setA"))
//                .findFirst();
//        oneMethod.get().invoke(obj, 20);
//        Method method = clazz.getDeclaredMethod("setA", int.class);
//        method.setAccessible(true);
//        method.invoke(obj, 10);


        Method method1 = clazz.getDeclaredMethod("setB", int.class);
        method1.setAccessible(true);
        method1.invoke(obj, 20);

        Method addMethod = Arrays.asList(methods).stream()
                .filter( m -> m.getName().equals("add"))
                .findFirst()
                .orElse(null);
        int result = (int) addMethod.invoke(obj, 15, 15);
//        Method method2 = clazz.getDeclaredMethod("add", int.class, int.class);
//        method2.setAccessible(true);
//        Object result =  method2.invoke(obj, 20, 20);
        System.out.println(Integer.valueOf((Integer) result));

    }
}
