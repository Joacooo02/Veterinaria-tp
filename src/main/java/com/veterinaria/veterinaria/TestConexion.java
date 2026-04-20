package com.veterinaria.veterinaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class TestConexion implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🔥 Probando conexión...");
        dataSource.getConnection();
        System.out.println("✅ Conectado a MySQL correctamente");
    }
}
