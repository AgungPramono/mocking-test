package com.agung.unittest.mocking;

import com.agung.unittest.mocking.service.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class StubbingTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    public MerchantRepository merchantRepository;

    @Mock
    public MerchantHistoryrepository merchantHistoryrepository;

    @InjectMocks
    public MerchantService merchantService;

    @Captor
    private ArgumentCaptor<MerchantHistory> merchantHistoryArgumentCaptor;

    @Test
    public void testSave() {
        Merchant merchant = new Merchant();
        merchant.setId("001");
        merchant.setName("Agung");

        merchantService.save(merchant);
        //verfikasi
        verify(merchantRepository).save(merchant);
    }

    @Test
    public void testDelete() {
        Merchant merchant = new Merchant();
        merchant.setId("001");
        merchant.setName("Agung");

        merchantService.delete(merchant);

        //verfikasi
        verify(merchantRepository).delete(merchant);
        verify(merchantHistoryrepository).save(merchantHistoryArgumentCaptor.capture());

        //verifikasi data capture
        MerchantHistory merchantHistory = merchantHistoryArgumentCaptor.getValue();
        Assert.assertEquals("001",merchantHistory.getId());
        Assert.assertEquals("Agung",merchantHistory.getName());
    }

    @After
    public void tearDown() throws Exception {
        verifyNoMoreInteractions(merchantRepository,merchantHistoryrepository);
    }
}
