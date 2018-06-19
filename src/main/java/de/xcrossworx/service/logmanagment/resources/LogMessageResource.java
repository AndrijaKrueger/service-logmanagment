package de.xcrossworx.service.logmanagment.resources;

import com.codahale.metrics.annotation.Timed;
import de.xcrossworx.service.logmanagment.model.LogMessage;
import de.xcrossworx.service.logmanagment.persistence.LogDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/log-resource")
@Produces(MediaType.APPLICATION_JSON)
public class LogMessageResource {

    private LogDao logDao;

    public LogMessageResource(LogDao logDao) {
        this.logDao = logDao;
    }

    @GET
    @Timed
    public Response checkResource(){
        return Response.ok().entity("Log Resource is here !!!!").build();
    }

    @GET
    @Timed
    @Path("/getAll")
    public Response getAll(){
        return Response.ok().entity(logDao.getAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Response saveLogMessage(LogMessage message){
        if(message == null) return Response.serverError().entity("Log Message was null").build();

        logDao.saveLogMessage(message);

        return Response.ok().entity("Message was saved").build();
    }

    @GET
    @Path("/getAllSystemNames")
    @Timed
    public Response getSystemNames(){
        return Response.ok().entity(logDao.getSystemNames()).build();
    }
}
