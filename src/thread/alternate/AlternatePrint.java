package thread.alternate;

import java.util.Objects;
import java.util.concurrent.locks.LockSupport;

/**
 * @author oulei
 * 线程交替打印
 */
public class AlternatePrint {
    public static  Thread a = null;
    public static  Thread b = null;
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        // notifyAndWait();
        lockSupport();
    }


    /**
     * wait notify 方式
     */
    public  static  void notifyAndWait() throws InterruptedException {
        char [] dataOne = "123456".toCharArray();
        char [] dataTwo = "ABCDEF".toCharArray();
        a = new Thread(()->{
            synchronized (object){
                for (char val : dataOne){
                        try {
                            System.out.println(val);
                            object.notify();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                // 使程序可以正常结束
                object.notify();
            }
        });

        b = new Thread(()->{
            synchronized (object){
                for (char val : dataTwo) {
                        try {
                            System.out.println(val);
                            object.notify();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                // 使程序可以正常结束
                object.notify();
            }
        });

        a.start();
        Thread.sleep(1000);
        b.start();
    }



    /**
     * LockSupport方式
     */
    public  static  void  lockSupport() throws InterruptedException {
        char [] dataOne = "123456".toCharArray();
        char [] dataTwo = "ABCDEF".toCharArray();
        a = new Thread(()->{
                for (char val : dataOne){
                    System.out.println(val);
                    LockSupport.unpark(b);
                    LockSupport.park();
                }
            // 让程序结束
            LockSupport.unpark(b);
        });
        b = new Thread(()->{
            for (char val : dataTwo) {
                System.out.println(val);
                LockSupport.unpark(a);
                LockSupport.park();
            }
            // 让程序结束
            LockSupport.unpark(a);
        });

        a.start();
        Thread.sleep(1000);
        b.start();
    }

}
