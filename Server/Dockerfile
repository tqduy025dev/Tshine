FROM tomcat:9-jre8

RUN mv /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps/
COPY APIServer/build/libs/APIServer-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/APIServer.war
COPY tomcat/server.xml /usr/local/tomcat/conf/server.xml
COPY tomcat/tomcat-users.xml /usr/local/tomcat/conf/
COPY tomcat/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
COPY tomcat/context.xml /usr/local/tomcat/webapps/host-manager/META-INF/context.xml
COPY tomcat/manager.xml /usr/local/tomcat/webapps/host-manager/WEB-INF/manager.xml

COPY tshine.env /usr/local/tomcat/conf/tshine.env

# COPY setenv.sh /usr/local/tomcat/bin/setenv.sh

# RUN chmod +x /usr/local/tomcat/bin/setenv.sh
# ENTRYPOINT ["/usr/local/tomcat/bin/setenv.sh"]

CMD ["catalina.sh", "run"]