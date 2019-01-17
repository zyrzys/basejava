package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.Storage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume(uuid);
        r1.setUuid("uuid1");
        final Resume r2 = new Resume(uuid);
        r2.setUuid("uuid2");
        final Resume r3 = new Resume(uuid);
        r3.setUuid("uuid3");
        final Resume r4 = new Resume(uuid);
        r4.setUuid("uuid4");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
//        System.out.println("Index of r2: " + Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r2));

        printAll();
        System.out.println("\nAfter delete uuid1");
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        System.out.println("Successful update");
        ARRAY_STORAGE.update(r2);
        System.out.println("Unsuccessful update");
        ARRAY_STORAGE.update(r4);
        System.out.println("\nClear all");
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
