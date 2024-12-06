package parkingLot.Exceptions;

public class GateNotFoundException extends  IllegalArgumentException {
    public GateNotFoundException(String message) {
        super(message);
    }
}
