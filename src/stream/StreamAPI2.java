package stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName StreamAPI2
 * @Description 流的中间操作
 * @Author qulingxiao
 * @Date 2020/7/31 23:17
 * @Version 1.0
 */
public class StreamAPI2 {

    /**
     * 筛选与切片
     * filter--接收lambda， 从流中排除掉某些元素
     * limit --阶段流，是其元素不超过给定量
     * skip（n），与limit（n）互补，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回空流。
     * distinct--筛选，通过流所生成元素的hashcode（） 和 equals（）去除重复元素
     */

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("zhangsan", 18, 4543),
                new Employee("lisi", 19, 3333),
                new Employee("wangwu", 22, 5555),
                new Employee("zhaoliu", 30, 20000),
                new Employee("tianqi", 28, 8888),
//                new Employee("liuba", 25, 7777),
//                new Employee("liuba", 25, 7777),
                new Employee("liuba", 25, 7777)
        );

        employees.stream()
                .filter( employee -> employee.getName().length() > 4)
//                .skip(2)
//                .map(Employee::getName)
                .map(employee -> employee.getName().toUpperCase())
                .distinct()
                .forEach(System.out::println);

        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
