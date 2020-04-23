/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dao.UsuarioDao;
import modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public class Negocio {

    public Negocio() {
    }
    
    public String autenticarUsuario(Usuario usuario){
        
        UsuarioDao usuarioDao= new UsuarioDao();
        Usuario u=usuarioDao.selectById(usuario.getUsuario());
        
        if(u != null){
           if(u.getClave().contentEquals(usuario.getClave())){
               return "success";
               
           }
        }
        return "Error";
    }
    public void  registraUsuario(Usuario usuario){
        
        UsuarioDao usuarioDao= new UsuarioDao();
        usuarioDao.insert(usuario);
        
    }
}
