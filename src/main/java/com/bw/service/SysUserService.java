package com.bw.service;

import com.bw.dao.SysUserMapper;
import com.bw.exception.ParamException;
import com.bw.model.SysUser;
import com.bw.param.UserParam;
import com.bw.util.BeanValidator;
import com.bw.util.MD5Util;
import com.bw.util.PasswordUtil;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
        sysUser.setOperator("system"); // todo
        sysUser.setOperateIp("127.0.0.1"); // todo
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
        sysUserMapper.updateByPrimaryKeySelective(after);
    }


    public boolean checkEmailExist(String mail, Integer userId) {
        return false;
    }

    public boolean checkTelephoneExist(String mail, Integer userId) {
        return  false;
    }
}
