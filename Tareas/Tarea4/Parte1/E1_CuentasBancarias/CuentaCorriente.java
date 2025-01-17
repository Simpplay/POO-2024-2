package Tareas.Tarea4.Parte1.E1_CuentasBancarias;

public class CuentaCorriente extends CuentaBancaria {

    protected float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        float nuevoSaldo = saldo - cantidad;
        if (nuevoSaldo < 0) {
            sobregiro = sobregiro - nuevoSaldo;
            saldo = 0;
            return;
        }
        super.retirar(cantidad);
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro <= 0) {
            super.consignar(cantidad);
            return;
        }
        float nuevoSobregiro = sobregiro - cantidad;
        if (nuevoSobregiro > 0) {
            sobregiro = 0;
            saldo = nuevoSobregiro;
        } else {
            sobregiro = -nuevoSobregiro;
            saldo = 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSobregiro: " + sobregiro;
    }
}
