/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ejb;

import app.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author elmen
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal{

    @PersistenceContext(unitName = "TrelloFake-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    /**
     *
     * @param usuario
     * @param clave
     * @return
     */
    @Override
    public List<Usuario> findByLogin(String usuario, String clave) {
       return em.createQuery("Select u FROM Usuario u WHERE u.usuario = :u and u.clave = :k")
                .setParameter("u", usuario)
                .setParameter("k", clave)
                .getResultList();
    }

    @Override
    public Usuario findByIdUsuario(Integer id) {
        return (Usuario) em.createNamedQuery("Usuario.findByIdUsuario").setParameter("idUsuario", id).getSingleResult();
    }

    @Override
    public List<Usuario> findByUsuario(String usuario) {
         return (List<Usuario>) em.createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario).getResultList();
    }
    
}
