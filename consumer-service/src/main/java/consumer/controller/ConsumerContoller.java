package consumer.controller;

import consumer.client.UserClient;
import consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/consumer")
//通用处理方法必须为无参，因为无法保证所有请求参数一样
//@DefaultProperties(defaultFallback ="defaultFallback")  使用feign   熔断机制和这里不一样
public class ConsumerContoller {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RibbonLoadBalancerClient client;

    @Autowired
    private UserClient userClient;


    //Feign的玩法
    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }

//    //熔断降级处理    1依赖  2启动器注解  3逻辑处理
//    @GetMapping("{id}")
////  @HystrixCommand(fallbackMethod ="queryByIdFallback")
//    @HystrixCommand(
////            commandProperties = {
////            //给服务单独设置超时时长
////            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
////            }
//    )
//    public String queryById(@PathVariable("id") Long id) {
//        String url="http://user-service/user/"+id;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }
//
//    //熔断   单独失败处理方法  返回值，参数列表必须完全一样
//    public String queryByIdFallback(@PathVariable("id") Long id) {
//        return "服务器正忙";
//    }
//
//    public String defaultFallback() {
//        return "服务器正忙";
//    }


//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id){
////  方式一：  String url="http://localhost:8081/user/"+id;
////        User user = restTemplate.getForObject(url, User.class);
////        return user;
//        /**
//         * 根据服务的id  获取服务的实例,从实例中获取实例的ip端口
//         *
//         * 未实现负载均衡( 随机,轮询,hash,最少访问(统计哪个服务访问最少)   )
//         */
////   方式二：     List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
////        ServiceInstance serviceInstance = instances.get(0);
////        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
////        User user = restTemplate.getForObject(url, User.class);
//
////    方式三： 负载均衡  默认是轮询算法
////        ServiceInstance instance = client.choose("user-service");
////        String url="http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
////        User user = restTemplate.getForObject(url, User.class);
//
////     方式四：   在启动类加注解 @LoadBalanced  通过拦截器 LoadBalancerInterceptor
////                在内部实现(实现了ClientHttpRequestInterceptor接口拦截一切http请求)
//        String url="http://user-service/user/"+id;
//        User user = restTemplate.getForObject(url, User.class);
//
//        return user;
//    }

}
