package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

import stream.Employee;

/**
 * @ClassName StreamAPI1
 * @Description 生成流的几种方式
 * @Author qulingxiao
 * @Date 2020/7/31 22:57
 * @Version 1.0
 */
public class StreamAPI1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Stream<String> stream1 = list.stream();

        Employee[] employees = new Employee[10];

        Stream<Employee> stream2 = Arrays.stream(employees);

        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        stream3.limit(2)
                .forEach(System.out::println);

        Stream.generate( () -> Math.random())
                .limit(5)
                .forEach(System.out::println);

    }






}
