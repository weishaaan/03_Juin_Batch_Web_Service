package com.mora.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTrigger {
        
    public void QuartzTrigger(String frequency) throws Exception{
        
    	JobDetail job = JobBuilder.newJob(QuartzTest.class).withIdentity("dummyJobName", "group1").build();

    	Trigger trigger = TriggerBuilder
                            .newTrigger()
                            .withIdentity("dummyTriggerName", "group1")
                            .withSchedule(CronScheduleBuilder.cronSchedule("0/"+frequency+" * * * * ?"))
                            .build();
    	
    	//schedule it
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);
    
    }

    
}
