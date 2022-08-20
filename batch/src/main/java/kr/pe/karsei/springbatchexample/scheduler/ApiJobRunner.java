package kr.pe.karsei.springbatchexample.scheduler;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ApiJobRunner extends JobRunner {
    @Autowired
    private Scheduler scheduler;

    @Override
    public void doRun(ApplicationArguments args) {
        JobDetail jobDetail = buildJobDetail(ApiSchJob.class, "apiJob", "batch", new HashMap<>());
        Trigger trigger = buildJobTrigger("0/30 * * * * ?");

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        }
        catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
