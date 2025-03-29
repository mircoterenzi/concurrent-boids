package pcd.ass01.sequential;

import pcd.ass01.Boid;
import pcd.ass01.BoidsView;
import pcd.ass01.BoidsModel;
import pcd.ass01.BoidsSimulator;

import java.util.Optional;

public class SequentialBoidsSimulator extends BoidsSimulator {

    public SequentialBoidsSimulator(BoidsModel model) {
        super(model);
    }

    @Override
    public void runSimulation() {
    	while (true) {
            var t0 = System.currentTimeMillis();
    		var boids = model.getBoids();

            if (!model.isPaused()) {
                for (Boid boid : boids) {
                    boid.updateVelocity(model);
                }

                for (Boid boid : boids) {
                    boid.updatePos(model);
                }
            }

            updateView(t0);
    	}
    }
}
