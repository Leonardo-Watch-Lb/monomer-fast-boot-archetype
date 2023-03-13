# monomer-boot
快速搭建单体架构

用于快速搭建单体应用的maven骨架

通过Maven骨架可以快速搭建工程。
一、自定义骨架（本地）
1.1 使用前准备 
使用前准备
1.1.0 准备并配置好maven
这是理所应当的。
1.1.1 下载maven官方xml到本地
下载地址：https://repo.maven.apache.org/maven2/archetype-catalog.xml
下载完后将xml放入本地：<本地maven仓库>\org\apache\maven\archetype\archetype-catalog\3.2.1

这一步的作用是为 maven-archetype-plugin 提供服务，如果没有xml，仓库会到私服或官服去拉取骨架配置，导致本地配置不一致，加载失败。
1.1.2 maven 指定本地骨架
在IDEA 的 Maven-Runner 配置中增加 -DarchetypeCatalog=local 语句

1.2 生成自定义骨架
1.2.1 引入骨架依赖
在项目的根pom中引入骨架插件，第1.1.1步的 archetype-catalog.xml 就是为此服务的。
```java
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-archetype-plugin</artifactId>
      <version>3.2.1</version>
    </plugin>
  </plugins>
</build>
```
1.2.2 打包并安装
1、进入项目根目录，执行命令 mvn archetype:create-from-project，打包骨架，打包后会在项目根目录生成target文件夹。


2、进入target目录，具体为：<项目根目录>\target\generated-sources\archetype，执行 mvn install 安装。
安装好后会显示骨架的安装位置：

1.3 使用骨架
1.3.1 骨架信息
进入刚刚安装好骨架的目录，我这里是：\org\example\monomer-demo-archetype\1.0-SNAPSHOT，找到骨架描述文件：maven-metadata-local.xml，打开该文件，可以看到骨架的描述信息：
● groupId
● artifactId
● version
记住这三个东东，准备使用骨架
1.3.2 使用骨架
创建项目时使用骨架，自定义骨架一般需要添加
