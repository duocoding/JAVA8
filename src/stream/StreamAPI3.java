package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamAPI3
 * @Description 映射
 * @Author qulingxiao
 * @Date 2020/8/1 8:50
 * @Version 1.0
 */
public class StreamAPI3 {


    /**
     * 映射操作
     * map
     * flatmap
     * @param args
     */

    public static void main(String[] args) {

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");

        list.stream()
                .map( s -> s.toUpperCase())
                .forEach(System.out::println);

//        new StreamAPI3().filterCharater("asdfgghjh")
//                .forEach(System.out::println);
//
        list.stream()
                .map(new StreamAPI3()::filterCharater)
                .forEach( v -> {
                    v.forEach(System.out::println);
                });

        list.stream()
                .flatMap(new StreamAPI3()::filterCharater)
                .forEach(System.out::println);

        }


    public Stream<Character> filterCharater(String str){
        List<Character> list = new ArrayList<>();

        for (Character character: str.toCharArray()){
            list.add(character);
        }
        return list.stream();
    }
}
