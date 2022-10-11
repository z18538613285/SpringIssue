package com.spring.puzzle.class2.example2;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
     * 如果一个类名是以两个大写字母开
     * 头的，则首字母不变，其它情况下默认首字母变成小写。
     */

    @Autowired
    @Qualifier("CassandraDataService")
    DataService dataService;

/*    @Autowired
    @Qualifier("sQLiteDataService")
    DataService dataService;*/

    //修改方案：注意大小写
/*    @Autowired
    @Qualifier("cassandraDataService")
    DataService dataService;*/

    //修改方案：注意大小写
/*    @Autowired
    @Qualifier("SQLiteDataService")
    DataService dataService;*/

    @RequestMapping(path = "students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") @Range(min = 1,max = 100) int id){
        dataService.deleteStudent(id);
    };

}
