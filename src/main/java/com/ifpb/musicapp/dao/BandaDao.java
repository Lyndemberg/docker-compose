package com.ifpb.musicapp.dao;

import com.ifpb.musicapp.model.Banda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lyndemberg
 */
public class BandaDao {
    private Connection con;
    
    public List<Banda> getAll(){
        List<Banda> bandas = new ArrayList<>();
        try {
            initConexao();
            PreparedStatement st = con.prepareStatement("SELECT * FROM banda");
            ResultSet rs = st.executeQuery();
            IntegranteDao dao = new IntegranteDao();
            while(rs.next()){
                List<String> integrantes = dao.getIntegrantesBanda(rs.getInt("id"));
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String localOrigem = rs.getString("localorigem");
                Banda banda = new Banda(id, nome, localOrigem, integrantes);
                bandas.add(banda);
            }
            rs.close();
            st.close();
            closeConexao();
        } catch (SQLException ex) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bandas;
    }
    public Banda getBanda(int id){
        Banda banda = null;
        try {
            initConexao();
            PreparedStatement st = con.prepareStatement("SELECT * FROM banda WHERE id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            IntegranteDao dao = new IntegranteDao();
            if(rs.next()){
                List<String> integrantes = dao.getIntegrantesBanda(id);
                String nome = rs.getString("nome");
                String localOrigem = rs.getString("localorigem");
                banda = new Banda(id , nome, localOrigem, integrantes);
            }
            rs.close();
            st.close();
            closeConexao();
        } catch (SQLException ex) {
            Logger.getLogger(BandaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return banda;
    }

    private void initConexao(){
        try {
            con = com.ifpb.musicapp.util.Conexao.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    private void closeConexao(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
