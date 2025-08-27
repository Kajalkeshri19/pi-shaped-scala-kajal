package consumer;

import config.RabbitMQConfig;
import model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
    public void receiveOrder(Order order) {
        System.out.println("Consuming OrderPlaced event: " + order);
        // Simulate order fulfillment
        System.out.println("Order fulfilled for: " + order.getCustomerName() + ", Order ID: " + order.getOrderId());
    }
}

