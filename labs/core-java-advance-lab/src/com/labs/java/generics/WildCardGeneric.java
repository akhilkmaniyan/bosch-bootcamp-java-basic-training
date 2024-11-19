package com.labs.java.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardGeneric {
    private List<Comparable<?>> nos = new ArrayList<>();

    WildCardGeneric() {
        nos.add(1);
        nos.add(2);
        nos.add("Akhil");
    }
    public static void main(String[] args) {
     WildCardGeneric generic = new WildCardGeneric();
     System.out.println("Values are" + generic.nos);
    }
}
