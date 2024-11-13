package org.marouanedbibih.soap_p.compte;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;

@Component
@WebService(serviceName = "BankWS")
@AllArgsConstructor
public class CompteServiceSOAP {

    private final CompteRepository compteRepository;

    @WebMethod
    public List<Compte> fetchComptes() {
        return compteRepository.findAll();
    }

    @WebMethod
    public Compte findCompteById(@WebParam(name = "id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    @WebMethod
    public Compte createCompte(@WebParam(name = "amount") Double amount, @WebParam(name = "type") TypeCompte type) {
        Compte compte = new Compte(null, amount, new Date(), type);
        return compteRepository.save(compte);
    }

    @WebMethod
    public Compte updateCompte(@WebParam(name = "id") Long id, @WebParam(name = "amount") Double amount,
            @WebParam(name = "type") TypeCompte type) {
        Compte compte = compteRepository.findById(id).orElse(null);
        if (compte != null) {
            compte.setAmount(amount);
            compte.setType(type);
            return compteRepository.save(compte);
        }
        return null;
    }

    @WebMethod
    public void deleteCompte(@WebParam(name = "id") Long id) {
        if (compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
        }
    }

}
