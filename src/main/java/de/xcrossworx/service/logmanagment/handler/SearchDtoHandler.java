package de.xcrossworx.service.logmanagment.handler;

import de.xcrossworx.service.logmanagment.model.LogType;
import de.xcrossworx.service.logmanagment.model.dto.SearchDto;
import de.xcrossworx.service.logmanagment.persistence.LogDao;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SearchDtoHandler {

    private static LogDao logDao;

    public static SearchDto getSearchDto() {
        logDao = new LogDao();
        SearchDto searchDto = new SearchDto();

        try{
            searchDto.setSystemNames(logDao.getSystemNames());
            searchDto.setLogTypes(Arrays.stream(LogType.values()).map(Enum::name).collect(Collectors.toList()));
        } catch (Exception ex){

        }

        return searchDto;
    }
}
