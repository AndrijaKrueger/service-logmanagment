package de.xcrossworx.service.logmanagment.model;

import javax.persistence.*;

@Entity
@Table(name = "LogMessages")
@NamedQueries({@NamedQuery(name = "Logs.findAll", query = "select e from LogMessage e")})
public class LogMessage extends BaseEntity{

    private String systemName;

    @Enumerated(value = EnumType.STRING)
    private LogType logType;

    private String logMethod;

    private String logMessage;

    @Column(columnDefinition = "varchar(2048)")
    private String logData;

    @Column(columnDefinition = "varchar(2048)")
    private String exMessage;

    @Column(columnDefinition = "varchar(2048)")
    private String exStacktrace;

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getExMessage() {
        return exMessage;
    }

    public void setExMessage(String exMessage) {
        this.exMessage = exMessage;
    }

    public String getExStacktrace() {
        return exStacktrace;
    }

    public void setExStacktrace(String exStacktrace) {
        this.exStacktrace = exStacktrace;
    }

    public LogMessage() {
    }

    public LogMessage(String systemName, LogType logType, String logMethod, String logMessage, String logData, String exMessage, String exStacktrace) {
        this.systemName = systemName;
        this.logType = logType;
        this.logMethod = logMethod;
        this.logMessage = logMessage;
        this.logData = logData;
        this.exMessage = exMessage;
        this.exStacktrace = exStacktrace;
    }
}
