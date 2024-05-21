package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MembersMapper;
import com.ruoyi.system.domain.cinema.Members;
import com.ruoyi.system.service.IMembersService;

/**
 * 会员Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@Service
public class MembersServiceImpl implements IMembersService 
{
    @Autowired
    private MembersMapper membersMapper;

    /**
     * 查询会员
     * 
     * @param memberId 会员主键
     * @return 会员
     */
    @Override
    public Members selectMembersByMemberId(Long memberId)
    {
        return membersMapper.selectMembersByMemberId(memberId);
    }

    /**
     * 查询会员列表
     * 
     * @param members 会员
     * @return 会员
     */
    @Override
    public List<Members> selectMembersList(Members members)
    {
        return membersMapper.selectMembersList(members);
    }

    /**
     * 新增会员
     * 
     * @param members 会员
     * @return 结果
     */
    @Override
    public int insertMembers(Members members)
    {
        return membersMapper.insertMembers(members);
    }

    /**
     * 修改会员
     * 
     * @param members 会员
     * @return 结果
     */
    @Override
    public int updateMembers(Members members)
    {
        return membersMapper.updateMembers(members);
    }

    /**
     * 批量删除会员
     * 
     * @param memberIds 需要删除的会员主键
     * @return 结果
     */
    @Override
    public int deleteMembersByMemberIds(Long[] memberIds)
    {
        return membersMapper.deleteMembersByMemberIds(memberIds);
    }

    /**
     * 删除会员信息
     * 
     * @param memberId 会员主键
     * @return 结果
     */
    @Override
    public int deleteMembersByMemberId(Long memberId)
    {
        return membersMapper.deleteMembersByMemberId(memberId);
    }
}
