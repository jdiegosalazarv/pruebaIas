package co.com.ias.pruebaias.infrastructure.driven_adapters.database.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostgresqlConnectionProperties {

    private String host;
    private int port;
    private String database;
    private String user;
    private String password;
    private String schema;
}
