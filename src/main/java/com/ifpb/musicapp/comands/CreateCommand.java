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
public class CreateCommand implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        Estilo estilo = Estilo.valueOf(req.getParameter("estilo"));
        int idBanda = Integer.valueOf(req.getParameter("banda"));
        String lancamento = req.getParameter("lancamento");
        BandaDao bandaDao = new BandaDao();
        Banda banda = bandaDao.getBanda(idBanda);
        Album novo = new Album(estilo, banda, LocalDate.parse(lancamento));
        AlbumDao dao = new AlbumDao();
        dao.create(novo);
        res.sendRedirect("index.jsp");
    }
    
}
