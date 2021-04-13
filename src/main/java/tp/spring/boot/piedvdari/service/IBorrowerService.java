package tp.spring.boot.piedvdari.service;

import java.util.List;

import tp.spring.boot.piedvdari.entities.Borrower;



public interface IBorrowerService {
	public void ajouterBorrower(Borrower b);
	public void deleteBorrower(int id);
	public Borrower updateBorrower(Borrower b);
	public Borrower retrieveBorrower(int id);
	public List<Borrower> retrieveAllBorrower();
	public float capaciteEmprunt(int idBorrower,int idBank,int periode);
	//public float capaciteEmprunt15(int salaire,int idBank);


}
