package com.softserve.librarymanager.db.builder;

public abstract class AbstractQueryBuilder implements QueryBuilder {
    protected static final char SPACE_CHAR = ' ';
    protected static final char COMMA_CHAR = ',';
    protected static final String EQUAL_SIGN = " = ";

    protected StringBuilder queryBuilder = new StringBuilder();

    public abstract String buildQuery();

    public AbstractQueryBuilder where() {
        queryBuilder.append(SPACE_CHAR).append("where");
        return this;
    }

    public AbstractQueryBuilder equal(String column, String value) {
        queryBuilder.append(SPACE_CHAR).append(column).append(EQUAL_SIGN).append(value);
        return this;
    }

    public AbstractQueryBuilder and() {
        queryBuilder.append(SPACE_CHAR).append("and");
        return this;
    }

}
