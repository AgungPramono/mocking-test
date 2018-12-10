package com.agung.unittest.mocking;

import com.agung.unittest.mocking.mandatory.MandatoryParameter;
import com.agung.unittest.mocking.mandatory.MandatoryParameterHelper;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MockingTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    public HttpServletRequest servletRequest;

    @InjectMocks
    public MandatoryParameterHelper mandatoryParameterHelper;

    @Test
    public void testValid() {
        when(servletRequest.getParameter("username")).thenReturn("agung");
        when(servletRequest.getParameter("requestId")).thenReturn("01");

        MandatoryParameter parameter = MandatoryParameterHelper.getMandatoryParameter(servletRequest);

        assertEquals("agung", parameter.getUsername());
        assertEquals("01", parameter.getRequestId());
    }

    @Test
    public void testGetAll() {

        List<MandatoryParameter> allMandatory = new ArrayList<>();
        allMandatory.add(new MandatoryParameter("003","ari"));
        allMandatory.add(new MandatoryParameter("004","wahyu"));

        when(mandatoryParameterHelper.getAllMandatory()).thenReturn(allMandatory);

        assertEquals(2, mandatoryParameterHelper.getAllMandatory().size());
    }
}
