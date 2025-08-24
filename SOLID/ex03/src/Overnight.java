public class Overnight extends Shipment {


    Overnight(double w) {
        super(w);
    }

    @Override
    double getCoast() {
        return 120 + 10*this.weightKg;
    }
    
}
