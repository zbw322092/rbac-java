package com.bw.dao;

import com.bw.model.SysRoleUser;

public interface SysRoleUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int insert(SysRoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int insertSelective(SysRoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    SysRoleUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int updateByPrimaryKeySelective(SysRoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int updateByPrimaryKey(SysRoleUser record);
}