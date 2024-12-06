package parkingLot.Repositories;

import parkingLot.Models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gates;
    private Long id;
    public GateRepository() {
        gates = new HashMap<>();
        id = 0l;
    }

    public Gate save(Gate gate) {
        //works as Update + Insert -> Upsert
        if(gate.getId()==0) {
            gate.setId(id);
            gates.put(++id,gate);
        }
        else {
            gates.put(gate.getId(),gate);
        }

        return gate;
    }

    public Optional<Gate> findById(Long id) {
        if(gates.containsKey(id)) {
            return Optional.of(gates.get(id));
        }
        else {
            return Optional.empty();
        }
    }
}
