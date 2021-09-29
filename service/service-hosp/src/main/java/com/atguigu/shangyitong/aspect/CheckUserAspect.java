package com.atguigu.shangyitong.aspect;


import com.atguigu.shangyitong.service.HospitalSetService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect //注解声明这是切面
@Component
@Slf4j
public class CheckUserAspect {

    @Autowired
    HospitalSetService hospitalSetService;

    /**
     * @Pointcut("@annotation(com.atguigu.shangyitong.annotation.AdminOnly)")//加入注解表达式 execution(* com.atguigu.shangyitong.service. * . * ( ..))
     * 1.*(任意修饰符) 2. com.atguigu.shangyitong.service.*.(包名)  3. *(..) [任意方法，括号中..为任意形参]
     */
    @Pointcut("execution(* com.atguigu.shangyitong.service.*.*(..))")
    public void checkadmin() throws Exception {
    }

    /**
     * 在执行Pointcut切入点方法之前
     * JointPoint 是连接点,那些可能被拦截到的方法
     * JointPoint打印出来的就是 PointCut增强的连接点中的方法
     *
     * @param joinPoint
     */
    @Before("checkadmin()")
    public void check(JoinPoint joinPoint) {
//        log.info("-----------前置通知----------" + joinPoint);
    }

    /**
     * 在执行Pointcut切入点方法之前
     * JointPoint 是连接点,那些可能被拦截到的方法
     * JointPoint打印出来的就是 PointCut增强的连接点中的方法
     * 无论如何，@After注解生效的方法都会运行，且在最后运行
     *
     * @param joinPoint
     */
    @After("checkadmin()")
    public void after(JoinPoint joinPoint) {
//        log.info("-----------后置通知----------" + joinPoint);
    }


    /**
     * 返回通知：在我们的目标方法正常返回值后运行
     *
     * @param joinPoint
     */
    @AfterReturning(value = "checkadmin()",returning = "userId")
    public void afterReturn(JoinPoint joinPoint,Long userId) {
        log.info("---------------返回通知----------------" + joinPoint +userId);
    }

    /**
     * 异常通知：在我们的目标方法出现异常时运行
     *
     * @param joinPoint
     */
    @AfterThrowing(value = "checkadmin()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("---------------异常通知----------------" + joinPoint + "  " + e.getMessage());
    }


    /**
     * 环绕通知：动态代理，需要手动执行joinPoint.procced()[其实就是执行我们的目标方法之前，相当于前置通知，执行之后，相当于我们的后置通知]
     *
     * @param joinPoint
     */
    @Around(value = "checkadmin()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("---------------环绕通知前----------------" + joinPoint);
        Object obj = joinPoint.proceed();
        log.info("---------------环绕通知后----------------" + joinPoint);
        return obj;
    }

}
