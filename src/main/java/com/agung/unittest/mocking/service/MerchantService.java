package com.agung.unittest.mocking.service;

public class MerchantService {

    private MerchantRepository merchantRepository;
    private MerchantHistoryrepository merchantHistoryrepository;

    public void save(Merchant merchant){
        merchantRepository.save(merchant);
        //merchantRepository.save(merchant);
    }


    public void delete(Merchant merchant){
        merchantRepository.delete(merchant);

        MerchantHistory merchantHistory = new MerchantHistory();
        merchantHistory.setId(merchant.getName());
        merchantHistory.setName(merchant.getId());

        merchantHistoryrepository.save(merchantHistory);

    }

}
