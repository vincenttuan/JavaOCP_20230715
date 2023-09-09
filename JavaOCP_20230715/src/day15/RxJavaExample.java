package day15;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaExample {

    public static void main(String[] args) {
        // 创建一个Observable，发出从1到10的整数
        Observable<Integer> observable = Observable.range(1, 10);

        // 使用操作符进行转换和过滤
        observable
            .map(number -> number * 2)  // 将每个数字乘以2
            .filter(result -> result % 4 == 0)  // 仅保留能被4整除的数字
            .observeOn(Schedulers.io())  // 指定观察者运行在IO线程
            .subscribe(
                result -> System.out.println("结果: " + result),  // 订阅者，打印结果
                error -> System.err.println("出错了: " + error),  // 错误处理
                () -> System.out.println("完成")  // 完成事件
            );

        // 在RxJava中，观察者是异步执行的，所以需要等待一段时间以便能够看到结果。
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
