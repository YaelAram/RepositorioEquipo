public class Libro {
    private String titulo;
    private String[] autores;
    private String ISBN;
    private int numeroPaginas;
    private Categoria categoria;
    private int paginaActual = 1;
    private int paginaProgreso = 1;
    private boolean estaAbierto = false;

    public Libro(String titulo, String[] autores, String ISBN, int numeroPaginas, Categoria categoria) {
        this.titulo = titulo;
        this.autores = autores;
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
        this.categoria = categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void abrir(){
        this.estaAbierto = true;
        System.out.println("Abriendo libro en pagina " + this.paginaProgreso);
    }

    public void abrirEnPagina(int pagina) throws Exception {
        this.cambiarPagina(pagina);
    }

    public void cambiarPagina(int pagina) throws Exception {
        if(!this.estaAbierto) this.abrir();
        if(pagina < 1) throw new Exception("Atributo pagina debe ser mayor a 1");
        if(pagina > this.numeroPaginas) throw new Exception("Atributo pagina debe ser menor a " + this.numeroPaginas);
        this.paginaActual = pagina;
        System.out.println("Moviendo a pagina " + pagina);
    }

    public void guardarProgreso(){
        this.paginaProgreso = this.paginaActual;
        System.out.println("Guardando progreso (Pagina: " + this.paginaProgreso + ")...");
    }

    public void cerrar(){
        this.guardarProgreso();
        this.estaAbierto = false;
        this.paginaActual = 1;
        System.out.println("Cerrando libro...");
    }

    @Override
    public String toString() {
        int autoresTam = this.autores.length;
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i<autoresTam ; i++) {
            if(i == (autoresTam - 1) && autoresTam > 1) str.append(" y ");
            else if (i > 0) str.append(", ");
            str.append(this.autores[i]);
        }
        str.append(" - ").append(this.titulo).append(". Categoria ").append(this.categoria);
        str.append(". ISBN: ").append(this.ISBN).append(". Paginas: ").append(this.numeroPaginas);
        return str.toString();
    }
}
