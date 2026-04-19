package dev.rynwllngtn.agorasocial.exceptions;

import java.time.Instant;
import java.util.Map;

public record ValidationError(
        Instant timestamp,
        Integer status,
        Map<String, String> errors,
        String path
) {}