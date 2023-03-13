通过Maven骨架可以快速搭建工程。
<a name="t9ApE"></a>
# 一、自定义骨架（本地）
<a name="GTmBq"></a>
## 1.1 使用前准备 
使用前准备
<a name="CeVdq"></a>
### 1.1.0 准备并配置好maven
这是理所应当的。
<a name="BM1nR"></a>
### 1.1.1 下载maven官方xml到本地
下载地址：[https://repo.maven.apache.org/maven2/archetype-catalog.xml](https://repo.maven.apache.org/maven2/archetype-catalog.xml)<br />下载完后将xml放入本地：<本地maven仓库>\org\apache\maven\archetype\archetype-catalog\3.2.1<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/2475288/1678708727828-4187489f-6918-4206-a7d1-472da42b6e8f.png#averageHue=%23fbfaf9&clientId=u47ed04e0-4648-4&from=paste&height=303&id=ub2ccef25&name=image.png&originHeight=303&originWidth=993&originalType=binary&ratio=1&rotation=0&showTitle=false&size=41190&status=done&style=none&taskId=u841fe895-5111-456f-bf18-6821a2fc51d&title=&width=993)<br />这一步的作用是为 maven-archetype-plugin 提供服务，如果没有xml，仓库会到私服或官服去拉取骨架配置，导致本地配置不一致，加载失败。
<a name="hzNHq"></a>
### 1.1.2 maven 指定本地骨架
在IDEA 的 Maven-Runner 配置中增加 -DarchetypeCatalog=local 语句<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/2475288/1678708789516-bb1b4a43-9b65-43a4-8c26-e7242e516070.png#averageHue=%23f1f4f8&clientId=u47ed04e0-4648-4&from=paste&height=730&id=u70109bbe&name=image.png&originHeight=730&originWidth=999&originalType=binary&ratio=1&rotation=0&showTitle=false&size=96378&status=done&style=none&taskId=u2217147f-14bd-43f8-a8ee-b84cca55b1b&title=&width=999)
<a name="VOwbU"></a>
## 1.2 生成自定义骨架
<a name="LbpZW"></a>
### 1.2.1 引入骨架依赖
在项目的根pom中引入骨架插件，第1.1.1步的 archetype-catalog.xml 就是为此服务的。
```xml
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
<a name="hjnQD"></a>
### 1.2.2 打包并安装
1、进入项目根目录，执行命令 mvn archetype:create-from-project，打包骨架，打包后会在项目根目录生成target文件夹。<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/2475288/1678713654756-ddbdfc1a-60b6-45f6-8a3e-c765a733e09e.png#averageHue=%23fbf9f6&clientId=u47ed04e0-4648-4&from=paste&height=97&id=u89b711ff&name=image.png&originHeight=97&originWidth=882&originalType=binary&ratio=1&rotation=0&showTitle=true&size=13742&status=done&style=none&taskId=udfee7719-4001-46ed-bb1e-cf5b1f67b17&title=%E8%BF%9B%E5%85%A5%E6%8C%87%E5%AE%9A%E7%9B%AE%E5%BD%95%E6%89%A7%E8%A1%8Cmvn%20install&width=882 "进入指定目录执行mvn install")<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/2475288/1678709131388-b021dbe8-7b32-48da-8528-e2dfb32482a8.png#averageHue=%23eef2f7&clientId=u47ed04e0-4648-4&from=paste&height=321&id=ua6591d9b&name=image.png&originHeight=321&originWidth=459&originalType=binary&ratio=1&rotation=0&showTitle=true&size=29192&status=done&style=none&taskId=ub23f864b-d756-481e-ab92-6ba800ef6a3&title=%E7%94%9F%E6%88%90target%E7%9B%AE%E5%BD%95&width=459 "生成target目录")<br />2、进入target目录，具体为：<项目根目录>\target\generated-sources\archetype，执行 mvn install 安装。<br />安装好后会显示骨架的安装位置：<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/2475288/1678709194114-c174b30c-78e2-463a-bcc3-f4b46b8443a8.png#averageHue=%23faf8f5&clientId=u47ed04e0-4648-4&from=paste&height=141&id=u9dc374e5&name=image.png&originHeight=141&originWidth=1892&originalType=binary&ratio=1&rotation=0&showTitle=false&size=42456&status=done&style=none&taskId=ub39a1788-0df5-4663-9ac5-bc2632cd3f8&title=&width=1892)
<a name="sT1Qh"></a>
## 1.3 使用骨架
<a name="wqygU"></a>
### 1.3.1 骨架信息
进入刚刚安装好骨架的目录，我这里是：\org\example\monomer-demo-archetype\1.0-SNAPSHOT，找到骨架描述文件：maven-metadata-local.xml，打开该文件，可以看到骨架的描述信息：

- groupId
- artifactId
- version

记住这三个东东，准备使用骨架
<a name="ekKIj"></a>
### 1.3.2 使用骨架
创建项目时使用骨架，自定义骨架一般需要添加<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/2475288/1678709534357-e265107d-1620-4de0-8875-8656ae5a3618.png#averageHue=%23f3f5f8&clientId=u47ed04e0-4648-4&from=paste&height=802&id=u5d07b4b5&name=image.png&originHeight=802&originWidth=949&originalType=binary&ratio=1&rotation=0&showTitle=false&size=91473&status=done&style=none&taskId=u9c674453-db63-4e19-8f4b-9ff9bb558c7&title=&width=949)
