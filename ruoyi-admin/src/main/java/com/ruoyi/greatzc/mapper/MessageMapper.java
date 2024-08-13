package com.ruoyi.greatzc.mapper;

import java.util.List;
import com.ruoyi.greatzc.domain.Message;

/**
 * 站内信Mapper接口
 * 
 * @author Akarin
 * @date 2024-08-14
 */
public interface MessageMapper 
{
    /**
     * 查询站内信
     * 
     * @param id 站内信主键
     * @return 站内信
     */
    public Message selectMessageById(Long id);

    /**
     * 查询站内信列表
     * 
     * @param message 站内信
     * @return 站内信集合
     */
    public List<Message> selectMessageList(Message message);

    /**
     * 新增站内信
     * 
     * @param message 站内信
     * @return 结果
     */
    public int insertMessage(Message message);

    /**
     * 修改站内信
     * 
     * @param message 站内信
     * @return 结果
     */
    public int updateMessage(Message message);

    /**
     * 删除站内信
     * 
     * @param id 站内信主键
     * @return 结果
     */
    public int deleteMessageById(Long id);

    /**
     * 批量删除站内信
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMessageByIds(Long[] ids);
}
