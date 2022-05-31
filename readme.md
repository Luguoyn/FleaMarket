# FleaMarket
suda软工实践-二手交易平台

## 使用的技术
- [springboot](https://github.com/spring-projects/spring-boot)
- [mybatis-plus](https://github.com/baomidou/mybatis-plus)
- [lombok](https://github.com/spring-projects/spring-boot)
- [Druid](https://github.com/alibaba/druid)
- JWT

# FleaMarket接口

## 实体

### User

| 参数      | 说明     |
| --------- | -------- |
| id        | 用户id   |
| name      | 用户昵称 |
| authority | 用户权限 |
| birthday  | 用户生日 |
| gander    | 用户性别 |
| address   | 用户地址 |
| telephone | 用户电话 |
| email     | 用户邮箱 |
| isDeleted | 无效字段 |

### Goods

| 参数              | 说明                     |
| ----------------- | ------------------------ |
| id                | 商品id                   |
| userId            | 发布者id                 |
| name              | 商品名称                 |
| releaseTime       | 发布时间                 |
| remainingQuantity | 余量                     |
| price             | 价格                     |
| picture           | 商品图片URL              |
| description       | 商品描述                 |
| isApproved        | 是否已审核, 1为是, 0为否 |
| isDeleted         | 无效字段                 |
| version           | 无效字段                 |

### Security

| 参数      | 说明                 |
| --------- | -------------------- |
| id        | 无效字段             |
| userId    | 用户id               |
| loginName | 登录名, 与昵称不一样 |
| password  | 密码                 |
| isDeleted | 无效字段             |

### Order

| 参数       | 说明                             |
| ---------- | -------------------------------- |
| id         | 订单id                           |
| userId     | 买家id                           |
| goodId     | 商品id                           |
| createTime | 订单创建时间                     |
| amount     | 购买数量                         |
| price      | 下单时价格                       |
| isFinished | 是否交易成功, 成功为1, 未成功为0 |
| isDeleted  | 无效字段                         |

### Star

| 参数      | 说明     |
| --------- | -------- |
| id        | 无效字段 |
| userId    | 收藏者id |
| goodId    | 商品id   |
| isDeleted | 无效字段 |

## 接口

本项目全用POST接口

### User

#### /user/info/{userId}

获取指定用户信息

request:

| 参数   | 是否必须 | 说明     |
| ------ | -------- | -------- |
| userID | 是       | 用户的id |

response:

| 参数     | 说明     |
| -------- | -------- |
| User实体 | User实体 |

#### /user/update

需要token, 更新自己的信息

request:

| 参数      | 是否必须 | 说明     |
| --------- | -------- | -------- |
| name      | 是       | 用户昵称 |
| birthday  | 否       | 生日     |
| gander    | 是       | 性别     |
| address   | 否       | 地址     |
| telephone | 否       | 手机     |
| email     | 否       | 邮箱     |

### Goods

#### /goods/list   /goods/list/p/{index}  /goods/list-u/{userId}  /goods/list-u/{userId}/p/{index}

获取商品列表

response

| 参数            | 说明   |
| --------------- | ------ |
| List<Goods实体> | 商品表 |

#### /goods/info/{id}

response

| 参数      | 说明     |
| --------- | -------- |
| Goods实体 | 商品信息 |

#### /goods/publish

需要token, 用于发布商品

request

| 参数              | 是否必须 | 说明     |
| ----------------- | -------- | -------- |
| name              | 是       | 商品名称 |
| picture           | 否       | 图片URL  |
| description       | 否       | 商品描述 |
| remainingQuantity | 是       | 商品余量 |
| price             | 是       | 商品价格 |

#### /goods/delete/{id}

需要Token, 用于删除商品

#### /goods/select

用于查找商品

request

| 参数     | 是否必须 | 说明         |
| -------- | -------- | ------------ |
| name     | 否       | 商品名       |
| userId   | 否       | 商品发布者id |
| maxPrice | 否       | 商品最大价格 |
| minPrice | 否       | 商品最小价格 |

response

| 参数            | 说明   |
| --------------- | ------ |
| List<Goods实体> | 商品表 |

### Security

#### /security/login  /security/register

用户的登陆或注册

request

| 参数      | 是否必须 | 说明     |
| --------- | -------- | -------- |
| loginName | 是       | 登录账号 |
| password  | 是       | 密码     |

response

| 参数  | 说明                    |
| ----- | ----------------------- |
| token | 用户token, 放在header中 |

/security/update

request

| 参数        | 是否必须 | 说明   |
| ----------- | -------- | ------ |
| password    | 是       | 旧密码 |
| newPassword | 是       | 新密码 |

response

| 参数  | 说明                    |
| ----- | ----------------------- |
| token | 用户token, 放在header中 |

### Order

全部需要token

#### /order/list

返回用户自己下过的订单

response

| 参数            | 说明   |
| --------------- | ------ |
| List<Order实体> | 订单表 |

#### /order/place

下订单

request

| 参数   | 是否必须 | 说明     |
| ------ | -------- | -------- |
| goodId | 是       | 商品id   |
| amount | 是       | 购买数量 |

#### /order/cancel

删除订单

request

| 参数    | 是否必须 | 说明     |
| ------- | -------- | -------- |
| orderId | 是       | 订单的id |

#### /order/confirm

确认订单(确认后无法删除)

request

| 参数    | 是否必须 | 说明     |
| ------- | -------- | -------- |
| orderId | 是       | 订单的id |

### Star

全部需要token

#### /star/list

获取收藏列表

response

| 参数            | 说明   |
| --------------- | ------ |
| List<Goods实体> | 商品表 |

#### /star/add /star/remove

收藏/取消收藏

request

| 参数   | 是否必须 | 说明     |
| ------ | -------- | -------- |
| goodId | 是       | 商品的id |

### Admin

全部都要token

#### /admin/list-n  /admin/list-u/{userId}  /admin/list-n/p/{index}  /admin/list-u/{userId}/p/{index}

获取商品列表

response

| 参数            | 说明   |
| --------------- | ------ |
| List<Goods实体> | 商品表 |

#### /admin/approve/{goodId}  /admin/anti-approve/{goodId}

审核商品

#### /admin/authority

设置用户权限

request

| 参数      | 是否必须 | 说明     |
| --------- | -------- | -------- |
| userId    | 是       | 用户id   |
| authority | 是       | 用户权限 |

