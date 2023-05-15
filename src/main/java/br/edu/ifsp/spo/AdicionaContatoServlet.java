package br.edu.ifsp.spo;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionaContato")
  public class AdicionaContatoServlet extends HttpServlet {
      private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
              HttpServletResponse response)
              throws IOException, ServletException {

          PrintWriter out = response.getWriter();

          // pegando os parâmetros do request
          String nome = request.getParameter("nome");
          String endereco = request.getParameter("endereco");
          String email = request.getParameter("email");
          String dataEmTexto = request.getParameter("dataNascimento");
          LocalDate dataNascimento = null;
           
          
          try {
        	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	    dataNascimento = LocalDate.parse(dataEmTexto, formatter);
        	} catch (DateTimeParseException e) {
        	    out.println("Erro de conversão da data");
        	    return; //para a execução do método
        	}
          

//          // fazendo a conversão da data
//          try {
//              Date date = new SimpleDateFormat("dd/MM/yyyy")
//                      .parse(dataEmTexto);
//              dataNascimento = Calendar.getInstance();
//              dataNascimento.setTime(date);
//          } catch (ParseException e) {
//              out.println("Erro de conversão da data");
//              return; //para a execução do método
//          }

          // monta um objeto contato
          Contato contato = new Contato(nome, endereco, email, dataNascimento);

          // salva o contato
          ContatoDao dao = new ContatoDao();
          dao.add(contato);

          // imprime o nome do contato que foi adicionado
          out.println("<html>");
          out.println("<body>");
          out.println("Contato " + contato.getNome() +
                  " adicionado com sucesso");       
          out.println("</body>");
          out.println("</html>");
      }
  }
