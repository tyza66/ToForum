# ToForum
### 吐坛，吐槽专用论坛
<details><summary>登录界面</summary>
<img src="./效果/登录.png"/>
</details>
<details><summary>注册界面</summary>
<img src="./效果/注册.png"/>
</details>
<details><summary>首页</summary>
<img src="./效果/首页.png"/>
</details>
<details><summary>首页鼠标悬停在帖子上</summary>
<img src="./效果/鼠标悬停.png"/>
</details>
<details><summary>标题查询</summary>
<img src="./效果/标题查询.png"/>
</details>
<details><summary>Tag查询</summary>
<img src="./效果/Tag查询.png"/>
</details>
<details><summary>发帖</summary>
<img src="./效果/发帖.png"/>
</details>
<details><summary>帖子中回复</summary>
<img src="./效果/帖子中回复.png"/>
</details>
<details><summary>编辑帖子</summary>
<img src="./效果/编辑帖子.png"/>
</details>
<details><summary>接口数量</summary>
<img src="./效果/接口数量.png"/>
</details>

##### 说明
- SpringBoot全栈项目
- 用户信息管理使用数据库为MySQL
- 论坛中的帖子使用MongoDB存储
- 鉴权和角色管理使用Sa-Token
- 存储在数据库中的用户密码使用SHA-1加密，而不是明文保存
- 使用Knife4j生成后端文档，访问地址为/doc.html
- 使用MyBatisPlus实现查询分页
- 模板引擎使用Thymeleaf
- 权限代码：0->超级管理员、1->普通管理员、2->普通用户
- 发帖和回帖使用MarkDown
- 鼠标悬停在某个帖子上的时候其他帖子会虚化一个度，鼠标点击某个帖子的时候会跳转到该帖子的详情页
- 将每个帖子的每个结构称为贴子体（PostStract），每个帖子由若干个帖子体组成，并且帖子结构使用MongoDB存储
- 预留账号admin，密码admin，权限为超级管理员
- 注册使用的图形验证码使用Hutool的验证码工具产生并且将原文存贮在了Session实现验证码验证
- 主页有点浅丑，后续可以改进一下，先把各种功能罗列出来
- 可以退出登录
- 可以分别使用标题关键字和Tag关键字查询帖子
- 帖子id是生成的UUID，不是自增的
- 帖子体的id 也是生成的uuid
- 发帖需要输入的三个框 一个是标题，一个是Tag，一个是MarkDown编辑器中编辑的帖子内容
- 本来想整个帖子内容的分页，后来不想弄了，所以跳转到帖子详情页的时候那个第二个参数num没什么用
- 回复帖子在帖子列表的最下面，提交成功后会刷新页面，但是滚动条会留在刚刚输入的那个地方
- 删除帖子帖子或者帖子体的时候，只有超级管理员和帖子或帖子体的作者才能删除
- 后台判定是帖子开头还是后面回复的区分方式是看这个帖子体有没有标题，有标题就是帖子开头，没有标题就是回复，删除的时候判断如果有帖子标题，那么就直接删除掉这个帖子
- 前端只注重功能，只是为了把各种功能都罗列出来，不注重美观，后续可以改进一下
- 后端功能比较完善，该有的功能都有
- 下面有直达孙吧（狗头）



##### 使用技术

- 后端：Spring、Spring Boot、MyBatis、MyBatis Plus、Knife4j、Spring-Boot-Data-MongoDB、Thymeleaf、Hutool
- 前端：Vue2.0、ElementUI、Axios、uiverse.io、Editor.md、marked

##### 不足
- 在帖子列表总页码的计算方式中有一点问题，没有考虑到总页数/页码能被整除的情况，导致一旦能被整除的时候就会多出来一个空页。

##### 本地复现

1. 创建数据库表
2. 拉取maven依赖
3. 运行项目
4. 访问localhost:8080体验

By：tyza66(洮羱芝闇)
