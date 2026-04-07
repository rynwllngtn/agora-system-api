package dev.rynwllngtn.agorasystem.dtos.account;

import java.math.BigDecimal;

public record AccountUpdateRequestDTO(
        BigDecimal balance,
        BigDecimal transferLimit,
        BigDecimal transferLimitCap
) {}