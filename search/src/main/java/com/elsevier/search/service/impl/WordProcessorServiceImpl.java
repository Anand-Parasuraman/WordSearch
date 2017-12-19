/**
 * 
 */
package com.elsevier.search.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public  List<String> ListDirectoyByWordSearch(final Word wordObject) throws IOException {
        List<String> fileList = new ArrayList<>();
        boolean flag =Boolean.FALSE;
        String content = null;
        String[] ext = PropertyReader.getValue("INPUT_FILE_EXT").split(","); 
            if(StringUtils.isNotBlank(PropertyReader.getValue("INPUT_DIRECTORY_PATH"))){
            File filePath = new File(PropertyReader.getValue("INPUT_DIRECTORY_PATH"));
            List<File> listOfFiles = (List<File>) FileUtils.listFiles(filePath, ext, true);
            for (File file : listOfFiles) {
                flag = Boolean.TRUE;
                content = FileUtils.readFileToString(file);  
                String[] words = content.split(" ");   
               List<String> wordList  =Arrays.asList(words);
                for(String term : wordObject.getKeyword()){
                    if(!wordList.contains(term)){
                        flag = Boolean.FALSE;
                        break;
                    }
                }
                
                if(flag){
                    fileList.add(file.getAbsolutePath());
                }
                
            }       
         }
        return fileList;
    }

}
