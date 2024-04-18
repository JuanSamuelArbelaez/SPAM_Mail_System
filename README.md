# SPAM_Mail_System
Juan Samuel Arbeláez


## Description

SPAM_Mail_System is a web API built using Spring Boot and MySQL. It allows users to register recipients (email, first name, and last name) and add messages through the API. Users can then select a random quantity of previously added messages and send them to a set recipient identified by ID in a MySQL database.


## Features

- Register recipients (email, first name, last name)
- Add messages with titles, sender email, and message content
- Send a set quantity of randomly selected messages to a set recipient from the database.


## Installation

1. Clone the repository:
  ```
  git clone https://github.com/YourUsername/SPAM_Mail_System.git
  ```

2. Go to the project folder:
  ```
  cd SPAM_Mail_System
  ```

3. Build the project using Gradle:
  ```
  ./gradlew build
  ```

4. Configure the application.properties file with your SMTP credentials:
  ```
  spring.mail.host=smtp_example_host.com
  spring.mail.port=smpt_port
  spring.mail.username=smtp_username_example@email.com
  spring.mail.password=smtp_password</code>
  ```

5. Configure the application.properties file with your MySQL database credentials:
  ```
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.datasource.url=jdbc:mysql://db_ip_address:db_port/db_name
  spring.datasource.username=db_user
  spring.datasource.password=db_password
  ```


6. Run the application:
  ```
  ./gradlew bootRun
  ```


# USAGE
* **Register Recipient**

  Endpoint: PUT /recipients/add
  
  Request Body:
    ```
    {
        "email": "recipient@example.com",
        "firstName": "John",
        "lastName": "Doe"
    }
    ```

* **Add Message**

  Endpoint: Put /messages/add

  Request Body:
    ```
    {
        "title": "Message Title",
        "senderEmail": "sender@example.com",
        "message": "Message content with placeholders like [NAME] for the recipient (full name)"
    }
    ```

* **Send Message**

  Endpoint: Put /spam/count-to-address
  
  Request Body:
    ```
    {
        "recipientId": 123,
        "quantity": 5
    }
    ```


# Technologies Used

<div align="center">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="50" alt="java logo" title="Java" />
    <img width="15" />
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="50" alt="mysql logo" title="MySQL" />
    <img width="15" />
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="50" alt="spring logo" title="Spring" />
</div>


# Contributors
Juan Samuel Arbelaez - GitHub

# License
This project is licensed under the MIT License - see the LICENSE file for details.
