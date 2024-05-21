package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.cinema.Members;

/**
 * 会员Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public interface MembersMapper 
{
    /**
     * 查询会员
     * 
     * @param memberId 会员主键
     * @return 会员
     */
    public Members selectMembersByMemberId(Long memberId);

    /**
     * 查询会员列表
     * 
     * @param members 会员
     * @return 会员集合
     */
    public List<Members> selectMembersList(Members members);

    /**
     * 新增会员
     * 
     * @param members 会员
     * @return 结果
     */
    public int insertMembers(Members members);

    /**
     * 修改会员
     * 
     * @param members 会员
     * @return 结果
     */
    public int updateMembers(Members members);

    /**
     * 删除会员
     * 
     * @param memberId 会员主键
     * @return 结果
     */
    public int deleteMembersByMemberId(Long memberId);

    /**
     * 批量删除会员
     * 
     * @param memberIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMembersByMemberIds(Long[] memberIds);
}
