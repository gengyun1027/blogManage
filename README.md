# blogManage

页面展示：

- <img src="D:/markdown/Typora/images/1661672506520.png" alt="1661672506520" style="zoom: 50%;" />

系统架构图：

- <img src="D:/markdown/Typora/images/1661672462880.png" alt="1661672462880" style="zoom: 67%;" />

博客管理系统主要包括博客的发布、浏览、评论以及后台信息管理以及用户的权限管理等基本功能。

技术栈：SpringBoot、Vue、Mybatis-Plus、spring security(安全认证)

技术亮点：

- jwt+redis
  -  使用token令牌的登录方式，访问认证的速度快，安全性高。
  - 使用redis做了令牌和用户信息的对应管理，进一步增加安全性，对登录用户做了缓存，灵活控制用户的过期
- threadlocal
  - 使用threadLocal保存了用户信息管理，请求的线程之内，可以随时获取登录的用户，做了线程隔离。
  - 使用完threadLocal后，做了value的删除，防止内存泄漏
- 乐观锁
  - 在阅读数量更新时，引入乐观锁，update table set value = newValue where value=oldValue;
- 线程池（对当前主业务流程无影响的操作，放入线程池中执行）
  - 记录日志
- 统一缓存处理

网址：www.gengyun.icu