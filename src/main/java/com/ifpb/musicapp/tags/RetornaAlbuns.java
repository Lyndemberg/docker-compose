package com.ifpb.musicapp.tags;

import com.ifpb.musicapp.dao.AlbumDao;
import com.ifpb.musicapp.model.Album;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author lyndemberg
 */
public class RetornaAlbuns extends SimpleTagSupport{
    @Override
    public void doTag(){
        AlbumDao dao = new AlbumDao();
        List<Album> albuns = dao.getAll();
        getJspContext().setAttribute("albuns", albuns);
    }
}
