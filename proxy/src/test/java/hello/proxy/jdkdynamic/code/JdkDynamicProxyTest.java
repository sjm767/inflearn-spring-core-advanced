package hello.proxy.jdkdynamic.code;

import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JdkDynamicProxyTest {

  @Test
  void dynamicA() {
    AInterface target = new AImpl();
    TimeinvocationHandler handler = new TimeinvocationHandler(target);

    AInterface proxy = (AInterface) Proxy.newProxyInstance(
        AInterface.class.getClassLoader(),
        new Class[]{AInterface.class},
        handler);

    proxy.call();
    log.info("targetClass={}", target.getClass());
    log.info("proxyClass={}", proxy.getClass());
  }
  @Test
  void dynamicB() {
    BInterface target = new BImpl();
    TimeinvocationHandler handler = new TimeinvocationHandler(target);

    BInterface proxy = (BInterface) Proxy.newProxyInstance(
        BInterface.class.getClassLoader(),
        new Class[]{BInterface.class},
        handler);

    proxy.call();
    log.info("targetClass={}", target.getClass());
    log.info("proxyClass={}", proxy.getClass());
  }

}
