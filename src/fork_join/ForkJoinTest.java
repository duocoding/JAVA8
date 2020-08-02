package fork_join;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @ClassName ForkJoinTest
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/2 22:49
 * @Version 1.0
 */
public class ForkJoinTest {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 1000000000);
        Long res = pool.invoke(task);
        System.out.println(res);

        Instant start = Instant.now();
        LongStream.rangeClosed(0, 100000000)
                .parallel()
                .reduce(0, Long::sum);
        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).toMillis());
    }


}
