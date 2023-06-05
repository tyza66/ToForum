# ToForum
### 吐坛，吐槽专用论坛
##### 说明
- 现在是开源开发阶段
- SpringBoot全栈项目
- 用户信息管理使用数据库为MySQL
- 论坛中的帖子使用MongoDB存储
- 鉴权和角色管理使用Sa-Token
- 存储在数据库中的用户密码使用SHA-1加密，而不是明文保存
- 使用MyBatisPlus实现查询分页
- 模板引擎使用Thymeleaf
- 权限代码：0->超级管理员、1->普通管理员、2->普通用户
- 发帖和回帖使用MarkDown


##### 使用技术

- 后端：Spring、Spring Boot、MyBatis、MyBatis Plus、Knife4j、Spring-Boot-Data-MongoDB、Thymeleaf、Hutool
- 前端：Vue2.0、ElementUI、Axios

##### 本地复现

1. 创建数据库表
2. 拉取maven依赖
3. 运行项目
4. 访问localhost:8080体验

By：tyza66(洮羱芝闇)