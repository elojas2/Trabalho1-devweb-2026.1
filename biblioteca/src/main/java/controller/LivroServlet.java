package controller;
import dao.LivroDAO;
import model.Livro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/livros/*")
public class LivroServlet extends HttpServlet {

	private LivroDAO dao = new LivroDAO();

	// GET → listar livros, abrir formulário de cadastro, editar ou excluir
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String pathInfo = req.getPathInfo(); // null, "/" ou "/cadastrar", "/editar", "/excluir"

		if ("/cadastrar".equals(pathInfo)) {
			req.getRequestDispatcher("/WEB-INF/views/cadastrar.jsp").forward(req, resp);
			return;
		}

		if ("/editar".equals(pathInfo)) {
			try {
				int id = Integer.parseInt(req.getParameter("id"));
				Livro livro = dao.buscarPorId(id);
				if (livro == null) {
					resp.sendRedirect(req.getContextPath() + "/livros");
					return;
				}
				req.setAttribute("livro", livro);
				req.getRequestDispatcher("/WEB-INF/views/editar.jsp").forward(req, resp);
			} catch (NumberFormatException e) {
				resp.sendRedirect(req.getContextPath() + "/livros");
			}
			return;
		}

		// default: listar
		List<Livro> lista = dao.listarTodos();
		req.setAttribute("livros", lista);
		req.getRequestDispatcher("/WEB-INF/views/listar.jsp").forward(req, resp);
	}

	// POST → cadastrar ou atualizar livro
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String pathInfo = req.getPathInfo();

		// POST /livros/excluir — exclusão segura
		if ("/excluir".equals(pathInfo)) {
			try {
				int id = Integer.parseInt(req.getParameter("id"));
				dao.remover(id);
			} catch (NumberFormatException e) {
				// id inválido, ignora
			}
			resp.sendRedirect(req.getContextPath() + "/livros");
			return;
		}

		// POST /livros/editar ou POST /livros — cadastrar/atualizar
		try {
			String titulo = req.getParameter("titulo");
			String autor = req.getParameter("autor");
			int ano = Integer.parseInt(req.getParameter("ano"));
			boolean disponivel = Boolean.parseBoolean(req.getParameter("disponivel"));

			Livro livro = new Livro();
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setAno(ano);
			livro.setDisponivel(disponivel);

			if ("/editar".equals(pathInfo)) {
				int id = Integer.parseInt(req.getParameter("id"));
				livro.setId(id);
				dao.atualizar(livro);
			} else {
				dao.cadastrar(livro);
			}
		} catch (NumberFormatException e) {
		}

		resp.sendRedirect(req.getContextPath() + "/livros");
	}
}
