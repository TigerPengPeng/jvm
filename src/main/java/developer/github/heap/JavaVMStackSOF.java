package developer.github.heap;

/**
 * @package: developer.github.heap
 * @class:
 * @author: 黄鹏
 * @date: 2016年08月25日 下午9:29
 * @description:
 * VM Args：-XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/MacBookPro/Developer/github/jvm/dump -Xss256k
 *  -XX:+PrintGCDetails: 打印gc详细信息
 *  -XX:+HeapDumpOnOutOfMemoryError: jvm发生OOM的时候,自动生成dump文件
 *  -XX:HeapDumpPath=${dir}: dump文件路径
 *  -Xss256k: 每个线程的stack的大小256k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
