package com.bw.service;

import com.bw.beans.PageQuery;
import com.bw.beans.PageResult;
import com.bw.common.RequestHolder;
import com.bw.dao.SysUserMapper;
import com.bw.exception.ParamException;
import com.bw.model.SysUser;
import com.bw.param.UserParam;
import com.bw.util.BeanValidator;
import com.bw.util.IpUtil;
import com.bw.util.MD5Util;
import com.bw.util.PasswordUtil;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    public void save(UserParam param) {
        BeanValidator.check(param);
        if (checkTelephoneExist(param.getTelephone(), param.getId())) {
            throw new ParamException("电话已被占用");
        }

        if (checkEmailExist(param.getMail(), param.getId())) {
            throw new ParamException("邮箱已被占用");
        }

        String password = PasswordUtil.randomPassword();
        String encryptedPassword = MD5Util.encrypt(password);

        SysUser sysUser = SysUser.builder().username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail()).
                password(encryptedPassword).deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        sysUser.setOperator(RequestHolder.getCurrentUser().getUsername());
        sysUser.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        sysUser.setOperateTime(new Date()); // todo

        // TODO sendemail

        sysUserMapper.insertSelective(sysUser);
    }

    public void update(UserParam param) {
        if (checkTelephoneExist(param.getTelephone(), param.getId())) {
            throw new ParamException("电话已被占用");
        }

        if (checkEmailExist(param.getMail(), param.getId())) {
            throw new ParamException("邮箱已被占用");
        }
        SysUser before = sysUserMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的用户不存在");
        SysUser after = SysUser.builder().id(param.getId()).username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail()).
                deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        after.setOperator(RequestHolder.getCurrentUser().getUsername());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date()); // todo
        sysUserMapper.updateByPrimaryKeySelective(after);
    }


    public boolean checkEmailExist(String mail, Integer userId) {
        return sysUserMapper.countByMail(mail, userId) > 0;
    }

    public boolean checkTelephoneExist(String telephone, Integer userId) {
        return  sysUserMapper.countByTelephone(telephone, userId) > 0;
    }

    public SysUser findByKeyword(String keyword) {
        return sysUserMapper.findByKeyword(keyword);
    }

    public PageResult<SysUser> getPageByDeptId(int deptId, PageQuery page) {
        BeanValidator.check(page);
        int count = sysUserMapper.countByDeptId(deptId);
        if (count > 0) {
            List<SysUser> list = sysUserMapper.getPageByDeptId(deptId, page);
            return PageResult.<SysUser>builder().total(count).data(list).build();
        }
        return PageResult.<SysUser>builder().build();
    }
}
