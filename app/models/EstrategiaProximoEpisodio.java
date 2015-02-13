package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by lucas on 2/13/15.
 */
@Entity(name="EstrategiaProximoEpisodio")
public abstract class EstrategiaProximoEpisodio {

    @OneToOne
    protected Serie serie;

    @Id
    @GeneratedValue
    private Long id;
    abstract Episodio getProximoEpisodio(int temporada);

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Serie getSerie() {return serie;}
    public void setSerie(Serie serie) {this.serie = serie;}

}
