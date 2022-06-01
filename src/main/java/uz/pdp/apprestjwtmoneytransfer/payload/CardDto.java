package uz.pdp.apprestjwtmoneytransfer.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CardDto {

    @NotNull
    @Size(min = 16, max = 16)
    private String number;

    private Double balance;
}
