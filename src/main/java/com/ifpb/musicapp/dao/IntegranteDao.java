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
public class IntegranteDao {
    private Connection con;
    private void initConexao(){
        try {
            con = com.ifpb.musicapp.util.Conexao.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<String> getIntegrantesBanda(int banda){
        List<String> integrantes = new ArrayList<>();
        try {
            initConexao();
            PreparedStatement st = con.prepareStatement("SELECT * FROM integrante WHERE banda=?");
            st.setInt(1, banda);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                integrantes.add(rs.getString("nome"));
            }
            rs.close();
            st.close();
            closeConexao();
        } catch (SQLException ex) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return integrantes;
    }
    private void closeConexao(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
