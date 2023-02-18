package com.kloudkorner.example.jmx;

public class ApplicationCPU implements ApplicationCPUMBean
{
  private double currentCPU;
  @Override
  public double getCurrentCPU()
  {
    this.currentCPU = Math.random();
    return this.currentCPU;
  }
}
