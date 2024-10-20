interface EuropeanSocket {
    void provideElectricity();
}
interface AmericanSocket {
    void supplyElectricity();
}
class AmericanSocketImpl implements AmericanSocket {
    public void supplyElectricity() {

        System.out.println("Electricity supplied from American socket.");
    }
}
class SocketAdapter implements EuropeanSocket {
    private AmericanSocket americanSocket;
    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }
    public void provideElectricity() {

        americanSocket.supplyElectricity();
    }
}
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new AmericanSocketImpl();
        EuropeanSocket europeanSocket = new SocketAdapter(americanSocket);
        europeanSocket.provideElectricity();
    }
}
