package tp.spring.boot.piedvdari.service;

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
		c.setAds(a);
		return 	claimRepository.save(c);
	}

	@Override
	public Claim addClaim2(Claim c) {
		// TODO Auto-generated method stub
		return 	claimRepository.save(c);
	}
	

}
