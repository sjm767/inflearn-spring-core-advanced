package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 구조를 변경 (분리)
 */
@Slf4j
@Component
public class CallServiceV3 {

  private final InternalService internalService;

  @Autowired
  public CallServiceV3(InternalService internalService) {
    this.internalService = internalService;
  }

  public void external() {
    log.info("call external");
    internalService.internal();
  }



}
