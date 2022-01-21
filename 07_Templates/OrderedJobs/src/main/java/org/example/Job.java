package org.example;

import java.util.Objects;

public class Job implements Comparable<Job> {
    private String mName;
    Job mDependsOn;

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

    @Override
    public String toString() {
        return mName;
    }

    @Override
    public int compareTo(Job o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if(this == o.mDependsOn){
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(mName, job.mName);
    }
}
