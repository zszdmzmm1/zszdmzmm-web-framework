package com.aue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CustomImportSelector.class)
public class ImportSelectorConfig {
}
