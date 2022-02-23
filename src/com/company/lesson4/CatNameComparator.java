package com.company.javaoop.lesson4;

import java.util.Comparator;

public class CatNameComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
/*
*   @Override
  public int compare(Object o1, Object o2) {
    Cat cat1 = (Cat) o1;
    Cat cat2 = (Cat) o2;

    String name1 = cat1.getName();
    String name2 = cat2.getName();

    if (name1.compareTo(name2) > 0) {
      return 1;
    }
    if (name1.compareTo(name2) < 0) {
      return -1;
    }
    return 0;
  }
* */