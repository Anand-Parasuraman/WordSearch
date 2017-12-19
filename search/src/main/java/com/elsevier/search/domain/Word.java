package com.elsevier.search.domain;

import java.util.List;

public class Word {

    private List<String> keyword;

    /**
     * @return the keyword
     */
    public final List<String> getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     *            the keyword to set
     */
    public final void setKeyword(final List<String> keyword) {
        this.keyword = keyword;
    }

}
