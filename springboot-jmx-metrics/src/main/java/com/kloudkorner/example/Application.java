package com.kloudkorner.example;

import com.kloudkorner.example.jmx.UpdateCurrentCPUTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application
{
  public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException
  {
    final UpdateCurrentCPUTask customMBeans = new UpdateCurrentCPUTask();
    final ExecutorService executorService = Executors.newFixedThreadPool(1);
    executorService.execute(customMBeans);
    SpringApplication.run(Application.class, args);
  }
}