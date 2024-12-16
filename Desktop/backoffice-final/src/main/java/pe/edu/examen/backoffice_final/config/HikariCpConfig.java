package pe.edu.examen.backoffice_final.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCpConfig {

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig config = new HikariConfig();


        config.setJdbcUrl("jdbc:mysql://localhost:3306/fabric");
        config.setUsername("root");
        config.setPassword("72488905");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        /**
         * Configurar propiedades del pool de HikariCP
         * - MaximumPoolSize: Máximo # de conexiones del pool.
         * - MinimumIdle: Mínimo # de conexiones inactivas del pool.
         * - IdleTimeout: Tiempo máximo de espera para
         *      eliminar una conexión inactiva.
         * - ConnectionTimeout: Tiempo máximo de espera
         *      para conectarse a la BD.
         */
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000);
        config.setConnectionTimeout(30000);

        System.out.println("###### HikariCP Arranco!!! ######");
        return new HikariDataSource(config);

    }

}
