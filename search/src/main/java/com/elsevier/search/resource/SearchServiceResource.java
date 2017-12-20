/**
 * 
 */
package com.elsevier.search.resource;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.elsevier.search.constants.SearchConstant;
import com.elsevier.search.domain.Word;
import com.elsevier.search.exception.BadRequestException;
import com.elsevier.search.exception.DataNotFoundException;
import com.elsevier.search.exception.GeneralException;
import com.elsevier.search.service.WordProcessorService;
import com.elsevier.search.service.impl.WordProcessorServiceImpl;
import com.elsevier.search.service.util.ValidationUtil;

/**
 * @author Elsevier
 *
 */
@Path(SearchConstant.REQUEST_URL_WORD_SEARCH_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchServiceResource {

    static final Logger logger = Logger.getLogger(SearchServiceResource.class);

    WordProcessorService wordProcessor;

    @POST
    public Response getDirectoryListByWordsSearch(
            @DefaultValue(SearchConstant.DEFAULT_EMPTY_STR) final String searchKeywordJson) {

        long startTime = System.nanoTime();
        logger.debug("Execution Started - " + startTime);
        ObjectMapper mapper = new ObjectMapper();
        List<String> searchList = null;
        wordProcessor = new WordProcessorServiceImpl();
        try {
            Word word = mapper.readValue(searchKeywordJson, Word.class);
            if (ValidationUtil.validateWordObject(word)) {
                searchList = wordProcessor.ListDirectoyByWordSearch(word);
                if (searchList.isEmpty()) {
                    throw new DataNotFoundException("No Results found for the Search parameters");
                }
            } else {
                throw new BadRequestException("Invalid Request Parameters");
            }
        } catch (IOException e) {
            logger.error(SearchConstant.EXCEPTION_MSG + e);
            throw new GeneralException(e.getMessage());
        }
        logger.debug("Execution Ended - " + (startTime - System.nanoTime()));
        return Response.status(200).entity(searchList).build();
    }
}
