package tp.spring.boot.piedvdari.service;

import java.util.List;

import tp.spring.boot.piedvdari.entities.Claim;

public interface IClaimService {
	
	public Claim addClaim(int costumer_id,int ads_id,Claim c);
	//public Claim addClaim2(Claim c);
	public void deleteClaim(int id );
	public List<Claim> findAllClaims();
	public Claim updateClaim(Claim claim);
	public List<Claim>getAllClaimByCostumerId(int id);
	public void deleteAllClaim();
}
