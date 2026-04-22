package com.zipcodewilmington.centrallibrary;

import java.util.List;

public interface Searchable {
    List<String> getSearchableFields();

    default boolean matchesKeyword(String keyword) {
        for (String field : getSearchableFields()) {
            if (field.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}