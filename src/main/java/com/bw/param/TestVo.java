package com.bw.param;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TestVo {

    @NotBlank
    private String msg;

    @NotBlank
    private String id;

}
