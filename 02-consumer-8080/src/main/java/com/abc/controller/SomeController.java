package com.abc.controller;

import com.abc.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/depart")
//@RequestMapping("/depart/")       //正常这样写就行
public class SomeController {

    //注入一个 RestTemplate     使用的是 DepartCodeConfigure 中的 restTemplate
    @Autowired
    private RestTemplate restTemplate;

    //直连提供者
    //private static final String SERVICE_PROVIDER = "http://localhost:8081";
    // 要使用微服务名称来从 eureka server查找提供者
    private static final String SERVICE_PROVIDER = "http://abcmysc-provider-depart";

    @PostMapping("/save")
    //@PostMapping          //正常这样写就行
    public boolean saveHandler(@RequestBody Depart depart) {
        String url = SERVICE_PROVIDER + "/provider/depart/save";
        return restTemplate.postForObject(url, depart, Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandler(@PathVariable("id") int id) {
        String url = SERVICE_PROVIDER + "/provider/depart/del/" + id;
        restTemplate.delete(url);
    }

    @PutMapping("/update")
    public void updateHandler(@RequestBody Depart depart) {
        String url = SERVICE_PROVIDER + "/provider/depart/update";
        restTemplate.put(url, depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandler(@PathVariable("id") int id) {
        String url = SERVICE_PROVIDER + "/provider/depart/get/" + id;
        return restTemplate.getForObject(url, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandler() {
        String url = SERVICE_PROVIDER + "/provider/depart/list";
        return restTemplate.getForObject(url, List.class);
    }

}
