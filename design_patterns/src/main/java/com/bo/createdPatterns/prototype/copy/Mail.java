package com.bo.createdPatterns.prototype.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    private String receiver;
    private String subject;
    private String appellation;
    private String contxt;
    private String tail;

    public Mail(AdvTemplate advTemplate){
        this.contxt=advTemplate.getAdvContext();
        this.subject=advTemplate.getAdvSubject();
    }
}
