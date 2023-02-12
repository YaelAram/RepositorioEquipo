public enum Categoria {
    HISTORICO("Historico"),
    COMIC("Comic");

    private final String categoria;

    Categoria(String categoria){
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return this.categoria;
    }
}
