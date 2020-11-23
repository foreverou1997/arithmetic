package design.mode.dynamic.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        Target proxy = (Target) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new DynamicProxyHandler(target));
        proxy.target();
    }
}
