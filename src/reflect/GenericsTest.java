package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GenericsTest
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/10 0:07
 * @Version 1.0
 */
public class GenericsTest {

    public void test01(Map<String, User> map, List<User> list){
        System.out.println("test01");
    }

    public String test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GenericsTest.class.getMethod("test01", Map.class, List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
            if(genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
    }
}
