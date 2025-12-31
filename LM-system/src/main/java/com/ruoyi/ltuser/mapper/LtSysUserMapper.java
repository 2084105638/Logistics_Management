package com.ruoyi.ltuser.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.ltuser.domain.LtSysUser;

/**
 * 系统用户Mapper接口
 *
 * @author ruoyi
 * @date 2025-12-30
 */
public interface LtSysUserMapper extends BaseMapper<LtSysUser> {
    /**
     * 查询系统用户
     *
     * @param id 系统用户主键
     * @return 系统用户
     */
    public LtSysUser selectLtSysUserById(Long id);
    
    /**
     * 查询系统用户列表
     *
     * @param ltSysUser 系统用户
     * @return 系统用户集合
     */
    public List<LtSysUser> selectLtSysUserList(LtSysUser ltSysUser);
    
    /**
     * 新增系统用户
     *
     * @param ltSysUser 系统用户
     * @return 结果
     */
    public int insertLtSysUser(LtSysUser ltSysUser);
    
    /**
     * 修改系统用户
     *
     * @param ltSysUser 系统用户
     * @return 结果
     */
    public int updateLtSysUser(LtSysUser ltSysUser);
    
    /**
     * 删除系统用户
     *
     * @param id 系统用户主键
     * @return 结果
     */
    public int deleteLtSysUserById(Long id);
    
    /**
     * 批量删除系统用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLtSysUserByIds(Long[] ids);
}
