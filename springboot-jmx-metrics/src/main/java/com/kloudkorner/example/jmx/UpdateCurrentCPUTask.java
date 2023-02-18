package com.kloudkorner.example.jmx;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class UpdateCurrentCPUTask implements Runnable
{
  private final String objectNameStr = "com.kloudkorner.jmx.example:type=ApplicationCPU";

  private final MBeanServer server = ManagementFactory.getPlatformMBeanServer();
  private final ApplicationCPU cpuMBean;
  public UpdateCurrentCPUTask() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException
  {
    final ObjectName objectName = new ObjectName(objectNameStr);
    cpuMBean = new ApplicationCPU();
    server.registerMBean(cpuMBean, objectName);
  }

  @Override
  public void run()
  {
    while (true)
    {
      cpuMBean.getCurrentCPU();
      try
      {
        TimeUnit.SECONDS.sleep(10);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
