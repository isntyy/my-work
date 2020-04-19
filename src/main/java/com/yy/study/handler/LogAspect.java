package com.yy.study.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yy.study.bean.AuditBean;
import com.yy.study.bean.AuditRouteSearchBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志记录
 *
 * @author wyy
 * @since 2020-04-12 22:13
 */
@Component
@Aspect
public class LogAspect {

    private static String METHOD_GET = "GET";

    /**
     * 只拦截controller
     * 1. 第一个 * 代表任意修饰符及返回值
     * 2. 第二个 * 定义在web包或者子包
     * 3. 第三个 * 任意方法
     */
    @Pointcut("execution(* com.yy.study.controller..*.*(..))")
    public void logPoint() {
    }

    @Around("logPoint()")
    public Object aroundExec(ProceedingJoinPoint joinPoint) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        // 请求方式
        String method = request.getMethod();
        // 请求地址
        String url = request.getRequestURI();
        // 此处会执行具体的url请求，并将方法返回值返回
        Object proceed = joinPoint.proceed();

        // 以下为具体记录审计逻辑，根据需求
        AuditRouteSearchBean bean = new AuditRouteSearchBean();
        bean.setMethod(method);
        bean.setUrl(url);
        // 查看该请求是否存在表中，存在则需要记录审计日志
        // todo 具体实现
        boolean falg = true;
        if (falg) {
            // 接口返回结果转为map
            Map<String, Object> params = JSONObject.parseObject(JSONObject.toJSONString(proceed),
                    new TypeReference<Map<String, Object>>() {
                    });
            // 新建审计对象信息实体
            AuditBean auditBean = new AuditBean();
            auditBean.setMethod(method);
            auditBean.setUrl(url);
            // 处理请求参数
            if (METHOD_GET.endsWith(method)) {
                params.putAll(request.getParameterMap());
            } else {
                Object[] args = joinPoint.getArgs();
                Map map = new HashMap();
                // 获取请求参数进行拼接
                if (args.length > 0) {
                    Object object = args[0];
                    map = getKeyAndValue(object);
                }
                params.putAll(map);
            }
            // todo 具体业务逻辑，将审计信息写入数据库

        }

        return proceed;
    }

    /**
     * 参数组装成map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null){
            return null;
        }
        Class<?> usercla = obj.getClass();
        // 得到类中所有字段属性
        Field[] fs = usercla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            // 设置属性可访问
            f.setAccessible(true);
            Object val = new Object();
            try {
                val = f.get(obj);
                // 得到此属性的值
                map.put(f.getName(),val);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
