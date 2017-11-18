package com.ifpb.musicapp.comands;

import com.ifpb.musicapp.dao.AlbumDao;
import com.ifpb.musicapp.dao.BandaDao;
import com.ifpb.musicapp.model.Album;
import com.ifpb.musicapp.model.Banda;
import com.ifpb.musicapp.model.Estilo;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author lyndemberg
 */
public class UpdateCommand implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        int idAlbum = Integer.parseInt(req.getParameter("id"));
        Estilo estilo = Estilo.valueOf(req.getParameter("estilo"));
        int idBanda = Integer.valueOf(req.getParameter("banda"));
        String lancamento = req.getParameter("lancamento");
        BandaDao bandaDao = new BandaDao();
        Banda banda = bandaDao.getBanda(idBanda);
        Album at = new Album(idAlbum, estilo, banda, LocalDate.parse(lancamento));
        AlbumDao dao = new AlbumDao();
        if(dao.update(at)){
            res.sendRedirect("index.jsp");
        }else{
            res.sendRedirect("editar.jsp?id=" + idAlbum + "&error=1");
        }
        
    }
    
}
