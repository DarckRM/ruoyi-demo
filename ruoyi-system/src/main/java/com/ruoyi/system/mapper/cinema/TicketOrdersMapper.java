package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TicketOrders;

/**
 * 订单Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public interface TicketOrdersMapper 
{
    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    public TicketOrders selectTicketOrdersByOrderId(Long orderId);

    /**
     * 查询订单列表
     * 
     * @param ticketOrders 订单
     * @return 订单集合
     */
    public List<TicketOrders> selectTicketOrdersList(TicketOrders ticketOrders);

    /**
     * 新增订单
     * 
     * @param ticketOrders 订单
     * @return 结果
     */
    public int insertTicketOrders(TicketOrders ticketOrders);

    /**
     * 修改订单
     * 
     * @param ticketOrders 订单
     * @return 结果
     */
    public int updateTicketOrders(TicketOrders ticketOrders);

    /**
     * 删除订单
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    public int deleteTicketOrdersByOrderId(Long orderId);

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTicketOrdersByOrderIds(Long[] orderIds);
}
