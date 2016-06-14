package quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTrigger {
    
    public void QuartzTrigger() throws Exception{
        
    	//JobDetail job = new JobDetail();
    	//job.setName("dummyJobName");
    	//job.setJobClass(HelloJob.class);    	
    	JobDetail job = JobBuilder.newJob(QuartzTest.class)
                            .withIdentity("dummyJobName", "group1").build();

    	//CronTrigger trigger = new CronTrigger();
    	//trigger.setName("dummyTriggerName");
    	//trigger.setCronExpression("0/5 * * * * ?");
    	
    	Trigger trigger = TriggerBuilder
                            .newTrigger()
                            .withIdentity("dummyTriggerName", "group1")
                            .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                            //SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                            .build();
    	
    	//schedule it
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);
    
    }

    
}
