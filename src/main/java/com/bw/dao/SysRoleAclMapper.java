package com.bw.dao;

import com.bw.model.SysRoleAcl;

public interface SysRoleAclMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int insert(SysRoleAcl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int insertSelective(SysRoleAcl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    SysRoleAcl selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int updateByPrimaryKeySelective(SysRoleAcl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int updateByPrimaryKey(SysRoleAcl record);
}