package uz.pdp.apprestjwtmoneytransfer.payload;

import lombok.Data;

@Data
public class TransferDto {
    private Integer fromCard;
    private Integer toCard;
    private Double amount;
}
