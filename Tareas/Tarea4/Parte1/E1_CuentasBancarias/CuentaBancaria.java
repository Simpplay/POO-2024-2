package Tareas.Tarea4.Parte1.E1_CuentasBancarias;

public abstract class CuentaBancaria {

    protected float saldo;
    protected int consignaciones;
    protected int retiros;
    protected float tasaAnual;
    protected float comision;

    public CuentaBancaria(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.consignaciones = 0;
        this.retiros = 0;
        this.tasaAnual = tasaAnual;
        this.comision = 0;
    }

    public void consignar(float cantidad) {
        if (cantidad <= 0) {
            System.out.println("No se puede consignar esa cantidad, el valor debe ser mayor a 0");
            return;
        }
        saldo += cantidad;
        consignaciones++;
    }

    public void retirar(float cantidad) {
        if (cantidad > saldo) {
            System.out.println("No se puede retirar esa cantidad, saldo insuficiente");
            return;
        }
        saldo -= cantidad;
        retiros++;
    }

    public void calcularInteres() {
        saldo += saldo * (tasaAnual / 12);
    }

    public void extractoMensual() {
        saldo -= comision;
        calcularInteres();
    }

    public void mostrarSaldo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Saldo: " + saldo +
                "\nConsignaciones: " + consignaciones +
                "\nRetiros: " + retiros +
                "\nTasa Anual: " + tasaAnual +
                "\nComision: " + comision;
    }
}
