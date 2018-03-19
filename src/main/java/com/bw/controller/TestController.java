package com.bw.controller;

import com.bw.common.ApplicationContextHelper;
import com.bw.common.JsonData;
import com.bw.dao.SysAclModuleMapper;
import com.bw.exception.PermissionException;
import com.bw.model.SysAclModule;
import com.bw.param.TestVo;
import com.bw.util.BeanValidator;
import com.bw.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello() {
        log.info("Hello There");
        throw new RuntimeException("test exception");
//        return JsonData.success("hello");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) {
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }

}
