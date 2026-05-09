package dao;

import model.Usuario;
import util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Usuario autenticar(String email, String senha) {
        String sql = "SELECT id, nome, email, perfil FROM usuarios WHERE email = ? AND senha = ? LIMIT 1";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("perfil")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar usuario: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
