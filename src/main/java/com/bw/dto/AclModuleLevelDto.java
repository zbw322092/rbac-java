package com.bw.dto;

import com.bw.model.SysAclModule;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class AclModuleLevelDto extends SysAclModule {

    private List<AclModuleLevelDto> aclModuleList = Lists.newArrayList();

    public static AclModuleLevelDto adapt(SysAclModule aclModule) {
        AclModuleLevelDto dto = new AclModuleLevelDto();
        BeanUtils.copyProperties(aclModule, dto);
        return dto;
    }
}
