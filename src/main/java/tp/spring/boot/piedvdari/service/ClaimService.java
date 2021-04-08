package tp.spring.boot.piedvdari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.Ads;
import tp.spring.boot.piedvdari.entities.Claim;
import tp.spring.boot.piedvdari.entities.Costumer;
import tp.spring.boot.piedvdari.repository.IAdsRepository;
import tp.spring.boot.piedvdari.repository.IClaimRepository;
import tp.spring.boot.piedvdari.repository.ICostmerRepository;

@Service
public class ClaimService implements IClaimService {
	
	@Autowired
	public IClaimRepository claimRepository;
	
	@Autowired
	public ICostmerRepository costmerRepository;
	@Autowired
	public IAdsRepository adsRepository;

	@Override
	public Claim addClaim(int costumer_id, int ads_id,Claim c) {
		Ads a= adsRepository.findById(ads_id).orElse(null);
		Costumer cos= costmerRepository.findById(costumer_id).orElse(null);
		c.setCostumer(cos);
		a.setNum_Claim(a.getNum_Claim()+1);
		c.setAds(a);
		adsRepository.save(a);
		return 	claimRepository.save(c);
	}

	@Override
	public void  deleteClaim(int id) {
		 claimRepository.deleteById(id);
		// Claim c= claimRepository.findById(id).orElse(null);
		 
	}

	@Override
	public List<Claim> findAllClaims() {
		return	claimRepository.findAll();
 
	}

	@Override
	public Claim updateClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	@Override
	public List<Claim> getAllClaimByCostumerId(int id) {
		List<Claim> listClaims= costmerRepository.findById(id).orElse(null).getListclaim();
		return listClaims;
	}

	@Override
	public void deleteAllClaim() {
		claimRepository.deleteAll();
		
	}

	
	

}
