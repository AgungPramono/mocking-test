package com.agung.unittest.mocking.mandatory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class MandatoryParameterHelper {

    public static MandatoryParameter getMandatoryParameter(HttpServletRequest request){
        MandatoryParameter parameter = new MandatoryParameter();
        parameter.setRequestId(request.getParameter("requestId"));
        parameter.setUsername(request.getParameter("username"));
        return parameter;
    }

    public static List<MandatoryParameter> getAllMandatory(){
        List<MandatoryParameter> list = new ArrayList<>();
        list.add(new MandatoryParameter("001","Agung"));
        list.add(new MandatoryParameter("002","Hendi"));

        return list;
    }
}
