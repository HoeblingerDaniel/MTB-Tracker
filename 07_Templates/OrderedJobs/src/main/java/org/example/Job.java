package org.example;

public class Job {
    private String mName;
    private Job mDependsOn;

    public Job(String name, Job dependsOn) {
        mName = name;
        mDependsOn = dependsOn;
    }

    public Job(String name) {
        mName = name;
    }

    public Job getDependency() {
        return mDependsOn;
    }

    public String getName() {
        return mName;
    }
}
