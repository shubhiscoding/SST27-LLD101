public class Express extends Shipment {

    Express(double w) {
        super(w);
    }

    @Override
    double getCoast() {
        return 80 + 8*this.weightKg;
    }
 
}
