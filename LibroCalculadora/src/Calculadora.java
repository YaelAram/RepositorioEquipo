public class Calculadora {
    private float operando1;
    private float operando2;

    public Calculadora(float operando1, float operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    public float getOperando1() {
        return operando1;
    }

    public void setOperando1(float operando1) {
        this.operando1 = operando1;
    }

    public float getOperando2() {
        return operando2;
    }

    public void setOperando2(float operando2) {
        this.operando2 = operando2;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Calculadora{" +
                "El operando 1 es: " + operando1 +
                ", El operando 2 es: " + operando2 +
                '}';
    }


    public void suma(){
        float adicion = operando1 + operando2;
        System.out.println("El resultado de la suma es: "+adicion);
    }
}
