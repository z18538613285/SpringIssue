package com.spring.puzzle.web.validation;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Student {

    @NotEmpty
    @Size(min = 1, max = 10)
    private String name;
    private short age;

    /**
     *要让嵌套校验生效，解决
     * 的方法只有一种，就是加上 @Valid
     */

    @Valid
    private Phone phone;

}

@Data
class Phone {
    @NotEmpty
    @Size(max = 10)
    private String number;
}
