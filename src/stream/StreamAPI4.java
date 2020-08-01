package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StreamAPI4
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/1 9:19
 * @Version 1.0
 */
public class StreamAPI4 {

    /**
     * 排序操作
     *
     * 1、sorted()---自然排序 comparable
     * 2、sorted(Comparator com)---定制排序
     *
     * @param args
     */

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("zhangsan", 18, 4543, Employee.Status.BUSY),
                new Employee("lisi", 19, 3333, Employee.Status.FREE),
                new Employee("wangwu", 22, 5555, Employee.Status.BUSY),
                new Employee("zhaoliu", 30, 20000, Employee.Status.VOCATION),
                new Employee("tianqi", 28, 8888, Employee.Status.FREE),
//                new Employee("liuba", 25, 7777),
//                new Employee("liuba", 25, 7777),
                new Employee("liuba", 25, 7777, Employee.Status.VOCATION)

        );

        List<String> list = Arrays.asList("ccc", "bbb", "aaa", "eee", "ggg");

        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------");

        employees.stream()
                .sorted( (e1, e2) -> {
                    if(e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    }else {
                        return e1.getAge() - e2.getAge();
                    }
                })
                .forEach(System.out::println);

    }
}
