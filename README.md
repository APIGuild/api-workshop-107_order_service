# api-workshop-107_order_service

Build Order-Service  Reference --> Build Eureka-Client

1. add FeignClient dependencies


	compile('org.springframework.cloud:spring-cloud-starter-feign')

2. add annotation to enable FeignClient


    @EnableFeignClients
    
3. use FeignClient invoking remote api


    @FeignClient(value = "user-service")
    public interface UserAgent {
    
        @RequestMapping("/user/{userId}")
        String getUser(@PathVariable("userId") String userId);
    
    }
    
    @FeignClient(name = "product-service")
    public interface ProductAgent {
        @RequestMapping("/product/{productId}")
        public String getProduct(@PathVariable("productId") String productId);
    }
    
    @RestController
    @RequestMapping("/order")
    public class OrderController {
    
        @Autowired
        private UserAgent userAgent;
    
        @Autowired
        private ProductAgent productAgent;
    
        @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
        public String getOrder(@PathVariable("orderId") String orderId) {
            String user = userAgent.getUser("UserA");
            String product = productAgent.getProduct("productA");
            return "This is simple order " + user + " " + product;
        }
    }
    
 4 basic Auth
 
     @Configuration
     public class FeignClientConfiguration {
         @Bean
         public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
              return new BasicAuthRequestInterceptor(username, pwd);
         }
     }
     
     @FeignClient(configuration = FeignClientConfiguration.class)