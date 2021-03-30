package tp.spring.boot.piedvdari.service;

import tp.spring.boot.piedvdari.entities.Claim;

public interface IClaimService {
	
	public Claim addClaim(int costumer_id,int ads_id,Claim c);
	public Claim addClaim2(Claim c);
}
