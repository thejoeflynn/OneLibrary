package com.zipcodewilmington.OneLibrary;

public interface Searchable {

    boolean matchesKeyword(String keyword);

    String[] getSearchableFields();

}
