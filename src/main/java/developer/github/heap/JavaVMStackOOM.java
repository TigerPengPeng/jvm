package developer.github.heap;

/**
 * @package: developer.github.heap
 * @class:
 * @author: 黄鹏
 * @date: 2016年08月25日 下午9:39
 * @description:
 * VM Args：-XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/MacBookPro/Developer/github/jvm/dump -Xms1024m -Xss10M
 *  -XX:+PrintGCDetails: 打印gc详细信息
 *  -XX:+HeapDumpOnOutOfMemoryError: jvm发生OOM的时候,自动生成dump文件
 *  -XX:HeapDumpPath=${dir}: dump文件路径
 *  -Xms1024m: 堆最小值为1024M
 *  -Xss10M: 每个线程的stack的大小10M
 */
public class JavaVMStackOOM {

    private void notStop() {
        while (true) {}
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    notStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
