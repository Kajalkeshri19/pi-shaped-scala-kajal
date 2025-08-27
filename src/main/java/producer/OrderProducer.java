package producer;


import config.RabbitMQConfig;
import model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(Order order) {
        System.out.println("Producing OrderPlaced event: " + order);
        rabbitTemplate.convertAndSend(RabbitMQConfig.ORDER_QUEUE, order);
    }
}
