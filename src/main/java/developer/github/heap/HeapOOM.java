package developer.github.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: developer.github.heap
 * @class:
 * @author: 黄鹏
 * @date: 2016年08月25日 下午8:12
 * @description:
 * VM Args：-XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/MacBookPro/Developer/github/jvm/dump -Xms20m -Xmx20m
 *  -XX:+PrintGCDetails: 打印gc详细信息
 *  -XX:+HeapDumpOnOutOfMemoryError: jvm发生OOM的时候,自动生成dump文件
 *  -XX:HeapDumpPath=${dir}: dump文件路径
 *  -Xms20m: 堆最小值为20M
 *  -Xmx20m: 堆最大值为20M
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}

