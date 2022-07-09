package by.it.academy.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@Aspect
@Component
public class ControllerLogAspect extends BaseAspect {
    @Pointcut("execution(* by.it.academy.controllers..*(..))" +
            "&!@annotation(by.it.academy.aspects.ExcludeLog)")
    public void before() {

    }

    @Pointcut("execution(* by.it.academy.controllers..*(..))" +
            "&!@annotation(by.it.academy.aspects.ExcludeLog)")
    public void after() {

    }

    @Before("before()")
    public void logBeforeController(JoinPoint joinPoint) {
        final HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(BEFORE_CONTROLLER_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                getArgsWithNames(joinPoint));
    }

    @AfterReturning(pointcut = "after()", returning = "result")
    public void logAfterController(JoinPoint joinPoint, Object result) {
        final HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(AFTER_CONTROLLER_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                getStringInstanceOf(Optional.ofNullable(result).orElse(" ")),
                getArgsWithNames(joinPoint));
    }
}