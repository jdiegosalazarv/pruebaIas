package co.com.ias.pruebaias.infrastructure.driven_adapters.database.config;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class PostgresqlConnectionPool {

    private static final int MAX_SIZE = 10;
    private static final int MIN_SIZE = 5;
    private static final int MAX_IDLE_TIME = 30;

    @Bean
    public ConnectionPool getConnectionPool() {
        var dbProperties = PostgresqlConnectionProperties.builder()
                .host("postgres")
//                .host("localhost")
                .port(5432)
                .database("ias")
                .user("postgres")
                .password("postgres")
                .schema("public")
                .build();

        return buildConnectionPool(dbProperties);
    }

    private ConnectionPool buildConnectionPool(PostgresqlConnectionProperties properties) {
        var dbConfiguration = PostgresqlConnectionConfiguration.builder()
                .host(properties.getHost())
                .port(properties.getPort())
                .database(properties.getDatabase())
                .username(properties.getUser())
                .password(properties.getPassword())
                .schema(properties.getSchema())
                .build();

        var connectionPool = ConnectionPoolConfiguration.builder()
                .connectionFactory(new PostgresqlConnectionFactory(dbConfiguration))
                .name("ias-pool")
                .maxSize(MAX_SIZE)
                .initialSize(MIN_SIZE)
                .maxIdleTime(Duration.ofMinutes(MAX_IDLE_TIME))
                .validationQuery("SELECT 1")
                .build();

        return new ConnectionPool(connectionPool);
    }
}
