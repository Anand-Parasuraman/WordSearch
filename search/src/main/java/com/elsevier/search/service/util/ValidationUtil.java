package com.elsevier.search.service.util;

import com.elsevier.search.domain.Word;

public class ValidationUtil {

    public static boolean validateWordObject(final Word wordObj) {
        
        if (null != wordObj && null != wordObj.getKeyword() && !wordObj.getKeyword().isEmpty()) {
          return Boolean.TRUE;  
        }
        return Boolean.FALSE;
    }

}
