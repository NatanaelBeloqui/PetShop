public class Animal {
    int idAnimal;
    String nome;
    String raca;
    float peso;
    Categoria idCategoria; // Chave estrangeira da classe Categoria
    Tutor idTutor; // Chave estrangeira da classe Tutor

    public Animal(
        int idAnimal,
        String nome,
        String raca,
        float peso,
        Categoria idCategoria,
        Tutor idTutor
    ) {
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
        this.idCategoria = idCategoria;
        this.idTutor = idTutor;
    }
}
