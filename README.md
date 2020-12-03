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
    USE spring_demo_one;
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

#### Custom ID
1. You can define your own CUSTOM generation Strategy
2. Create implementation of **org.hibernate.id.IdentifierGenerator**
3. Override the method: **public Serializable (...)**


#### Modify Student Table
Add column `date_of_birth` and copy this script below
```sql
ALTER TABLE student ADD COLUMN date_of_birth date AFTER email
```

#### Eager vs Lazy Loading
1. Eager will retrieve everything<br>
    - Eager Loading will load all dependent entities
    - If your app, searching for something by the keyword, eager loading would still load all...Not Good!
    - Solution: Use Lazy Loading instead of Eager Loading
2. Lazy will retrieve on request<br>
    - Load the main entity first

#### Default Fetch Type
1. @OneToOne -> FetchType.EAGER
2. @OneToMany -> FetchType.LAZY
3. @ManyToOne -> FetchType.EAGER
4. @ManyToMany -> FetchType.LAZY
