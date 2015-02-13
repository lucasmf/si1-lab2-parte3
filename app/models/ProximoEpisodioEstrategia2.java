package models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by lucas on 2/13/15.
 */
@Entity(name="ProximoEpisodioEstrategia2")
public class ProximoEpisodioEstrategia2 extends EstrategiaProximoEpisodio {


    public ProximoEpisodioEstrategia2(Serie serie) {
        this.serie = serie;
    }

    public ProximoEpisodioEstrategia2() {
    }

    @Override
    Episodio getProximoEpisodio(int temporada) {
        List<Episodio> eps = super.serie.getEpisodios(temporada);
        int i = eps.size()-1;
        int index = -1;
        while (i >= 0) {
            if (!eps.get(i).isAssistido()) {
                index = i;
            }
            i--;
        }
        if(index == -1) {
            return null;
        }
        return eps.get(index);
    }
}
