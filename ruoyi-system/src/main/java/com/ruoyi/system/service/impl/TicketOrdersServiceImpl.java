package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TicketOrdersMapper;
import com.ruoyi.system.domain.TicketOrders;
import com.ruoyi.system.service.ITicketOrdersService;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@Service
public class TicketOrdersServiceImpl implements ITicketOrdersService 
{
    @Autowired
    private TicketOrdersMapper ticketOrdersMapper;

    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    @Override
    public TicketOrders selectTicketOrdersByOrderId(Long orderId)
    {
        return ticketOrdersMapper.selectTicketOrdersByOrderId(orderId);
    }

    /**
     * 查询订单列表
     * 
     * @param ticketOrders 订单
     * @return 订单
     */
    @Override
    public List<TicketOrders> selectTicketOrdersList(TicketOrders ticketOrders)
    {
        return ticketOrdersMapper.selectTicketOrdersList(ticketOrders);
    }

    /**
     * 新增订单
     * 
     * @param ticketOrders 订单
     * @return 结果
     */
    @Override
    public int insertTicketOrders(TicketOrders ticketOrders)
    {
        return ticketOrdersMapper.insertTicketOrders(ticketOrders);
    }

    /**
     * 修改订单
     * 
     * @param ticketOrders 订单
     * @return 结果
     */
    @Override
    public int updateTicketOrders(TicketOrders ticketOrders)
    {
        return ticketOrdersMapper.updateTicketOrders(ticketOrders);
    }

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteTicketOrdersByOrderIds(Long[] orderIds)
    {
        return ticketOrdersMapper.deleteTicketOrdersByOrderIds(orderIds);
    }

    /**
     * 删除订单信息
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    @Override
    public int deleteTicketOrdersByOrderId(Long orderId)
    {
        return ticketOrdersMapper.deleteTicketOrdersByOrderId(orderId);
    }
}
