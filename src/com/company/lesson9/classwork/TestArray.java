package com.company.lesson9.classwork;

import java.util.ArrayList;
import java.util.List;

public class TestArray {
    private List<Something> array = new ArrayList<>();

    public static void main(String[] args) {
        TestArray testArray = new TestArray();
        Something something1 = new Something();
        Something something2 = new Something();
        Something something3 = new Something();
        Something something4 = new Something();
        Something something5 = new Something();
        Something something6 = new Something();


        testArray.addArray(something1);
        testArray.addArray(something2);
        testArray.addArray(something3);
        testArray.addArray(something4);
        testArray.addArray(something5);
        System.out.println(testArray.getArray());
        testArray.deleteElement(3);
        System.out.println(testArray.getArray());
        testArray.addArray(something6);
        System.out.println(testArray.getArray());


    }


    public void addArray(Something something) {

        if (array.isEmpty()) {
            something.setId(0);
            array.add(something);
            return;
        }
        for (int i = 0; i < array.size(); i++) {
            System.out.println(i);
            if (array.get(i).getId() == i) {
                continue;
            } else {
                something.setId(i);
                array.add(i, something);
            }

        }

    }

    public void deleteElement(int id) {
        array.remove(id);
    }

    public List<Something> getArray() {
        return array;
    }
}


class Something {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Something{" +
                "id=" + id +
                '}';
    }
}
