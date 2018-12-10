package com.agung.unittest.mocking.service;

import java.util.List;

public interface MerchantRepository {

    void save(Merchant merchant);
    void delete(Merchant merchant);
    List<Merchant> getAllMerchant();
}
