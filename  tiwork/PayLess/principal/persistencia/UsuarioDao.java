package persistencia;

import beans.Usuario;

public interface UsuarioDao {
 void cadastrarUsuario(Usuario u,String tipo);
 Usuario trazer(String login,String senha);
 void removerUsuario(Usuario u);
}
