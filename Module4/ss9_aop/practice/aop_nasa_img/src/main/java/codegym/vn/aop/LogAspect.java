package codegym.vn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
    private Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Pointcut("execution (* codegym.vn.service.NasaServiceImpl.*(..))")
    public void nasaService() {
    }

    @Before("nasaService()")
    public void writeLogNasaService(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before: " + methodName);
    }

    @Around("execution (* codegym.vn.service.NasaServiceImpl.findAll())")
    public Object writeLogFindAll(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Around before call: " + methodName);
        Object result = joinPoint.proceed();
        logger.info("Around after call: " + methodName);
        return result;
    }

    @AfterThrowing(pointcut = "execution (* codegym.vn.service.NasaServiceImpl.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
