add dependency in pom.xml:

<!--        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>-->


unzip the transaction.7z


the related sqls:

/*
CREATE TABLE `student`
        (
        `id`       int(11) NOT NULL AUTO_INCREMENT,
        `realname` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

        CREATE TABLE `course`
        (
        `id`          int(11) NOT NULL AUTO_INCREMENT,
        `course_name` varchar(64) DEFAULT NULL,
        `number`      int(11) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

        CREATE TABLE `student_course`
        (
        `student_id` int(11) NOT NULL,
        `course_id`  int(11) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

        CREATE TABLE `card`
        (
        `id`         int(11) NOT NULL AUTO_INCREMENT,
        `student_id` int(11) DEFAULT NULL,
        `balance`    int(11) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf*/
/*
@Transactional 对 private 方法不生效，所以我们应该把需要支持事务的方法声明为
public 类型；
Spring 处理事务的时候，默认只对 RuntimeException 和 Error 回滚，不会对
Exception 回滚，如果有特殊需要，需要额外声明，例如指明 Transactional 的属性
rollbackFor 为 Exception.class。
*/

/*
Spring 默认的传播属性是 REQUIRED，在有事务状态下执行，如果当前没有事务，则
创建新的事务；
Spring 事务是可以对多个数据源生效，它提供了一个抽象类
AbstractRoutingDataSource，通过实现这个抽象类，我们可以实现自定义的数据库切
换。
*/