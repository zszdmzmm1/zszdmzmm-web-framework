### 在建立与MySQL连接时的常见问题

1. 利用mybatis进行连接时, 需要引入一个pom依赖：
    ```xml
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>3.0.2</version>
    </dependency>
    ```
   但这还不够，仍需要再加入一个pom：
    ```xml
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.28</version>
    </dependency>
    ```
2. 连接MySQL需要配置url，例如：
    ```text
    url=jdbc:mysql://localhost:3306/db1
   ```
   但大部分情况，这段配置不够完整：可以通过添加参数完成进一步配置，例如添加时区，编码方式：
    ```text
    url=jdbc:mysql://localhost:3306/db1?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8
    ```
   还可以添加另外一些参数：
   ```text
   url=jdbc:mysql://localhost:3306/db1?useSSL=false&allowPublicKeyRetrieval=true
   ```
   仅仅用于使用当连接出现了以上参数的字眼的报错时，就可以选择加入对应的参数解决，或者在一开始就全部加上，防范于未然，例如：
   ```text
   url=jdbc:mysql://localhost:3306/db1?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true
   ```
3. Mybatis与Spring结合时，通常用.properties文件写MySQL配置，但在给属性写key时，不可以直接使用username字样，用spring的默认配置冲突，可以选择改一个名字，例如加上spring_前缀。
   ```text
   spring_username=root
   ```