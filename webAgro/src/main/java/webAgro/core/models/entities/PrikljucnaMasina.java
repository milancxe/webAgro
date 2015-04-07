package webAgro.core.models.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="prikljucnaMasina")
@DiscriminatorValue(value="M")
@PrimaryKeyJoinColumn(name="mhzId")
public class PrikljucnaMasina extends Mehanizacija {

	private String tip;
	private String napomena;
	
	@ManyToMany(mappedBy="prikljucneMasine")
	private List<Obrada> obrade;
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public List<Obrada> getObrade() {
		return obrade;
	}
	public void setObrade(List<Obrada> obrade) {
		this.obrade = obrade;
	}

	
	
}
