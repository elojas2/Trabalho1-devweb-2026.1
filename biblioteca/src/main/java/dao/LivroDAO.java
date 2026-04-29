package dao;

import model.Livro;
import util.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public List<Livro> listarTodos() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT id, titulo, autor, ano, disponivel FROM livros ORDER BY id DESC";

        try (Connection conn = ConexaoDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano"),
                        rs.getBoolean("disponivel")
                );
                livros.add(livro);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar livros: " + e.getMessage());
            e.printStackTrace();
        }

        return livros;
    }

    public void cadastrar(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, ano, disponivel) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setInt(3, livro.getAno());
            pstmt.setBoolean(4, livro.isDisponivel());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new IllegalStateException("Falha ao cadastrar livro: nenhuma linha foi inserida.");
            }

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    livro.setId(rs.getInt(1));
                } else {
                    throw new IllegalStateException("Falha ao cadastrar livro: nenhuma chave gerada foi retornada.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar livro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Livro buscarPorId(int id) {
        String sql = "SELECT id, titulo, autor, ano, disponivel FROM livros WHERE id = ?";
        Livro livro = null;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    livro = new Livro(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("ano"),
                            rs.getBoolean("disponivel")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar livro por ID: " + e.getMessage());
            e.printStackTrace();
        }

        return livro;
    }

    public void atualizar(Livro livroAtualizado) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, ano = ?, disponivel = ? WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, livroAtualizado.getTitulo());
            pstmt.setString(2, livroAtualizado.getAutor());
            pstmt.setInt(3, livroAtualizado.getAno());
            pstmt.setBoolean(4, livroAtualizado.isDisponivel());
            pstmt.setInt(5, livroAtualizado.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar livro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao remover livro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}