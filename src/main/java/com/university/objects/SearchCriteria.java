package com.university.objects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.university.enums.SearchType;

import java.io.Serializable;

@Component
@Scope("singleton")
public class SearchCriteria implements Serializable{

    private String text;   //по вводим

    private SearchType searchType;    //тип поиска(по ФИО, по номеру группы)

    private Character letter;   //поиск по букве






    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

}
