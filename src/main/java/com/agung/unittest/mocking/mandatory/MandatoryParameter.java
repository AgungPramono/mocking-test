package com.agung.unittest.mocking.mandatory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MandatoryParameter {

    private String requestId;
    private String username;

}
