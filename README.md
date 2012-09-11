This is a sample project demonstrating use of Spring, Apache Shiro, Hibernate, and JavaScriptMVC.

# Getting Started

## Dev Environment Setup

* Create folder C:\Programs
* Download and Install Java Development Kit from <a href="http://www.oracle.com/technetwork/java/javase/downloads/index.html">http://www.oracle.com/technetwork/java/javase/downloads/index.html</a> (Latest Preferred)
  Install @ C:\Programs\jdk1.7 or higher
  Add User variable: JAVA_HOME pointing to your JDK (C:\Programs\jdk1.7)
  Add User variable: JAVA as %JAVA_HOME%\bin
  Modify your User Path Environment Variable by appending ;%JAVA_HOME%\bin
  (In Windows, add User variables using the Control Panel: System &gt; Advanced &gt; Environment Variables)
* Download and Install Apache Maven from <a href="http://maven.apache.org/download.html">http://maven.apache.org/download.html</a> (Latest Preferred)
  Install @ C:\Programs\apache\maven\3.04
  Add User variable: M2_HOME as C:\Programs\apache\maven\3.04
  Add User variable: M2 as %M2_HOME%\bin
  Modify your User Path Environment Variable by appending ;%M2_HOME%\bin
* Download and Install Apache Tomcat from <a href="http://tomcat.apache.org/download-70.cgi">http://tomcat.apache.org/download-70.cgi</a> (Latest Preferred)
  Install @ C:\Programs\apache\tomcat\7.0.29
  Add User variable: CATALINA_HOME as C:\Programs\apache\tomcat\7.0.29
  It is very important to install Tomcat in a folder without spaces in the path or the application may fail
  Modify your User Path Environment Variable by appending ;%CATALINA_HOME%\bin
  Download and Install the Modified Tomcat DBCP Jar file from <a href="http://www.java2s.com/Code/Jar/t/Downloadtomcatdbcpjar.htm">http://www.java2s.com/Code/Jar/t/Downloadtomcatdbcpjar.htm</a>
  Unzip the jar file and Install @ C:\Programs\apache\tomcat\7.0.29\lib (Replace Existing JAR)
  Open C:\Programs\apache\tomcat\7.0.29\conf\tomcat-users.xml and add the following line:
    <user username="admin" password="" roles="manager-gui, manager-script, manager-jmx, manager-status"/>
* Verify JDK, Maven, and Tomcat are working in your Command Prompt
  java -version
  mvn -version
  catalina version
* Install GIT (Source Control Management) Client from <a href="http://windows.github.com">http://windows.github.com</a> or <a href="https://github.com/blog/1127-github-for-windows>https://github.com/blog/1127-github-for-windows</a>

## Eclipse

* Install Eclipse WTP IDE @ C:\Programs\eclipse\juno
  Set the JDK option before starting eclipse through making following changes to eclipse.ini
    -vm
    C:/Programs/jdk1.7/jre/bin
    --launcher.XXMaxPermSize
    1024M
    -Xms1024m
    -Xmx2048m
  Set eclipse workspace to C:\Projects\workspaces\juno
  In eclipse go to Window -&gt; Preferences -&gt; Java -&gt; Installed JRE
  Select JRE and click on Edit and add dt.jar, tools.jar from C:\Programs\jdk1.7\lib folder</li>
  Install plug-in for eclipse from Help Eclipse MarketPlace for EGit (comes installed), Maven, ECLEmma  (code coverage), Sonar, TestNG, MoreUnit
  You could use Tomcat in 3 ways. Depending on how you want to use it follow one of the following instruction
    Use it from command line. no need to configure anything.
    Configure Tomcat in Server view. Make sure you started and stopped.
    Tomcat from command line before configuring. Tomcat Manager page may not work.

## Code Formatting



## TODO
create service, dao layer
integrate with MongoDB, JDO/SpringData
incorporate ui libraries for security, timeouts, modal, analytics
configure audit, error interceptors
logout

update document with MySQL/MongoDB setup,

mvn clean install tomcat:redeploy
mvn dbmaintain:clearDatabase dbmaintain:updateDatabase