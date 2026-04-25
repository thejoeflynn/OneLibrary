package com.zipcodewilmington.OneLibrary;

public interface Reservable {

    void reserve();

    void cancelReserve();

    boolean isReserved();
}