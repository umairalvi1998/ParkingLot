package parkingLot.Factory;

import parkingLot.Models.SpotAssignmentStrategyType;
import parkingLot.SpotAssignmentStrategy.CheapestSpotAssignmentStrategy;
import parkingLot.SpotAssignmentStrategy.RandomSpotAssignmentStrategy;
import parkingLot.SpotAssignmentStrategy.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType assignmentStrategyType) {
        return switch (assignmentStrategyType) {
            case NEAREST_TO_ELEVATOR, NEAREST_TO_MULTIPLEX -> null;
            case CHEAPEST -> new CheapestSpotAssignmentStrategy();
            case RANDOM -> new RandomSpotAssignmentStrategy();
        };
    }
}
