/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ilana
 */
public class Stack implements Iterable {
    
    public ArrayList stack;
    
    public Stack() {
        stack = new ArrayList();
    }
    
    public Iterator iterator() {
        return stack.iterator();
    }
    
    public int size() {
        return stack.size();
    }
    
    public void push(Object a) {
        stack.add(a);
    }
    
    public Object pop() {
        if( ! stack.isEmpty()) {
            Object ans = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return ans;
        }
        return null;
    }
    
    public Object peek() {
        return stack.get(stack.size()-1);
    }
    
    public Object peek(int index) {
        return stack.get(index);
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
