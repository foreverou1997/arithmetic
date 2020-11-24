package design.mode.dynamic.proxy;

public class TargetImpl implements  Target {
    @Override
    public void target() {
        System.out.println("执行目标方法");
    }
}
