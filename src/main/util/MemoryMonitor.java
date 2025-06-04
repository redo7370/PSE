package main.util;

/**
 * MemoryMonitor is a utility class that monitors the Java Virtual Machine's (JVM) memory usage.
 * It runs in a separate thread and periodically logs the used, free, total, and maximum heap memory.
 * This class is useful for debugging and performance monitoring during development.
 * 
 * <p>
 * The memory usage is reported in megabytes (MB) and updated every second.
 * </p>
 */
public class MemoryMonitor implements Runnable {

    /**
     * Flag to control the running state of the memory monitor thread.
     * When set to false, the thread will stop monitoring and exit.
     */
    private volatile boolean running = true;

    /**
     * Starts the memory monitor thread.
     * The thread will log memory usage until stopped.
     */
    public MemoryMonitor() {

    }

    /**
     * Starts the memory monitor thread.
     * The thread will log memory usage until stopped.
     */
    public void stop() {
        running = false;
    }

    /**
     * The main method to run the MemoryMonitor.
     * This method is intended to be run in a separate thread.
     */
    @Override
    public void run() {
        Runtime runtime = Runtime.getRuntime();

        while (running) {
            
            long usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
            long freeMemory = runtime.freeMemory() / (1024 * 1024);
            long totalMemory = runtime.totalMemory() / (1024 * 1024);
            long maxMemory = runtime.maxMemory() / (1024 * 1024);

            System.out.printf("Heap used: %d MB, free: %d MB, total: %d MB, max: %d MB%n",
                    usedMemory, freeMemory, totalMemory, maxMemory);

            try {
                Thread.sleep(1000);  // alle 0,5 Sekunden aktualisieren
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}


