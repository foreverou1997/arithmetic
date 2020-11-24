package design.mode.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object object;
    public DynamicProxyHandler(Object object){
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("目标方法执行之前调用");
        Object obj = method.invoke(object, args);
        System.out.println("目标方法执行之后调用");
        return obj;
    }
}
