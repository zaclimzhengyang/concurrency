package com.example.demo.immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefensiveCopies {
    /**
     * we must protect the classes from calling code
     * assume that calling codes will do its best to change
     * our data in a way we did not expect it
     * while this is especially true in the case of immutable data,
     * it is also true for non-immutable data which we do not
     * expect to be changed from outside our class
     *
     * to protect our class against that, we should copy data which we receive and
     * only return copies of data to calling code
     */
    public ArrayList<String> list = new ArrayList<String>();

    public void add(String s) {
        list.add(s);
    }

    /**
     * make a defensive copy of the List and return it
     * this way we cannot modify the list itself
     *
     * return List<String>
     */
    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}
