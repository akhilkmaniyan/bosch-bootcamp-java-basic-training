package com.labs.java.generics;

import java.util.Collection;

import java.util.ArrayList;
import java.util.Collection;

public class ManageGeneriCollectionWithWildCards<E> {

    private Collection<E> items;

    public ManageGeneriCollectionWithWildCards() {
        items = new ArrayList<>();
    }

    public void addItemsToCollection(Collection<E> newItems) {
        items.addAll(newItems);
    }

    public Collection<E> getItemsInCollection() {
        return items;
    }

    public void printItemsCollection() {
        for (E item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        ManageGeneriCollectionWithWildCards<String> collectionWithWildCards = new ManageGeneriCollectionWithWildCards<>();
        ManageGeneriCollectionWithWildCards<Integer> collectionWithWildCards1 = new ManageGeneriCollectionWithWildCards<>();

        Collection<String> newItems = new ArrayList<>();
        newItems.add("Apple");
        newItems.add("Banana");
        newItems.add("Cherry");

        collectionWithWildCards.addItemsToCollection(newItems);
        collectionWithWildCards.printItemsCollection();

        Collection<Integer> newItems1 = new ArrayList<>();
        newItems1.add(1);
        newItems1.add(2);
        newItems1.add(3);

        collectionWithWildCards1.addItemsToCollection(newItems1);
        collectionWithWildCards1.printItemsCollection();
    }


}
