package com.mora.quartz;

import com.mora.model.Batch;
import com.mora.model.BatchDatabase;
import java.io.IOException;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzTest implements Job {
    

          
    public void execute(JobExecutionContext context) throws JobExecutionException {
        
        //BatchDatabase batchDatabase = new BatchDatabase();
        //List<Batch> btc = batchDatabase.getAllBatches();
        
        System.out.println("running batch .");
        
        
    }
    
}
