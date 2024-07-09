spring.datasource.url=jdbc:mysql://localhost:3306/ecalendar
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true



package com.example.ecalendar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private String department;

    // Getters and setters
}


package com.example.ecalendar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class CalendarEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate date;
    private String type; // e.g., "Shift", "Leave"

    // Getters and setters
}



package com.example.ecalendar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class OrganizationalEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate date;

    // Getters and setters
}



package com.example.ecalendar.repository;

import com.example.ecalendar.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package com.example.ecalendar.repository;

import com.example.ecalendar.model.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
}


package com.example.ecalendar.repository;

import com.example.ecalendar.model.OrganizationalEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationalEventRepository extends JpaRepository<OrganizationalEvent, Long> {
}


package com.example.ecalendar.service;

import com.example.ecalendar.model.Employee;
import com.example.ecalendar.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}



package com.example.ecalendar.service;

import com.example.ecalendar.model.CalendarEvent;
import com.example.ecalendar.repository.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEventService {

    @Autowired
    private CalendarEventRepository calendarEventRepository;

    public List<CalendarEvent> getAllEvents() {
        return calendarEventRepository.findAll();
    }

    public CalendarEvent getEventById(Long id) {
        return calendarEventRepository.findById(id).orElse(null);
    }

    public CalendarEvent saveEvent(CalendarEvent event) {
        return calendarEventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        calendarEventRepository.deleteById(id);
    }
}



package com.example.ecalendar.service;

import com.example.ecalendar.model.OrganizationalEvent;
import com.example.ecalendar.repository.OrganizationalEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationalEventService {

    @Autowired
    private OrganizationalEventRepository organizationalEventRepository;

    public List<OrganizationalEvent> getAllEvents() {
        return organizationalEventRepository.findAll();
    }

    public OrganizationalEvent getEventById(Long id) {
        return organizationalEventRepository.findById(id).orElse(null);
    }

    public OrganizationalEvent saveEvent(OrganizationalEvent event) {
        return organizationalEventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        organizationalEventRepository.deleteById(id);
    }
}



package com.example.ecalendar.controller;

import com.example.ecalendar.model.Employee;
import com.example.ecalendar.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeService.getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());
        employee.setDepartment(employeeDetails.getDepartment());
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}



package com.example.ecalendar.controller;

import com.example.ecalendar.model.CalendarEvent;
import com.example.ecalendar.service.CalendarEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendar-events")
public class CalendarEventController {

    @Autowired
    private CalendarEventService calendarEventService;

    @GetMapping
    public List<CalendarEvent> getAllEvents() {
        return calendarEventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public CalendarEvent getEventById(@PathVariable Long id) {
        return calendarEventService.getEventById(id);
    }

    @PostMapping
    public CalendarEvent createEvent(@RequestBody CalendarEvent event) {
        return calendarEventService.saveEvent(event);
    }

    @PutMapping("/{id}")
    public CalendarEvent updateEvent(@PathVariable Long id, @RequestBody CalendarEvent eventDetails) {
        CalendarEvent event = calendarEventService.getEventById(id);
        event.setTitle(eventDetails.getTitle());
        event.setDate(eventDetails.getDate());
        event.setType(eventDetails.getType());
        return calendarEventService.saveEvent(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        calendarEventService.deleteEvent(id);
    }
}



package com.example.ecalendar.controller;

import com.example.ecalendar.model.OrganizationalEvent;
import com.example.ecalendar.service.OrganizationalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizational-events")
public class OrganizationalEventController {

    @Autowired
    private OrganizationalEventService organizationalEventService;

    @GetMapping
    public List<OrganizationalEvent> getAllEvents() {
        return organizationalEventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public OrganizationalEvent getEventById(@PathVariable Long id) {
        return organizationalEventService.getEventById(id);
    }

    @PostMapping
    public OrganizationalEvent createEvent(@RequestBody OrganizationalEvent event) {
        return organizationalEventService.saveEvent(event);
    }

    @PutMapping("/{id}")
    public OrganizationalEvent updateEvent(@PathVariable Long id, @RequestBody OrganizationalEvent eventDetails) {
        OrganizationalEvent event = organizationalEventService.getEventById(id);
        event.setTitle(eventDetails.getTitle());
        event.setDate(eventDetails.getDate());
        return organizationalEventService.saveEvent(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        organizationalEventService.deleteEvent(id);
    }
}



package com.example.ecalendar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and()
            .httpBasic()
                .and()
            .csrf().disable();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("manager")
            .password("password")
            .roles("MANAGER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
}



<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>ecalendar</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>ecalendar</name>
    <description>E-Calendar System</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <java.version>11</java.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starter Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Boot Starter Data JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- MySQL Driver -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Spring Boot Starter Security -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <!-- Spring Boot Starter Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Spring Boot Starter Thymeleaf (Optional for Spring Form Tag Library) -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>



