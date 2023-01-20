public class Forma {

    public static class mainPintura {
        public static void main(String[] arg) {
            String br = "----------------------------------------------------------------";

            Pintura a = new Pintura(250);

            Esfera b = new Esfera(15);
            System.out.println(br);
            System.out.println(b.toString());
            System.out.println("Área: "+a.cantidadPintura(b));
            System.out.println(br);

            Rectangulo c = new Rectangulo(20, 35);
            System.out.println(c.toString());
            System.out.println("Área: "+a.cantidadPintura(c));
            System.out.println(br);

            Cilindro d = new Cilindro(10, 30);
            System.out.println(d.toString());
            System.out.println("Área: "+a.cantidadPintura(d));
            System.out.println(br);
        }
    }

    private String nombre;

    public Forma(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double area() {
        return 0;
    }

    @Override
    public String toString() {
        return "Forma{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public static class Esfera extends Forma {
        private double radio;

        public Esfera(double radio) {
            super("Esfera");
            this.radio = radio;
        }

        public double area() {
            return 4 * Math.PI * Math.pow(radio, 2);
        }

        @Override
        public String toString() {
            return "Esfera{" +
                    "nombre='" + getNombre() + '\'' +
                    ", radio=" + radio +
                    '}';
        }
    }

    public static class Rectangulo extends Forma {
        private double longitud;
        private double ancho;

        public Rectangulo(double longitud, double ancho) {
            super("Rectangulo");
            this.longitud = longitud;
            this.ancho = ancho;
        }

        public double area() {
            return longitud * ancho;
        }

        @Override
        public String toString() {
            return "Rectangulo{" +
                    "nombre='" + getNombre() + '\'' +
                    ", longitud=" + longitud +
                    ", acho=" + ancho +
                    '}';
        }
    }

    public static class Cilindro extends Forma {
        private double radio;
        private double altura;

        public Cilindro(double radio, double altura) {
            super("Cilindro");
            this.radio = radio;
            this.altura = altura;
        }

        public double area() {
            return Math.PI * Math.pow(radio, 2) * altura;
        }

        @Override
        public String toString() {
            return "Cilindro{" +
                    "nombre='" + getNombre() + '\'' +
                    ", radio=" + radio +
                    ", altura=" + altura +
                    '}';
        }
    }

    public static class Pintura {
        private double cobertura;

        public double getCobertura() {
            return this.cobertura;
        }

        public Pintura(double cobertura) {
            this.cobertura = cobertura;
        }

        public double cantidadPintura (Forma obj) {
            return (obj.area() / cobertura);
        }
    }
}
