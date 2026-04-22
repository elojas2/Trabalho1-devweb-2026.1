
package dao;
import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    // lista simulando um banco de dados
    private static List<Livro> livros = new ArrayList<>();
    private static int proximoId = 1;

    static {
        livros.add(new Livro(proximoId++, "Dom Casmurro", "Machado de Assis", 1899, true));
        livros.add(new Livro(proximoId++, "O Cortiço", "Aluísio Azevedo", 1890, false));
        livros.add(new Livro(proximoId++, "Grande Sertão: Veredas", "Guimarães Rosa", 1956, true));
        livros.add(new Livro(proximoId++, "Capitães da Areia", "Jorge Amado", 1937, false));
    }

    public List<Livro> listarTodos() {
        return livros;
    }

    public void cadastrar(Livro livro) {
        livro.setId(proximoId++);
        livros.add(livro);
    }

    public Livro buscarPorId(int id) {
        return livros.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void remover(int id) {
        livros.removeIf(l -> l.getId() == id);
    }

    public void atualizar(Livro livroAtualizado) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == livroAtualizado.getId()) {
                livros.set(i, livroAtualizado);
                break;
            }
        }
    }
}