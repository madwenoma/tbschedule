znodes命名规范（草案）：
1、基础服务：/cpbs/应用（服务）名称
2、T服务：/cpts/应用（服务）名称
3、管理系统：/cpms/应用（服务）名称
4、终端App(Web/Mobile)：/cpea/应用（服务）名称

console安装节点：
10.25.23.109、10.25.23.110

console访问地址：
http://10.25.23.232:8009/ScheduleConsole/schedule/index.jsp?manager=true
http://10.25.23.109:8080/ScheduleConsole/schedule/index.jsp?manager=true  --- 单节点
http://10.25.23.110:8080/ScheduleConsole/schedule/index.jsp?manager=true  --- 单节点


demo安装节点：
10.25.23.101、10.25.23.102

maven settings.xml:
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.1.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    
    <servers>
        <server>
            <id>cloudFramework-releases</id>
            <username>admin</username>
            <password>password</password>
        </server>
        <server>
            <id>cloudFramework-snapshots</id>
            <username>admin</username>
            <password>password</password>
        </server>
    </servers>

    <pluginGroups>
    <pluginGroup>org.mortbay.jetty</pluginGroup>
  </pluginGroups>
</settings>
