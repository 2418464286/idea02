package com.hp.controller;

import com.hp.entity.User;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {
@Autowired
    private RestTemplate template;
@Autowired
private DiscoveryClient discoveryClient;
//@GetMapping("/{i}")
//public User getUser(@PathVariable("i") Long id){
// User user=template.getForObject("http://localhost:8081/user"+id,User.class);
//return  user;
//}
//    @GetMapping("/{i}")
//public User getUser(@PathVariable("i") Long id){
// List<ServiceInstance> instanceList=discoveryClient.getInstances("user-service");
//  ServiceInstance serviceInstance=instanceList.get(0);
//  System url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
//  User user=template.getForObject(url,User.class);
//  return user;
//}
@GetMapping("{id}")
public User queryById(@PathVariable("id") Long id) {

    String url="http://user-service/user/"+id;
    User user=template.getForObject(url,User.class);
    return  user;
}


}
