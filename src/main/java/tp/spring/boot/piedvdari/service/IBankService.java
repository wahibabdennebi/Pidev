package tp.spring.boot.piedvdari.service;

import java.util.List;

import tp.spring.boot.piedvdari.entities.Bank;


public interface IBankService {
	public void ajouterBank(Bank bk);
	public void deleteBank(int id);
	public Bank updateBank(Bank b);
	public Bank retrieveBank(int id);
	public List<Bank> retrieveAllBank();
	public float Rappel(Bank bk,int idBank);
	public float mensualite(int id,int emprunt,int periode);

}
