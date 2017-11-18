FROM tomcat
COPY target/MusicApp.war ${CATALINA_HOME}/webapps