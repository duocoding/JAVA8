package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName reflactTest01
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/9 22:01
 * @Version 1.0
 */
public class reflactTest01 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class c1 = Class.forName("reflect.User");

        User user = (User) c1.newInstance();
//        System.out.println(user);


        //通过构造器创建对象
//        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
//        User user1 = (User) constructor.newInstance("xiaoming", 001, 18);
//        System.out.println(user1);

        //通过反射获取方法
        Method method = c1.getDeclaredMethod("setUserName", String.class);
        method.invoke(user, "lisi");
//        System.out.println(user);

        //通过反射获取属性
        Field field = c1.getDeclaredField("age");
        field.setAccessible(true);
        field.set(user, 18);
        System.out.println(user);

    }
}
