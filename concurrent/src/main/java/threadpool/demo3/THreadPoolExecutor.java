package threadpool.demo3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class THreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                1,//核心线程数量
                2,//最大线程数量
                60,//空闲时间
                TimeUnit.SECONDS,//空闲时间单位
                new ArrayBlockingQueue<Runnable>(3),//指定队列
                new MyRejectHandler()
        );

        poolExecutor.execute(new Task(1, "任务1"));
        poolExecutor.execute(new Task(2, "任务2"));
        poolExecutor.execute(new Task(3, "任务3"));
        poolExecutor.execute(new Task(4, "任务4"));
        poolExecutor.execute(new Task(5, "任务5"));
        poolExecutor.execute(new Task(6, "任务6"));

        poolExecutor.shutdown();

    }
}
