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

    public static void main(String[] args) {
        notifyAndWait();
    }



    public  static  void notifyAndWait(){
        char [] dataOne = "123456".toCharArray();
        char [] dataTwo = "ABCDEF".toCharArray();
        a = new Thread(()->{
            for (char val : dataOne){
                synchronized (object){
                    try {
                        System.out.println(val);
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        b = new Thread(()->{
            for (char val : dataTwo) {
                synchronized (object){
                    try {
                        object.wait();
                        System.out.println(val);
                        object.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        a.start();
        b.start();
    }



    /**
     * LockSupport方式
     */
    public  static  void  lockSupport(){
        char [] dataOne = "123456".toCharArray();
        char [] dataTwo = "ABCDEF".toCharArray();
        a = new Thread(()->{
                for (char val : dataOne){
                    System.out.println(val);
                    LockSupport.unpark(b);
                    LockSupport.park();
                }
        });
        b = new Thread(()->{
            for (char val : dataTwo) {
                LockSupport.park();
                System.out.println(val);
                LockSupport.unpark(a);
            }
        });

        a.start();
        b.start();
    }

}
