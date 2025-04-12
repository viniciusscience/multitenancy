package com.tenant.resolver.provider;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.connections.spi.DatabaseConnectionInfo;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Component
public class ConnectionProvider implements MultiTenantConnectionProvider, HibernatePropertiesCustomizer {

    private final DataSource dataSource;

    public ConnectionProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Connection getAnyConnection() throws SQLException {

        return getConnection("PUBLIC");
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();

    }

    @Override
    public Connection getConnection(Object tenantIndentifier) throws SQLException {
        var connection = dataSource.getConnection();

        connection.setSchema((String) tenantIndentifier);

        return connection;
    }

    @Override
    public void releaseConnection(Object o, Connection connection) throws SQLException {
        connection.setSchema("PUBLIC");
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public DatabaseConnectionInfo getDatabaseConnectionInfo(Dialect dialect) {
        return MultiTenantConnectionProvider.super.getDatabaseConnectionInfo(dialect);
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER,this);
    }


    @Override
    public boolean isUnwrappableAs(Class< ?> unwrapType) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }
}
