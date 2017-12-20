/**
 * 
 */
package com.elsevier.search.service;

import java.io.IOException;
import java.util.List;

import com.elsevier.search.domain.Word;

/**
 * @author Elsevier
 *
 */
public interface WordProcessorService {

    List<String> ListDirectoyByWordSearch(Word word) throws IOException;

}
