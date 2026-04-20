package com.zipcodewilmington.centrallibrary;

/**
 * Created by n3pjk on 6/9/2025.
 */
public class MainApplication {

    public interface Searchable {
        boolean matchesKeyword(String keyword);
    }

    public interface Reservable {
        void reserve();

        void cancelReserve();
    }

}
