package com.tycho.rabbitmq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

/**
 * 消息生产者
 * 
 */
public class MsgSender {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:rabbitmq-context.xml");
        //RabbitMQ模板
        RabbitTemplate template = (RabbitTemplate) ctx.getBean(RabbitTemplate.class);

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        //发送消息
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("type", "1");
        msg.put("date", date);
        msg.put("test", "这是一条测试消息");
        /**消息内容
                          方案：
        1、消息内容使用对象做json序列化发送  alibaba   json工具
        a)数据大
        b)有些数据其他人是可能用不到的
        2、发送特定的业务字段，如id、操作类型
        */
        template.convertAndSend("type2", JSON.toJSONString(msg));
        Thread.sleep(1000);// 休眠1秒
        ctx.destroy(); //容器销毁
//        ctx.close();
    }
}
