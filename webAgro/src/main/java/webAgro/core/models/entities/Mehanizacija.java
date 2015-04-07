package webAgro.core.models.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Mehanizacija")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="meh_type", discriminatorType=DiscriminatorType.STRING, length=1)
@DiscriminatorValue(value="M")
public class Mehanizacija {
	
	@Id
	@GeneratedValue
	private Long mhzId;
	private int godiste;
	@ManyToOne
	@JoinColumn(name="polj_gazd_id")
	private PoljoprivrednoGazdinstvo poljoprivrednoGazdinstvo;
	
	
	public int getGodiste() {
		return godiste;
	}
	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}
	
	public Long getMhzId() {
		return mhzId;
	}
	public void setMhzId(Long mhzId) {
		this.mhzId = mhzId;
	}
	public PoljoprivrednoGazdinstvo getPoljoprivrednoGazdinstvo() {
		return poljoprivrednoGazdinstvo;
	}
	public void setPoljoprivrednoGazdinstvo(
			PoljoprivrednoGazdinstvo poljoprivrednoGazdinstvo) {
		this.poljoprivrednoGazdinstvo = poljoprivrednoGazdinstvo;
	}
	

}
