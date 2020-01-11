package com.gluonapplication;

import java.io.InputStream;

public class Speaker {
    private String fullName;
    private String jobTitle;
    private String company;
    private String summary;


    public Speaker(String fullName, String jobTitle, String company, String summary) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.company = company;
        this.summary = summary;
    }

    public Speaker() {
        this.fullName = "fullName";
        this.jobTitle = "jobTitle";
        this.company = "company";
        this.summary = "summary";
    }

    public InputStream getPicture() {
        return getClass().getResourceAsStream("/login_bg.jpeg");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
