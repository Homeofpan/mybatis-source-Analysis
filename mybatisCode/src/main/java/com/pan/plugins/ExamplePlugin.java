package com.pan.plugins;

/**
 * Created by pan tao on 2019/10/19
 **/

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({ @Signature(type = Executor.class,
        method = "query", //这里要对应Executor.class里的方法，下面的参数就是具体方法的参数
        args = { MappedStatement.class, Object.class ,RowBounds.class, ResultHandler.class}) })
public class ExamplePlugin implements Interceptor {
    private Properties properties = new Properties();

    public Object intercept(Invocation invocation) throws Throwable {
        // implement pre processing if need
        System.out.println("============> before method");
        Object returnObject = invocation.proceed();
        // implement post processing if need
        System.out.println("============> after method");
        return returnObject;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}
