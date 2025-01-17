package Tareas.Tarea4.Parte1.E1_CuentasBancarias;

public class CuentaAhorros extends CuentaBancaria {

    protected boolean isActive;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        checkActive();
    }

    public void checkActive() {
        isActive = saldo >= 10000;
    }

    @Override
    public void retirar(float cantidad) {
        if (!isActive) return;
        super.retirar(cantidad);
    }

    @Override
    public void consignar(float cantidad) {
        if (!isActive) return;
        super.consignar(cantidad);
    }

    @Override
    public void extractoMensual() {
        if (retiros > 4) comision += (retiros - 4) * 1000;
        super.extractoMensual();
        checkActive();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEstado: " + (isActive ? "Activa" : "Inactiva");
    }
}
