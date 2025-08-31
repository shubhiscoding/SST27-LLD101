public class Standard extends Shipment{

    Standard(double w) {
        super(w);
    }

    double getCoast(){
        return 50 + 5*this.weightKg;
    }
    
}
