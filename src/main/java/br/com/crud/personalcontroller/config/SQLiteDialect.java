package br.com.crud.personalcontroller.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.pagination.LimitLimitHandler;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect(DialectResolutionInfo info) {
        super(info);
    }

    @Override
    public LimitHandler getLimitHandler() {
        return LimitLimitHandler.INSTANCE;
    }
}