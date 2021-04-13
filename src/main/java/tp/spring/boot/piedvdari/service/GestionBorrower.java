package tp.spring.boot.piedvdari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.Borrower;
import tp.spring.boot.piedvdari.repository.IBankRepository;
import tp.spring.boot.piedvdari.repository.IBorrowerRepository;

@Service
public class GestionBorrower implements IBorrowerService {
	@Autowired
	IBorrowerRepository br;
	@Autowired
	IBankRepository bkrep;
	@Autowired
	IBorrowerRepository borwrep;

	@Override
	public void ajouterBorrower(Borrower b) {
		br.save(b);
		
	}

	@Override
	public void deleteBorrower(int id) {
		br.deleteById(id);
		
	}

	@Override
	public Borrower updateBorrower(Borrower b) {
		br.save(b);
		return b ;
		
	}

	@Override
	public Borrower retrieveBorrower(int id) {
		return (br.findById(id).orElse(null));
	}

	@Override
	public List<Borrower> retrieveAllBorrower() {
		return (List<Borrower>) br.findAll();
	}

	@Override
	public float capaciteEmprunt(int idBorrower,int idBank,int periode) {
		return (float) ((borwrep.findById(idBorrower).get().getSalaire()*0.4)-((borwrep.findById(idBorrower).get().getSalaire()*0.4)*bkrep.findById(idBank).get().getTaux_int()/100))*(12*periode) ;
	}

	

}
