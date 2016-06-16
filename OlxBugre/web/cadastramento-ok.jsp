<%@page import="modelo.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@include file="cabecalho-olx.jsp"%>

<%
    String msg = "" ;
    if (request.getParameter("txtEmail") == null 
            || request.getParameter("txtSenha") == null
            || request.getParameter("txtNome") == null){
        response.sendRedirect("index.jsp");
    } else {
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        String nome = request.getParameter("txtNome");
        
        UsuarioDAO dao = new UsuarioDAO();

        Usuario obj = new Usuario();
        obj.setEmail(email);
        obj.setSenha(senha);
        obj.setNome(nome);
        
        try {
            dao.incluir(obj);
            msg = "Registro cadastrado com sucesso";
        } catch (Exception ex) {
            msg = "Erro ao cadastrar registro";
        }

    }
%>

<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
    <div class="mdl-card mdl-cell mdl-cell--12-col">
        <div class="mdl-card__supporting-text ">
            <h4>Usuario - Cadastrar</h4>
            <%=msg%>.
            <a href="index.jsp"><i class="material-icons">Pagina Inicial</i></a>
            
        </div>

    </div>

</section>

<%@include file="rodape-index.jsp"%>
