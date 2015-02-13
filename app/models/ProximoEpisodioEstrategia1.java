package models;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by lucas on 2/13/15.
 */
@Entity(name="ProximoEpisodioEstrategia1")
public class ProximoEpisodioEstrategia1 extends EstrategiaProximoEpisodio {

    public ProximoEpisodioEstrategia1(Serie serie) {
        super.serie = serie;
    }

    public ProximoEpisodioEstrategia1() {
    }

    @Override
    Episodio getProximoEpisodio(int temporada) {
        List<Episodio> eps = super.serie.getEpisodios(temporada);
        int i = 0;
        int index = -1;
        while (i < eps.size()) {
            if(eps.get(i).isAssistido()) {
                index = i;
            }
            i++;
        }
        if(index == i-1) {
            return null;
        }
        if(index == -1) {
            return eps.get(0);
        }
        return eps.get(index+1);
    }
}
