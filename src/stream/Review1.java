package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @ClassName Review1
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/2 10:47
 * @Version 1.0
 */
public class Review1 {

    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(1,2,3,4,5,6,7);

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


        /**
         * map方式
         */
        Stream stream = lists.stream()
                .map(v -> v*v);

        stream.forEach(System.out::println);

        /**
         * map 和 reduce方式
         */
        Optional<Double> res = employees.stream()
                .map( Employee::getSalare)
                .reduce(Double::sum);
        System.out.println(res.get());

        employees.stream()
                .map(Employee::getName)
                .flatMap( new Review1()::filterCharater)
                .sorted()
                .forEach(System.out::print);


    }

    public Stream<Character> filterCharater(String str){
        List<Character> list = new ArrayList<>();

        for (Character character: str.toCharArray()){
            list.add(character);
        }
        return list.stream();
    }
}
