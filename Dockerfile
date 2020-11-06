FROM openjdk:15-alpine
COPY ./* /app/
# 编译程序
WORKDIR /app/
RUN javac -d ./output ./Test.java
# 将当前目录设为输出目录
WORKDIR /app/output