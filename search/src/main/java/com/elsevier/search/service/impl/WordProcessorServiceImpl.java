/**
 * 
 */
package com.elsevier.search.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.elsevier.search.domain.Word;
import com.elsevier.search.service.WordProcessorService;
import com.elsevier.search.service.helper.PropertyReader;

/**
 * @author parasua1
 *
 */
public class WordProcessorServiceImpl implements WordProcessorService {

    @SuppressWarnings("unchecked")
    @Override
    public List<String> ListDirectoyByWordSearch(final Word wordObject) throws IOException {
        List<String> tmpList = null;
        List<String> fileList = new ArrayList<>();
        String line = null;
        String[] ext = PropertyReader.getValue("INPUT_FILE_EXT").split(",");
        if (StringUtils.isNotBlank(PropertyReader.getValue("INPUT_DIRECTORY_PATH"))) {
            File filePath = new File(PropertyReader.getValue("INPUT_DIRECTORY_PATH"));
            List<File> listOfFiles = (List<File>) FileUtils.listFiles(filePath, ext, true);
            for (File file : listOfFiles) {
                tmpList = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    while ((line = br.readLine()) != null) {
                        String[] words = line.split(" ");
                        for (String term : wordObject.getKeyword()) {
                            if (Arrays.asList(words).contains(term) && !tmpList.contains(term)) {
                                tmpList.add(term);
                            }
                        }

                    }
                } catch (IOException e) {
                    throw e;
                }

                if (tmpList.containsAll(wordObject.getKeyword())) {
                    fileList.add(file.getAbsolutePath());
                }
            }
        }
        return fileList;
    }
}