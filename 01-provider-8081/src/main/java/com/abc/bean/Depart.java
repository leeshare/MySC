package com.abc.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
//@Entity(name="t_depart")
@Entity     //使用默认名自动建表
// HttpMessageConverter   Jackson -> 完成java对象与JSON数据间的转换工作
// JPA 的默认实现是 Hibernate， 而Hibernate默认对于对象的查询是基于延迟加载的
// Depart depart = service.findById(5); //只有访问详情时，才去执行select    这里的 depart是一个 javasist 动态代理对象
            //在访问详情前，depart实际是空的
// String name = depart.getName()    //这句才叫访问详情。
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})      //味了防止报错
public class Depart {

    @Id     //表示当前属性为自动建表的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
