package search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.elsevier.search.domain.Word;
import com.elsevier.search.service.WordProcessorService;
import com.elsevier.search.service.impl.WordProcessorServiceImpl;

public class TestSearchService {

    private WordProcessorService wordProcessor = new WordProcessorServiceImpl();

    // @Test
    public void getDirectoryListByWordsSearch() throws IOException {
        final Word word = new Word();
        word.setKeyword(getMockList());
        org.junit.Assert.assertNotNull(wordProcessor.ListDirectoyByWordSearch(word));

    }

    private List<String> getMockList() {
        final List<String> mockList = new ArrayList<>();
        mockList.add("test");
        return mockList;
    }

}
