package com.spring.puzzle.class2.example1;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Validated
public class StudentController {


    /**
     *
     * 打破上述两个条件
     * 中的任何一个即可，即让候选项具有优先级或压根可以不去选择。
     */

    @Autowired
    DataService dataService;

    //修改方案：精确匹配名字
/*    @Autowired
    DataService oracleDataService;*/

    @RequestMapping(path = "students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") @Range(min = 1,max = 100) int id){
        dataService.deleteStudent(id);
    };

}
