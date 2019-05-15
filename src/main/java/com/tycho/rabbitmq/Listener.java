package com.tycho.rabbitmq;

/**
 * 消息 消费者
 * @author admin
 *
 */
public class Listener {
	public void listen(String msg) {
        System.out.println("\n消费者B开始处理消息： " + msg + "\n");
    }
}
