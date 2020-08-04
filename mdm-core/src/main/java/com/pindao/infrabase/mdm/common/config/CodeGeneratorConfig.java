package com.pindao.infrabase.mdm.common.config;

import com.pindao.infrabase.mdm.common.utils.CodeGenerator;
import com.pindao.infrabase.mdm.common.utils.DefaultCodeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeGeneratorConfig {

    @Bean
    public CodeGenerator entrantContractCodeGenerator() {
        return new DefaultCodeGenerator("EC", 1);
    }
}
