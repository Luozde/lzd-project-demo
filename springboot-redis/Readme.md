## Springboot-redis接入步骤

### 1.引入依赖

```xml
<!-- Redis -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

### 2.添加配置内容

在application.yml中添加如下配置：

```yaml
spring:
  # Redis配置
  redis:
    host: 10.173.211.10
    port: 6379
    password: hgrica1@
    database: 11
    expireTime: 86400
    lettuce:
      pool:
        max-wait: 100000
        max-idle: 10
        max-active: 100
    timeout: 1000
```

### 3.添加配置类

```java
@Configuration
@EnableCaching
public class RedisTemplateConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 配置 Redis Template 序列化方式
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(redisSerializer);
        template.setValueSerializer(redisSerializer);
        template.setHashKeySerializer(redisSerializer);
        template.setHashValueSerializer(redisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
```

### 4.测试接入

添加一个测试controller，测试获取Redis下所有的key

```java
/**
 * @author luozhengde
 */
@RestController
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;
    
    @GetMapping("/test")
    public Object test() {
        // 获取所有的Redis key集合
        return redisTemplate.keys("*");
    }
}
```
