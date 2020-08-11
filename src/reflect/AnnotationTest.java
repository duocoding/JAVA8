package reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @ClassName AnnotationTest
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/10 23:34
 * @Version 1.0
 */
public class AnnotationTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("reflect.Student");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Field name = c1.getDeclaredField("name");
        FieldArea fieldArea = name.getAnnotation(FieldArea.class);
        System.out.println(fieldArea.columnName());
        System.out.println(fieldArea.length());
        System.out.println(fieldArea.type());
    }

}

@ClassArea("db_student")
class Student{

    @FieldArea(columnName = "db_age", type = "int", length = 10)
    private int age;

    @FieldArea(columnName = "db_id", type = "int", length = 10)
    private int id;

    @FieldArea(columnName = "db_name", type = "int", length = 10)
    private String name;

    public Student() {
    }

    public Student(int age, int id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//类注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassArea{
    String value();
}

//属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldArea{
    String columnName();
    String type();
    int length();
}
