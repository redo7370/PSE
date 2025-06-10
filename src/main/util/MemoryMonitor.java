/*
 * PSE - Periodic System of Elements (Learn and Information Application)
 * Copyright (C) 2025 Jim Feser
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Contact:
 *  Github: https://github.com/jimfeserHTW
 *
 * If this program interacts with users remotely through a computer network,
 * it must provide a way for users to get its source code, for example by
 * offering a “Source” link in the user interface (see section 13 of the AGPL).
 */

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