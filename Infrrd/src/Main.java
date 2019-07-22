class Stack {
    static final int MAX = 1000;
    int top=-1, top_ms = -1;
    int a[] = new int[MAX];
    int max_stack[] = new int[MAX];

    boolean push(int x)
    {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            int max_value = a[top];
            // System.out.println(max_value + " max value");
            if( top_ms == -1 || max_stack[top_ms] < max_value)
            {
                max_stack[++top_ms] = max_value ;

            }
            else {
                return true;
            }
            return true;
        }
    }

    int pop()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = a[top--];
            if(max_stack[top_ms] == x){
                int mv = max_stack[top_ms--];
                return x;
            }
            else
            {
                return x;

            }

        }
    }

    int peek()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = max_stack[top_ms];
            return x;
        }
    }

}

// Driver code
class Main {
    public static void main(String args[])
    {
        Stack s = new Stack();
        s.push(10);
        s.push(50);
        s.push(40);
        s.push(80);
       // s.pop();
        s.pop();
        s.pop();
        int max = s.peek();
        System.out.println(max+" Max value");

    }
}
