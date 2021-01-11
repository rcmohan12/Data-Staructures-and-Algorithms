package com.rcm.dataStructure.queue;
import com.rcm.dataStructure.Stack.MyStack;

public class QueueUsingStack {
    private MyStack _pushStack;
    private MyStack _popStack;

   QueueUsingStack() {
       _pushStack = new MyStack();
       _popStack = new MyStack();
   }

   public void enqueue(String val) {
       _pushStack.push(val);
   }

   public String dequeue() {
       if(_popStack.isEmpty()) {
           if(_pushStack.isEmpty()) {
               return "The queue is empty";
           } else {
               while (!_pushStack.isEmpty()) {
                   _popStack.push(_pushStack.pop());
               }
               return _popStack.pop();
           }
       } else {
           return _popStack.pop();
       }
   }

   public String peek() {
       if(_popStack.isEmpty()) {
           if(_pushStack.isEmpty()) {
               return "The queue is empty";
           } else {
               while (!_pushStack.isEmpty()) {
                   _popStack.push(_pushStack.pop());
               }
               return _popStack.peek();
           }
       } else {
           return _popStack.peek();
       }
   }

    @Override
    public String toString() {
        return "QueueUsingStack{" +
                "stack=" + _pushStack +
                '}';
    }
}

class TestThis {
    public static void main(String[] args) {
        QueueUsingStack qs = new QueueUsingStack();
        qs.enqueue("Sie");
        qs.enqueue("ist");
        qs.enqueue("eine");
        System.out.println("Peek ---->"+qs.peek());
        System.out.println(qs.dequeue());
        System.out.println("Peek ---->"+qs.peek());
        System.out.println(qs.dequeue());
        System.out.println("Peek ---->"+qs.peek());
        System.out.println(qs.dequeue());
        qs.enqueue("schone");
        qs.enqueue("frau");
        System.out.println(qs);
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
    }
}
