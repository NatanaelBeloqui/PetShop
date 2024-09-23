import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    static ArrayList<Tutor> tutores = new ArrayList<Tutor>();
    static ArrayList<Animal> animais = new ArrayList<Animal>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        try {
            do {

                System.out.println("[1] Cadastrar Categoria");
                System.out.println("[2] Cadastrar Tutor");
                System.out.println("[3] Cadastrar Animal");
                System.out.println("[4] Listar Categoria");
                System.out.println("[5] Listar Tutor");
                System.out.println("[6] Listar Animal");
                System.out.println("[7] Encerrar");
                System.out.print("Opção: ");
                opcao = scanner.nextInt();

                if (opcao < 1 || opcao > 7) {
                    System.out.println("\nOpção inválida. Selecione uma opção válida.");
                }

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o ID da categoria: ");
                        int idCategoria = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o nome da categoria: ");
                        String nomeCategoria = scanner.nextLine();
                        System.out.print("Faça uma descrição da categoria: ");
                        String descricao = scanner.nextLine();

                        Categoria categoria = new Categoria(idCategoria, nomeCategoria, descricao);
                        categorias.add(categoria);
                        break;
                    case 2:
                        System.out.print("Digite o ID do tutor: ");
                        int idTutor = scanner.nextInt();
                        System.out.print("Digite o nome do tutor: ");
                        String nomeTutor = scanner.nextLine();
                        System.out.print("Digite o telefone do tutor: ");
                        String telefoneTutor = scanner.nextLine();
                        System.out.print("Digite o email do tutor: ");
                        String emailTutor = scanner.nextLine();

                        Tutor tutor = new Tutor(idTutor, nomeTutor, telefoneTutor, emailTutor);
                        tutores.add(tutor);
                        break;
                    case 3:
                        System.out.print("Digite o ID do animal: ");
                        int idAnimal = scanner.nextInt();
                        System.out.print("Digite o nome do animal: ");
                        String nomeAnimal = scanner.nextLine();
                        System.out.print("Digite a raça do animal: ");
                        String racaAnimal = scanner.nextLine();
                        System.out.print("Digite o peso em kg do animal: ");
                        float pesoAnimal = scanner.nextFloat(); // Corrigido para float
                        System.out.print("Digite o Id da categoria do animal: ");
                        int idCategoriaAnimal = scanner.nextInt();
                        System.out.print("Digite o Id do tutor do animal: ");
                        int idTutorAnimal = scanner.nextInt();

                        Categoria categoriaAnimal = buscarCategoria(idCategoriaAnimal);
                        Tutor tutorAnimal = buscaTutor(idTutorAnimal);

                        if (categoriaAnimal != null && tutorAnimal != null) {
                            Animal animal = new Animal(idAnimal, nomeAnimal, racaAnimal, pesoAnimal, categoriaAnimal, tutorAnimal);
                            animais.add(animal);
                            System.out.println("Animal cadastrado.");
                        } else {
                            System.out.println("Categoria ou tutor não encontrados.");
                        }
                        break;
                    case 4:
                        listarCategorias();
                        break;
                    case 5:
                        listarTutores();
                        break;
                    case 6:
                        listarAnimais();
                        break;
                    case 7:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        break;
                }

            } while (opcao != 7);
        } catch (Exception e) {
            System.out.println("\nVocê digitou valores inválidos. Execute novamente.");
        } finally {
            scanner.close();
        }
    }

    private static Categoria buscarCategoria(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.idCategoria == id) { // Corrigido
                return categoria;
            }
        }
        return null;
    }

    private static Tutor buscaTutor(int id) {
        for (Tutor tutor : tutores) {
            if (tutor.idTutor == id) { // Corrigido
                return tutor;
            }
        }
        return null;
    }

    private static void listarCategorias() {
        System.out.println("Categorias cadastradas:");
        for (Categoria categoria : categorias) {
            System.out.println("ID: " + categoria.idCategoria + ", Descrição: " + categoria.descricao);

            int contagemAnimais = 0;
            for (Animal animal : animais) {
                if (animal.idCategoria.idCategoria == categoria.idCategoria) { // Corrigido
                    contagemAnimais++;
                }
            }
            System.out.println("Contagem de animais nessa categoria: " + contagemAnimais);
        }
    }

    private static void listarTutores() {
        System.out.println("Tutores cadastrados:");
        for (Tutor tutor : tutores) {
            System.out.println("ID: " + tutor.idTutor + ", Nome: " + tutor.nome);

            int contagemAnimais = 0;
            for (Animal animal : animais) {
                if (animal.idTutor.idTutor == tutor.idTutor) { // Corrigido
                    contagemAnimais++;
                }
            }
            System.out.println("Contagem de animais desse tutor: " + contagemAnimais);
        }
    }

    private static void listarAnimais() {
        System.out.println("Animais cadastrados:");
        for (Animal animal : animais) {
            System.out.println("ID: " + animal.idAnimal +
                               ", Nome: " + animal.nome +
                               ", Nome do Tutor: " + animal.idTutor.nome +
                               ", Descrição da Categoria: " + animal.idCategoria.descricao);
        }
    }
}