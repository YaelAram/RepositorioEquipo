public class TestLibro {
    public static void main(String[] args) throws Exception {
        System.out.println("Creando un nuevo libro:\n");
        Libro libro = new Libro("El principe", new String[]{"Nicolas Maquiavelo"}, "9791029901119", 90, Categoria.HISTORICO);
        System.out.println(libro);

        System.out.println("\nModificando el libro creado:\n");
        libro.setTitulo("Batman: Year One");
        libro.setAutores(new String[]{"Frank Miller", "David Mazzucchelli"});
        libro.setISBN("9781401235888");
        libro.setNumeroPaginas(148);
        libro.setCategoria(Categoria.COMIC);
        System.out.println(libro);

        System.out.println("\nAbriendo por primera vez el libro:\n");
        libro.abrir();
        libro.cambiarPagina(130);
        libro.cerrar();

        System.out.println("\nAbriendo por segunda vez el libro:\n");
        libro.abrirEnPagina(115);
        libro.guardarProgreso();
        libro.cambiarPagina(55);
        libro.cerrar();
    }
}
