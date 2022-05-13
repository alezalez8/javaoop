package com.company.lesson8.hw8.mystack;

public class Stack {

    private Object[] stack;
    private BlackList blacklist;

    public Stack() {
        super();
    }

    public Stack(BlackList blacklist) {
        super();
        stack = new Stack[0];
        this.blacklist = blacklist;
    }

    public void add(Object addObj) {
        if (!blacklist.exists(addObj)) {
            Object[] created = new Object[stack.length + 1];
            for (int i = 0; i < stack.length; i++) created[i] = stack[i];
            stack = created;
            for (int i = 0; i < stack.length; i++) {
                if (stack[i] == null) {
                    stack[i] = addObj;
                    System.out.println(addObj.getClass() + " was successfully added to the stack.");
                    return;
                }
            }
        } else System.out.println(addObj.getClass() + " wasn't added because this class was found in the black list.");
    }

    public Object copyElement() {
        if (stack.length == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        System.out.println("\nTop element '" + stack[stack.length - 1] + "' was only copied from the stack");
        return stack[stack.length - 1];
    }

    public Object copyElementAndDelete() {
        if (stack.length == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        System.out.println("\nTop element '" + stack[stack.length - 1] + "' was copied and deleted from the stack");
        Object saved = stack[stack.length - 1];
        Object[] created = new Object[stack.length - 1];
        for (int i = 0; i < stack.length - 1; i++) created[i] = stack[i];
        stack = created;
        return saved;
    }

    @Override
    public String toString() {
        if (stack.length == 0) return "\nStack is empty\n";
        StringBuilder sb = new StringBuilder();
        sb.append("\nStack contains:");
        for (Object i : stack) {
            sb.append("\n- " + i.getClass() + " (" + i + ")");
        }
        return sb.toString();
    }
}

class BlackList {
    public  boolean exists(Object obj) {
        return true;
    }


}
