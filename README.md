# OaidDemo
获取oaid的demo，用于获取小米，华为，oppo，vivo等指定系统及以上的oaid，用来替代之前获取的IMEI
目前代码基于《移动智能终端补充设备标识体系统一调用SDK开发者说明文档v1.9》编写，  
官方文档和sdk见MSA官网：http://www.msa-alliance.cn/


## Tips
项目中的相关获取方法的调用，在DevicesUtil.java 工具类中编写，整合了获取oaid，IMEI，AndroidId，UUID等方法。  
**关于获取IMEI：**  
在获取IMEI时，Android 6.0及以上需要手动获取权限，Demo中获取权限的相关方法写在rxpermissions2 文件夹里面了，如需要使用可直接把整个文件夹复制到项目中（使用的是https://github.com/tbruyelle/RxPermissions 中提供的获取权限得方法，仅供参考使用），  
同时需要引用rxJava2.x或者jxJava3.x ，如在build.gradle中添加引用：implementation 'io.reactivex.rxjava3:rxjava:3.0.0-RC3'
如果你集成的其他开源框架已经引用rxJava2.x或rxJava3.x，则不需要再次引用。

## Doc
具体使用流程，请移步csdn博客： https://blog.csdn.net/haovip123/article/details/101679971  
(๑*◡*๑)

