package fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * @ClassName ForkJoinCalculate
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/2 22:33
 * @Version 1.0
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

//    private static final long serialVersionUID = 134656970987L;

    private long start;
    private long end;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    private static final long THRESHOLD = 10000;


    @Override
    protected Long compute() {

        if ((end - start) <= THRESHOLD){
            long sum = 0;
            for (long i= start; i<= end; i++ ){
                sum+=i;
            }
            return sum;
        }else {
            long middle = (start + end)/2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            //拆分子任务，同时加入到线程队列
            left.fork();

            ForkJoinCalculate right = new ForkJoinCalculate(middle+1, end);
            right.fork();

            return left.join() + right.join();
        }
    }

}
