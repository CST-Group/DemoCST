package actionselection.codelets.sensory;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import java.util.Arrays;
import java.util.List;

public class LightSensorCodelet extends Codelet {

    
    private Memory PositionsMO;
    private Memory LightIntensityMO;

    @Override
    public void accessMemoryObjects() {
        
        PositionsMO = getInput("PositionsMO");
        
        LightIntensityMO = getOutput("LightIntensityMO");
    }

    @Override
    public void calculateActivation() {

    }

    @Override
    public void proc() {
        
        List<List<Double>> allPositions = (List<List<Double>>) PositionsMO.getI();
        
        List<Double> lightPosition = allPositions.get(0); // lightPosition
        List<Double> visionLeftSensorPosition = allPositions.get(1); // visionLeftSensorPosition
        List<Double> visionRightSensorPosition = allPositions.get(2); // visionRightSensorPosition
        
        double distanceSensorLeftLight = calculateDistanceBetween(lightPosition, visionLeftSensorPosition);
        double distanceSensorRightLight = calculateDistanceBetween(lightPosition, visionRightSensorPosition);
        double intensityLeft = calculateLightIntensity(distanceSensorLeftLight);
        double intensityRight = calculateLightIntensity(distanceSensorRightLight);
        
        List<Double> intensityValues;       
        intensityValues = Arrays.asList(intensityLeft, intensityRight);
        LightIntensityMO.setI(intensityValues);
    }
    
    
    private static Double calculateDistanceBetween(List<Double> position1, List<Double> position2){ 
        double dx = position1.get(0) - position2.get(0);
        double dy = position1.get(1) - position2.get(1);
        double dz = position1.get(2) - position2.get(2);
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

        return distance;
    }
    
    public static Double calculateLightIntensity(Double distance){ 
        double potency = 1;
        double lightIntensity = potency / (4 * Math.PI * Math.pow(distance, 2));
        
        return lightIntensity;
    }
}
