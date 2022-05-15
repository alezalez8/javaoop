package com.company.lesson8.hw8.mystack;

import java.util.Arrays;

public class MyStack {

    private int sizeOfStack = 4;
    private int amountOfnotNullElement = 0;
    private Object[] stackArray = new Object[sizeOfStack];

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(Arrays.toString(myStack.getStackArray()));
        String obj1 = "Hello";
        String obj2 = "World";
        Boolean isSomething = true;
        Integer x = 100;
        Double y = 20.5;
        Object object = new MyStack();

        myStack.push(obj1);
        System.out.println(Arrays.toString(myStack.getStackArray()));
        myStack.push(obj2);
        System.out.println(Arrays.toString(myStack.getStackArray()));
        myStack.push(x);
        System.out.println(Arrays.toString(myStack.getStackArray()));
        myStack.push(y);
        System.out.println(Arrays.toString(myStack.getStackArray()));
        myStack.push(obj1);
        System.out.println(Arrays.toString(myStack.getStackArray()));
        myStack.push(isSomething);
        System.out.println(Arrays.toString(myStack.getStackArray()));
        myStack.push(object);
        System.out.println(Arrays.toString(myStack.getStackArray()));

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(Arrays.toString(myStack.getStackArray()));
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(Arrays.toString(myStack.getStackArray()));
        System.out.println(myStack.pop());
        System.out.println(Arrays.toString(myStack.getStackArray()));

    }


    public void push(Object object) {            // add element into stack
        Object temp;
        if (amountOfnotNullElement >= sizeOfStack) {
            stackArray = newSizeOfArrayObjects(stackArray);
        }
        for (int i = sizeOfStack - 1; i > 0; i--) {
            if (stackArray[i - 1] != null) {  // reduce swap null-elements
                temp = stackArray[i];
                stackArray[i] = stackArray[i - 1];
                stackArray[i - 1] = temp;
            }
        }
        stackArray[0] = object;
        amountOfnotNullElement++;
    }

    public Object pop() {                // get and delete stack's top elemement
        Object temp = peek();
        int tempOfNull =  amountOfnotNullElement;
        if (amountOfnotNullElement != 0) {    // сдвиг влево
            for (int i = 0; i < sizeOfStack - 1; i++) {
                stackArray[i] = stackArray[i + 1];
            }
            stackArray[tempOfNull] = null; // add null to end of queuu of present elements
        }
        return temp;
    }

    public Object peek() {                       // get  stack's top elemement
        if (stackArray[0] == null) {
            System.out.println("Stack is empty");
            return null;
        }
        return stackArray[0];
    }

    public Object[] getStackArray() {
        return stackArray;
    }

    private Object[] newSizeOfArrayObjects(Object[] array) {
        sizeOfStack = sizeOfStack / 2 + sizeOfStack;
        Object[] newArrayObject;
        newArrayObject = Arrays.copyOf(array, sizeOfStack);
        return newArrayObject;
    }

    @Override
    public String toString() {
        return "my stack";
    }
}