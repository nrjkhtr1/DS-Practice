class FooBar {
    private int n;  
    private volatile int count1 = 0;
    private volatile int count2 = 0;
    
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	while(count1 != i || count1!=count2);
            printFoo.run();
            count1 += 1;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(count2 != i || count2>=count1);
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            count2 += 1;
        }
    }
}