### 网吧机房管理系统(图片加载不出来，请挂tizi)

> 实现系统的不同权限登录、账号信息管理、会员服务等功能。并要求通过该系统实现对服务端数据库的数据进行增删修改操作。

![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%871.png)

- 功能介绍：
  	实现上机登记、下机、查询、加钱等功能

- 身份简介：
  	两种身份：
  	管理员：后台管理和维护系统
  	普通上机人员：使用电脑

- 机房简介：
  	总共1间机房，最多容纳100人，全天开放

- 系统需求：
  	进去登录界面，可选择
  		普通登录（包括会员）
  		管理员登录

  ​	![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%872.png)

  - ~~普通登录~~：
    		查看剩余时间
    		加钱--给当前账号增加上机时间
    		（会员）查看会员卡余额
    		下机--非会员客户达到约定时间强制退出登录
    		          会员客户超过约定时间自动扣除会员卡金额，若卡里金额不够，也会强制退出

  - 管理员登录：

    - 添加账号--添加上机账号

    ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%873.png)

    ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%874.png)

    - 注册会员--添加会员账号

    ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%877.png)

    ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%878.png)

    ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%876.png)

    - 查看账号--查看所有非管理员账号信息

    ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%8710.png)

    - 查看机房--查看机房机器的状态

    ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%8711.png)

    - 查询：

      ​	顾客

      ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%8712.png)

      ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%8713.png)

      ​	电脑

      ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%8714.png)

      ​		![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%8715.png)

    - 注销登录--退出登录

      ![img](https://github.com/xiaoyoumax/Images/blob/main/IBMS/%E5%9B%BE%E7%89%8716.png)

