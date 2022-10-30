import java.util.concurrent.*;
class H2O {
    Semaphore outputting;
    Semaphore outputHydrogen, outputOxygen;
    public H2O() {
        outputting = new Semaphore(1);
        outputHydrogen = new Semaphore(0);
        outputOxygen = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        //we only "output an H" when oxygen says so
        outputHydrogen.acquire();
		releaseHydrogen.run();
        outputOxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        //we only output 1 complete H2O set at a time.
        outputting.acquire();
        
		outputHydrogen.release(2); //tell 2 Hydrogen threads to output an H.
		releaseOxygen.run();       //output an O
		//we wait for 2 hydrogens to finish printing
        outputOxygen.acquire(2);
        
        outputting.release();  //outputting is back to 1. Ready for another H2O cycle.
    }
}