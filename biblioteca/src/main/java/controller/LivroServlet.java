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
			int id = Integer.parseInt(req.getParameter("id"));
			Livro livro = dao.buscarPorId(id);
			req.setAttribute("livro", livro);
			req.getRequestDispatcher("/WEB-INF/views/editar.jsp").forward(req, resp);
			return;
		}

		if ("/excluir".equals(pathInfo)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.remover(id);
			resp.sendRedirect(req.getContextPath() + "/livros");
			return;
		}

		List<Livro> lista = dao.listarTodos();
		req.setAttribute("livros", lista);
		req.getRequestDispatcher("/WEB-INF/views/listar.jsp").forward(req, resp);
	}

	// POST → cadastrar ou atualizar livro
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String pathInfo = req.getPathInfo();
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

		resp.sendRedirect(req.getContextPath() + "/livros");
	}
}
