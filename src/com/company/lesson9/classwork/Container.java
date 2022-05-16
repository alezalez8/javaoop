package com.company.lesson9.classwork;

public class Container <T extends Number>{
    private Object element;

    public Container(T element) {
        super();
        this.element = element;
    }

    public T getElement() {
        return (T) element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Container [element=" + element + "]";
    }
}
