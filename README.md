# Spring Boot + MyBatis + MSSQL + Thymeleaf + Log4jdbc-log4j2

### 1) install maven (in windows 10)

### 2) install MSSQL JDBC library to local maven repository
 
1. download MSSQL JDBC Driver : https://www.microsoft.com/ko-kr/download/details.aspx?id=11774
2. extract MSSQL JDBC Driver and copy file "sqljdbc42.jar" to D:\ <-- example directory
3. execute mvn install
``` bash
mvn install:install-file -Dfile=D:\sqljdbc42.jar -Dpackaging=jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc42 -Dversion=4.2
```
4. register MSSQL JDBC Driver Dependency
```
repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	compile('org.mybatis.spring.boot:mybatis-spring-boot-starter:1.3.1')
	compile('com.microsoft.sqlserver:sqljdbc42:4.2')
.
.
.
```

# Just use "Spring Initializr -> SQL -> SQL Server" ...