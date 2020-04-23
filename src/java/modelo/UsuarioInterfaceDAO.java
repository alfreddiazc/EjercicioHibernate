/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public interface UsuarioInterfaceDAO {
    
    public Usuario selectById(String Usuario);
    public List<Usuario> selectAll();
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);
}
