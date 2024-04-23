package tp1.ejercicio1;

public class FakeEmailSender implements Email{
    private StringBuffer correos;

    public FakeEmailSender() {
        this.correos = new StringBuffer();
    }

    @Override
    public void enviarEmail(String email) {
        this.correos.append(email);
    }

    public StringBuffer correos() {
        return correos;
    }
}
