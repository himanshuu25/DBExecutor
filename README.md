# DBExecutor
DBExecutor is a lightweight Java-based database executor tool that allows users to execute SQL queries on any JDBC-supported database. It supports both SELECT queries, with formatted output display, and other SQL statements like INSERT, UPDATE, DELETE. The database connection is fully configurable via a simple properties file.

# Features
- Execute SQL queries from the command line
- Display results of SELECT queries in a tabular format
- Automatically formats DATE columns to YYYY-MM-DD
- Supports execution of non-SELECT queries (INSERT, UPDATE, DELETE)
- Handles SQL and unexpected errors gracefully
- Exit the tool easily with the exit command
- Configure any JDBC-supported database via a properties file

# Requirements:
- Java JDK 8 or higher
- Any JDBC-supported database (Oracle, MySQL, PostgreSQL, SQL Server, etc.)
- JDBC Driver for the database (e.g., ojdbc8.jar for Oracle, mysql-connector-java.jar for MySQL)
- Basic knowledge of SQL

# Setup:
- Clone or download the project
- Create a properties file named SqlPlus.properties in the same directory as DBExecutor.java:

# SqlPlus.properties file:
- driver=YOUR_JDBC_DRIVER_CLASS
- url=YOUR_DATABASE_URL
- user=YOUR_DB_USERNAME
- password=YOUR_DB_PASSWORD

# Compile the Java code:
- javac -cp .;your-jdbc-driver.jar DBExecutor.java

# Run the program:
- java -cp .;your-jdbc-driver.jar DBExecutor

# Notes
- The program does not support multi-line SQL statements; enter each query on a single line.
- Ensure the JDBC driver .jar file is included in your classpath.
- Works with any JDBC-supported database by updating the properties file.


