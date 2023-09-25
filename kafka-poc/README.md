# springboot


#### Java Download, Install and set path
https://www.oracle.com/java/technologies/downloads/#java17
SET JAVA_HOME = PATH_TO_JAVA_FOLDER
SET PATH = $PATH + %JAVA_HOME%\bin

## Maven download and set path
https://maven.apache.org/download.cgi
SET MAVEN_HOME = PATH_TO_MAVEN_FOLDER
SET PATH  = $PATH + %MAVEN_HOME%\bin

#### Create maven quickstart project
mvn archetype:generate -DarchetypeGroupId="org.apache.maven.archetypes" -DarchetypeArtifactId="maven-archetype-quickstart" -DarchetypeVersion="1.4" -DgroupId="com.erupothu.kafka" -DartifactId="kafka-poc" -DinteractiveMode="false"


