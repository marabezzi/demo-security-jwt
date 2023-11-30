package snippet;

public class Snippet {
	server:
	 port: 8081
	 
	logging:
	  level:
	    org:
	     springframework:
	      security: TRACE
	      jdbc: INFO
	      joa: TRACE
	      
	spring:
	 datasource:
	    driverClassName: com.mysql.cj.jdbc.Driver
	    url: jdbc:mysql://localhost:3306/springboottutorial?useTimezone=true&serverTimezone=America/Sao_Paulo
	    username: admin
	    password: 1234
	 jpa:
	    hibernate.ddl-auto: none
	    generate-ddl: true
	    show-sql: true
	    properties:
	     hibernate:
	      format_sql: true
	      dialect: org.hibernate.dialect.MySQL8Dialect
}

