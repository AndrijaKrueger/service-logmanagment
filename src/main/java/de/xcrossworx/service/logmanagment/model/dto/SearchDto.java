package de.xcrossworx.service.logmanagment.model.dto;

import de.xcrossworx.service.logmanagment.model.SystemName;

import java.util.List;

public class SearchDto {

    private List<SystemName> systemNames;
    private SystemName systemName;

    private List<String> logTypes;
    private String logType;

    private String startDate;

    private String endDate;

    public SystemName getSystemName() {
        return systemName;
    }

    public void setSystemName(SystemName systemName) {
        this.systemName = systemName;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<SystemName> getSystemNames() {
        return systemNames;
    }

    public void setSystemNames(List<SystemName> systemNames) {
        this.systemNames = systemNames;
    }

    public List<String> getLogTypes() {
        return logTypes;
    }

    public void setLogTypes(List<String> logTypes) {
        this.logTypes = logTypes;
    }
}
