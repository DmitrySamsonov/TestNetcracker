package com.university.objects;


import com.university.enums.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;


@Component
public class Utils {

    private Map<String, SearchType> searchTypeList = new HashMap<String, SearchType>();
    private SearchType selectedSearchType = SearchType.FIO;// значение по-умолчанию

    @Autowired
    private MessageSource msg;


    public Map<String, SearchType> getSearchTypeList() {
        searchTypeList.clear();
//      searchTypeList.put(msg.getMessage("author_name", null, FacesContext.getCurrentInstance().getViewRoot().getLocale()), SearchType.FIO);
//      searchTypeList.put(msg.getMessage("book_name", null, FacesContext.getCurrentInstance().getViewRoot().getLocale()), SearchType.GROUPNUMBER);
        searchTypeList.put("FIO", SearchType.FIO);
        searchTypeList.put("GroupNumber", SearchType.GROUPNUMBER);
        return searchTypeList;
    }



    public SearchType getSelectedSearchType() {
        return selectedSearchType;
    }


    public void setSearchTypeList(Map<String, SearchType> searchTypeList) {
        this.searchTypeList = searchTypeList;
    }



}
