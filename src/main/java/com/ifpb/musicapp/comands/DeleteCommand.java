package com.ifpb.musicapp.comands;

import com.ifpb.musicapp.dao.AlbumDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lyndemberg
 */
public class DeleteCommand implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        AlbumDao dao = new AlbumDao();
        dao.delete(id);
        res.sendRedirect("index.jsp");
    }
    
}
