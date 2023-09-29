# Sử dụng hình ảnh Tomcat làm cơ sở
FROM tomcat:9

# Sao chép tệp WAR của ứng dụng vào thư mục webapps của Tomcat
COPY /APIServer/build/libs/APIServer-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/APIServer.war

# Sao chép tệp env của bạn vào thư mục conf của Tomcat
COPY Bean/src/main/resources/tshine.env /usr/local/tomcat/conf/

# Thay đổi quyền truy cập của tệp env để Tomcat có thể đọc
RUN chmod 644 /usr/local/tomcat/conf/tshine.env

# Khởi động máy chủ Tomcat
CMD ["catalina.sh", "run"]