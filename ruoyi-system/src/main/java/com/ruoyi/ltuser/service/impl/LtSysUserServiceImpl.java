package com.ruoyi.ltuser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ltuser.mapper.LtSysUserMapper;
import com.ruoyi.ltuser.domain.LtSysUser;
import com.ruoyi.ltuser.service.ILtSysUserService;

/**
 * 系统用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@Service
public class LtSysUserServiceImpl implements ILtSysUserService 
{
    @Autowired
    private LtSysUserMapper ltSysUserMapper;

    /**
     * 查询系统用户
     * 
     * @param id 系统用户主键
     * @return 系统用户
     */
    @Override
    public LtSysUser selectLtSysUserById(Long id)
    {
        return ltSysUserMapper.selectLtSysUserById(id);
    }

    /**
     * 查询系统用户列表
     * 
     * @param ltSysUser 系统用户
     * @return 系统用户
     */
    @Override
    public List<LtSysUser> selectLtSysUserList(LtSysUser ltSysUser)
    {
        return ltSysUserMapper.selectLtSysUserList(ltSysUser);
    }

    /**
     * 新增系统用户
     * 
     * @param ltSysUser 系统用户
     * @return 结果
     */
    @Override
    public int insertLtSysUser(LtSysUser ltSysUser)
    {
        ltSysUser.setCreateTime(DateUtils.getNowDate());
        return ltSysUserMapper.insertLtSysUser(ltSysUser);
    }

    /**
     * 修改系统用户
     * 
     * @param ltSysUser 系统用户
     * @return 结果
     */
    @Override
    public int updateLtSysUser(LtSysUser ltSysUser)
    {
        ltSysUser.setUpdateTime(DateUtils.getNowDate());
        return ltSysUserMapper.updateLtSysUser(ltSysUser);
    }

    /**
     * 批量删除系统用户
     * 
     * @param ids 需要删除的系统用户主键
     * @return 结果
     */
    @Override
    public int deleteLtSysUserByIds(Long[] ids)
    {
        return ltSysUserMapper.deleteLtSysUserByIds(ids);
    }

    /**
     * 删除系统用户信息
     * 
     * @param id 系统用户主键
     * @return 结果
     */
    @Override
    public int deleteLtSysUserById(Long id)
    {
        return ltSysUserMapper.deleteLtSysUserById(id);
    }
}
