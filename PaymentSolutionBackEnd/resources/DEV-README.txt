Important Note

Omnia Libraries and Jar

1. pie-webapp-utility-1.1.1.jar
		<dependency>
			<groupId>com.omnia.pie</groupId>
			<artifactId>pie-webapp-utility</artifactId>
			<version>1.1.1</version>
		</dependency>
		
To get this jar, checkout the project from PayoBackend svn and install the jar located in the target folder
Go to the root folder of the project where the pom.xml is located.

using maven cli, execute this command:

mvn install:install-file -Dfile=target/pie-webapp-utility-1.1.1.jar -DpomFile=pom.xml

You can also check the following link for more info or alternative way of installation:
https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html


2. omnia theme for primefaces inside all-themes-1.0.11-SNAPSHOT.jar
Notice the pom file to have the following:
		<dependency>
		    <groupId>org.primefaces.themes</groupId>
		    <artifactId>all-themes</artifactId>
		    <version>1.0.11-SNAPSHOT</version>
		</dependency>		
		
and in web.xml we have the following entry:

    <context-param>
      <param-name>primefaces.THEME</param-name>
      <param-value>omnia</param-value>
	</context-param>
	
Refer to primefaces-themes online for theme options but we created our own theme in the name of omnia.
Check out the project primefaces-all-themes from the svn inside PAYO-BACKEND repo.
You can install the file using the following maven command:

mvn install:install-file -Dfile=(folder_where_jar_file_is_located)/primefaces-all-themes-1.0.11-SNAPSHOT.jar -DpomFile=pom.xml



-Happy Coding
Mark Louie

