import java.util.ArrayList;
import java.util.List;



public class test {
    static class OOMObject {
        static byte[] placeholder = new byte[64 * 1024];
    }

    public static void fileHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fileHeap(1000);
    }
}