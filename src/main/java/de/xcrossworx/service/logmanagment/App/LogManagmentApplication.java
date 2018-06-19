package de.xcrossworx.service.logmanagment.App;

import de.xcrossworx.service.logmanagment.persistence.LogDao;
import de.xcrossworx.service.logmanagment.resources.LogMessageResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class LogManagmentApplication extends Application<LogManagmentConfiguration> {

    public static void main(String[] args) throws Exception {
        new LogManagmentApplication().run(args);
    }

    public void run(LogManagmentConfiguration logManagmentConfiguration, Environment environment) throws Exception {
        final LogDao logDao = new LogDao();

        environment.jersey().register(new LogMessageResource(logDao));
    }

}
