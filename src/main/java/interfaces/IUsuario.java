package interfaces;

import model.TblUsuariocl3;

public interface IUsuario {
	
	public void RegistrarUsuario(TblUsuariocl3 usuario);
	public TblUsuariocl3 AutenticarUsuario (String usuario, String password);

}
