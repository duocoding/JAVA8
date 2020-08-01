package stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName StreamAPI5
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/1 9:31
 * @Version 1.0
 */
public class StreamAPI5 {


    /**
     * 终止操作
     *
     * 1、allMatch--检查是否匹配所有元素
     * 2、anyMatch--检查是否至少匹配一个元素
     * 3、noneMatch--检查是否没有匹配的元素
     * 4、findFirst--返回第一个元素
     * 5、findAny--返回当前流中的任意元素
     * 6、count--返回元素的总个数
     * 7、max--返回流中的最大值
     * 8、min--返回流中的最小值
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


        Boolean b1 = employees.stream()
                .allMatch( e1 -> e1.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = employees.stream()
                .anyMatch( e1 -> e1.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        Optional<Employee> employee = employees.stream()
                .sorted( (e1, e2) -> -Double.compare(e1.getSalare(), e2.getSalare()))
                .findFirst();

        System.out.println(employee.get());

        Optional<Employee> employee1 = employees.stream().parallel()
                .filter( e1 -> e1.getStatus().equals(Employee.Status.BUSY))
                .findAny();
        System.out.println(employee1.get());

        Optional<Double> employee2 = employees.stream()
                .map(Employee::getSalare)
                .min(Double::compare);
        System.out.println(employee2.get());

        /**
         * 规约
         * reduce
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer res = list.stream()
                .reduce(0 , (x, y) -> x+y);
        System.out.println(res);

        Optional<Double> res2 = employees.stream()
                .map(Employee::getSalare)
                .reduce(Double::sum);

        System.out.println(res2.get());

        /**
         * 收集
         * collect--把流转为其他形式
         */

        List list1 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(list1);

        Set set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        System.out.println(set);

        /**
         * 转成HashSet
         */
        HashSet hashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);

        /**
         * 平均值
         */
        Double avg = employees.stream()
//                .map(Employee::getSalare)
                .collect(Collectors.averagingDouble(Employee::getSalare));
        System.out.println(avg);

        /**
         * 总和
         */
        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalare));
        System.out.println(sum);

        /**
         * 总和
         */
        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalare(), e2.getSalare())));
        System.out.println(max.get());

        /**
         * 分组
         */
        Map<Employee.Status, List<Employee>> group = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(group);

        /**
         * 分区
         */
        Map<Boolean, List<Employee>> part = employees.stream()
                .collect(Collectors.partitioningBy( e1 -> e1.getSalare()>5000.0));
        System.out.println(part);

    }


}
