public class Frame implements IFrame { 
    private byte[] data; 
    Frame(byte[] d)
    { 
        this.data=d; 
    }

    public byte[] getData() {
        return this.data;
    }

}
