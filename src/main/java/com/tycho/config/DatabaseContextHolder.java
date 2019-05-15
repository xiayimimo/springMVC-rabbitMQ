package com.tycho.config;

//设置消费者需要的数据源
public class DatabaseContextHolder {
    //上下文持有的线程变量里面存放数据源
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setCustomerType(String customerType) {  
        contextHolder.set(customerType);  
    }  
    
    public static String getCustomerType() {  
        return contextHolder.get();  
    }  
    
    public static void clearCustomerType() {  
        contextHolder.remove();  
    }  
}
