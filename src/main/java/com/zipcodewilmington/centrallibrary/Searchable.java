package com.zipcodewilmington.centrallibrary;

public interface Searchable {

    String[] getSearchableFields();

    default boolean matchesKeyword(String keyword) {
        if (keyword == null || keyword.isBlank())
            return false;
        String lower = keyword.toLowerCase();
        for (String field : getSearchableFields()) {
            if (field != null && field.toLowerCase().contains(lower)) {
                return true;
            }
        }
        return false;
    }
}