package com.ifpb.musicapp.dao;

import com.ifpb.musicapp.model.Album;
import com.ifpb.musicapp.model.Banda;
import com.ifpb.musicapp.model.Estilo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lyndemberg
 */
public class AlbumDao {
    private Connection con;    
    
    public boolean create(Album novo){
        try {
            initConexao();
            PreparedStatement st = con.prepareStatement("INSERT INTO album (estilo,banda,lancamento)"
                    + " VALUES (?,?,?)");
            st.setString(1, novo.getEstilo().toString());
            st.setInt(2, novo.getBanda().getId());
            st.setString(3, novo.getLancamento().toString());
            int retorno = st.executeUpdate();
            st.close();
            closeConexao();
            return retorno>0;
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean update(Album at){
        try {
            initConexao();
            PreparedStatement st = con.prepareStatement("UPDATE album SET estilo=?, banda=?,"
                    + "lancamento=? WHERE id=?");
            st.setString(1, at.getEstilo().toString());
            st.setInt(2, at.getBanda().getId());
            st.setString(3, at.getLancamento().toString());
            st.setInt(4, at.getId());
            int retorno = st.executeUpdate();
            st.close();
            closeConexao();
            return retorno>0;
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean delete(int album){
        try {
            initConexao();
            PreparedStatement st = con.prepareStatement("DELETE FROM album WHERE id=?");
            st.setInt(1, album);
            int retorno = st.executeUpdate();
            st.close();
            closeConexao();
            return retorno>0;
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<Album> getAll(){
        List<Album> albuns = new ArrayList<>();
        try {
            initConexao();
            PreparedStatement st = con.prepareStatement("SELECT * FROM album");
            ResultSet rs = st.executeQuery();
            BandaDao dao = new BandaDao();
            while(rs.next()){
                Banda b = dao.getBanda(rs.getInt("banda"));
                Estilo estilo = Estilo.valueOf(rs.getString("estilo").toUpperCase());
                //Estilo estilo = Estilo.valueOf(Estilo.class, rs.getString("estilo"));
                int id = rs.getInt("id");
                Album album = new Album(id, estilo,b,toLocalDate(rs.getString("lancamento")));
                albuns.add(album);
            }
            rs.close();
            st.close();
            closeConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return albuns;
    }
    public Album getAlbum(int id){
        Album a = null;
        try {
            initConexao();
            PreparedStatement st = con.prepareStatement("SELECT * FROM album WHERE id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                BandaDao dao = new BandaDao();
                Banda b = dao.getBanda(rs.getInt("banda"));
                a = new Album(id, Estilo.valueOf(rs.getString("estilo")), b, toLocalDate(rs.getString("lancamento")));
            }
            rs.close();
            st.close();
            closeConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
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
    
    private LocalDate toLocalDate(String data){
        DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate local = LocalDate.parse(data,formatter_1);
        return local;
    }
    
}
