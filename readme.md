# java-jdbc-mysql

## 安装mysql依赖

```$xslt
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.22</version>
</dependency>
```

## docker开启一个数据库 

```
docker run --name my-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test1 -p 3306:3306 -d mysql

```

### mysql一些内容 

```
用户名是root，密码是root
```

### 配置flyway

```
<plugin>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-maven-plugin</artifactId>
    <version>5.2.4</version>
    <executions>
        <execution>
            <id>test-database-setup</id>
            <phase>initialize</phase>
            <goals>
                <goal>migrate</goal>
            </goals>
            <configuration>
                <url>jdbc:mysql://localhost:3306/test1</url>
                <user>root</user>
                <password>root</password>
            </configuration>
        </execution>
    </executions>
</plugin>
```

### 执行数据库初始化语句

```$xslt
mvn initialize
```

**此时数据已经灌入了**
