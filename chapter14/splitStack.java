/* Write a method splitStack that takes a stack of integers as a parameter 
 * and splits it into negatives and non-negatives. The numbers in the stack 
 * should be rearranged so that all the negatives appear on the bottom of the 
 * stack and all the non-negatives appear on the top. In other words, if after 
 * this method is called you were to pop numbers off the stack, you would 
 * first get all the nonnegative numbers and then get all the negative 
 * numbers. It does not matter what order the numbers appear in as long as all 
 * the negatives appear lower in the stack than all the non-negatives. You 
 * may use a single queue as auxiliary storage.
 */
public void splitStack(Stack<Integer> s) {
    Queue<Integer> q = new LinkedList<Integer>();
    int numNegatives = 0;
            
    while(!s.isEmpty()) {
        if(s.peek() < 0)
            numNegatives++;
        q.add(s.pop());
    }
                                                    
    while(numNegatives > 0) {
        if(q.peek() < 0) {
            s.push(q.remove());
            numNegatives--;
        } else {
            q.add(q.remove());
        }
    }
    
    while(!q.isEmpty())
        s.push(q.remove());
}

/*
 Alternative way of doing this
*/
 public static void splitStack(Stack<Integer> myStack){
    Queue <Integer> myQ = new LinkedList<Integer>();
    Queue <Integer> myQN = new LinkedList<Integer>();
    while(!myStack.isEmpty()){
      
      int toPush = myStack.pop();
      if(toPush >= 0){myQ.add(toPush);}
      else{myQN.add(toPush);}
      
    
    }
    for(Integer num : myQN){myStack.push(num);}
    for(Integer num : myQ){myStack.push(num);}    
}
