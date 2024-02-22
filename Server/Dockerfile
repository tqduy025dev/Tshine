FROM tomcat:9-jre8

RUN mv /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps/
COPY APIServer.war /usr/local/tomcat/webapps/APIServer.war
COPY server.xml /usr/local/tomcat/conf/server.xml
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
COPY context.xml /usr/local/tomcat/webapps/host-manager/META-INF/context.xml
COPY manager.xml /usr/local/tomcat/webapps/host-manager/WEB-INF/manager.xml

COPY tshine.env /usr/local/tomcat/conf/tshine.env

# COPY setenv.sh /usr/local/tomcat/bin/setenv.sh

# RUN chmod +x /usr/local/tomcat/bin/setenv.sh
# ENTRYPOINT ["/usr/local/tomcat/bin/setenv.sh"]

CMD ["catalina.sh", "run"]