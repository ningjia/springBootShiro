
# Shiro整合SpringBoot

## 1、集成Shiro的步骤
### 依赖
```text
compile group: 'org.apache.shiro', name: 'shiro-spring', version: '1.3.2'
```
### Shiro配置类
代码参见文件：com.example.springBootShiro.config.ShiroConfig
### 自定义realm类
代码参见文件：com.example.springBootShiro.shiro.CustomRealm
 - 继承AuthorizingRealm类，以便完成权限认证操作;
 - 重写 doGetAuthenticationInfo 和 doGetAuthorizationInfo 两个方法，进行'身份认证'和'授权认证';
    - doGetAuthorizationInfo 方法只有在需要权限认证时才会进入;
    - doGetAuthenticationInfo 方法则是需要身份认证时才会进入;
 - UsernamePasswordToken类: 用于获取登陆时的用户名和密码
    ```java
       token.getUsername()  //获得用户名 String
       token.getPrincipal() //获得用户名 Object 
       token.getPassword()  //获得密码 char[]
       token.getCredentials() //获得密码 Object
    ```
### 编写相应的Controller
如：
用户功能：管理员AdminController、普通用户UserController、游客GuestController
登录/注销功能：LoginController
### 全局异常捕获
代码参见文件：com.example.springBootShiro.controller.ExceptionController
- CustomRealm类中，抛出了AccountException异常
- 使用@RestControllerAdvice注解来捕获异常
### 数据交互
本例中未使用数据库，数据的判断，固化在UserMapper类中。

## 2、Shiro测试地址
http://127.0.0.1:8080/index.html

## 3、其他知识点
### Shiro中的权限拦截Filter
```text
    anon:	无参，开放权限，可以理解为匿名用户或游客
    authc:	无参，需要认证
    logout:	无参，注销，执行后会直接跳转到shiroFilterFactoryBean.setLoginUrl(); 设置的 url
    authcBasic:	无参，表示 httpBasic 认证
    user:	无参，表示必须存在用户，当登入操作时不做检查
    ssl:	无参，表示安全的URL请求，协议为 https
    perms[user]:	参数可写多个，表示需要某个或某些权限才能通过，多个参数时写 perms[“user, admin”]，当有多个参数时必须每个参数都通过才算通过
    roles[admin]:	参数可写多个，表示是某个或某些角色才能通过，多个参数时写 roles[“admin，user”]，当有多个参数时必须每个参数都通过才算通过
    rest[user]:	根据请求的方法，相当于 perms[user:method]，其中 method 为 post，get，delete 等
    port[8081]:	当请求的URL端口不是8081时，跳转到schemal://serverName:8081?queryString 其中 schmal 是协议 http 或 https 等等，serverName 是你访问的 Host，8081 是 Port 端口，queryString 是你访问的 URL 里的 ?后面的参数
```
```text
    anon, authc, authcBasic, user 是第一组认证过滤器;
    perms, port, rest, roles, ssl 是第二组授权过滤器;
    要通过授权过滤器，就先要完成登陆认证操作（即先要完成认证才能前去寻找授权) 才能走第二组授权器;
```
## Refer
- [教你 Shiro 整合 SpringBoot，避开各种坑](https://blog.csdn.net/weixin_38132621/article/details/80216056)
- [SpringBoot整合Shiro_HelloWorld](https://blog.csdn.net/qq_37171353/article/details/78893282)
