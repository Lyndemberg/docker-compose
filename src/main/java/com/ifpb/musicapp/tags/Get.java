package com.ifpb.musicapp.tags;

import com.ifpb.musicapp.dao.AlbumDao;
import com.ifpb.musicapp.dao.BandaDao;
import com.ifpb.musicapp.model.Album;
import com.ifpb.musicapp.model.Banda;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author lyndemberg
 */
public class Get extends SimpleTagSupport{
    public String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public void doTag(){
        if(descricao.equals("albuns")){
            AlbumDao dao = new AlbumDao();
            List<Album> albuns = dao.getAll();
            getJspContext().setAttribute("albuns", albuns);
        }
        if(descricao.equals("bandas")){
            BandaDao dao = new BandaDao();
            List<Banda> bandas = dao.getAll();
            getJspContext().setAttribute("bandas", bandas);
        }
        
    }
}
