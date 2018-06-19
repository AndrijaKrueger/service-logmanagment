package de.xcrossworx.service.logmanagment.persistence;

import de.xcrossworx.service.logmanagment.model.LogMessage;
import de.xcrossworx.service.logmanagment.model.SystemName;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.List;

public class LogDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Postgres_PU");

    private void updateCalendar(LogMessage logMessage) {
        if (logMessage == null) return;

        Calendar now = Calendar.getInstance();

        if (logMessage.getId() == 0) logMessage.setCreated(now);

        logMessage.setModified(now);
    }

    public List<LogMessage> getAll() {
        EntityManager em = emf.createEntityManager();
        List<LogMessage> logs = em.createNamedQuery("Logs.findAll").getResultList();
        return logs;
    }

    public void saveLogMessage(LogMessage message) {
        updateCalendar(message);
        updateSystemName(message.getSystemName());

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(message);

        em.getTransaction().commit();
        em.close();
    }

    public void updateSystemName(final String systemName) {
        try{
            List<SystemName> systemNames = getSystemNames();

            boolean systemNameInDatabase = false;

            for (SystemName name: systemNames) {
                if(name.getName().equals(systemName)){
                    systemNameInDatabase = true;
                    break;
                }
            }

            if(systemNameInDatabase == false){
                SystemName newSystemName = new SystemName();
                newSystemName.setId(0);
                newSystemName.setCreated(Calendar.getInstance());
                newSystemName.setModified(Calendar.getInstance());
                newSystemName.setName(systemName);

                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.merge(newSystemName);

                em.getTransaction().commit();
                em.close();
            }

        } catch (Exception ex){
            saveLogMessage(new LogMessage("Log Service", "", "", "", "", "", ""));
        }
    }

    public List<SystemName> getSystemNames() {
            try{
                EntityManager em = emf.createEntityManager();
                List<SystemName> systemNames = em.createNamedQuery("SystemName.findAll").getResultList();
                return  systemNames;
            } catch (Exception ex){
                saveLogMessage(new LogMessage("Log Service", "", "", "", "", "", ""));
            }
        return null;
    }
}
