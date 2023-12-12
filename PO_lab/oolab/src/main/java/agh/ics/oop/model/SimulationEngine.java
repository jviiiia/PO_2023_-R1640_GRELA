package agh.ics.oop.model;

import agh.ics.oop.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimulationEngine {
    private List<Simulation> simulations;
    private List<Future<?>> futures = new ArrayList<>();
    private ExecutorService executorService;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        executorService = Executors.newFixedThreadPool(simulations.size());
        for (Simulation simulation : simulations) {
            futures.add(executorService.submit(simulation::run));
        }
        executorService.shutdown();
    }

    public void runAsyncInThreadPool() {
        executorService = Executors.newFixedThreadPool(4);
        for (Simulation simulation : simulations) {
            futures.add(executorService.submit(simulation::run));
        }
        executorService.shutdown();
    }

    public void awaitSimulationsEnd() {
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdownNow();
    }
}
