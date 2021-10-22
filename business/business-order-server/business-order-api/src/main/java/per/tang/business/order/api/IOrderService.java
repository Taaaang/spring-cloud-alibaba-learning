package per.tang.business.order.api;

import per.tang.business.order.api.entity.Order;

public interface IOrderService {

    /**
     * 查询订单信息
     * @param orderId 订单编号
     * @return 订单信息
     */
    Order getOrder(Long orderId);


    /**
     * 测试nacos的config
     * @return
     */
    String testRemoteConfig();

}
