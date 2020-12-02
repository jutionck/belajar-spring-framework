# spring-demo-hibernate-jdbc-mysql


#### Open MySQL Workbench
Step-By-Step
1. Create a new user
    ```sql
   CREATE USER 'userdemo'@'localhost' IDENTIFIED BY 'userdemo';
   GRANT ALL PRIVILEGES * . * TO 'userdemo'@'localhost';
    ```
2. Open connection again with new user
3. Create a database :
    ```sql
    CREATE DATABASE spring_demo_one;
    ```
4. Use a database :
    ```sql
    USE spring_user_demo;
    ```
5. Create a table:
    ```sql
    CREATE TABLE student (
       id int(11) NOT NULL AUTO_INCREMENT,
       first_name varchar(45) DEFAULT NULL,
       last_name varchar(45) DEFAULT NULL,
       email varchar(45) DEFAULT NULL,
       PRIMARY KEY(id)
   );
    ```
