package com.bw.dao;

import com.bw.model.SysAcl;

public interface SysAclMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int insert(SysAcl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int insertSelective(SysAcl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    SysAcl selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int updateByPrimaryKeySelective(SysAcl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl
     *
     * @mbg.generated Sun Mar 18 23:30:03 CST 2018
     */
    int updateByPrimaryKey(SysAcl record);
}