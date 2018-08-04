package uk.co.socralogic.java.demo.consumer;
import com.rabbitmq.client.Channel;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;

public class MessageConsumer {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "message.queue", durable = "true"),
                    exchange = @Exchange(value = "message", type = "topic"),
                    key = "#"
            )
    )
    public void onMessage(final Channel channel, final Message message, final MessageEvent messageEvent){

    }
}
