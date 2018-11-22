package com.softserve.librarymanager.db.builder;

public class SelectQueryBuilder extends AbstractQueryBuilder implements QueryBuilder {
    private static final int ONE_COLUMN = 1;
    private int columnCount = ONE_COLUMN;

    public SelectQueryBuilder() {
    }

    public SelectQueryBuilder select() {
        queryBuilder.append("select");
        return this;
    }

    public SelectQueryBuilder addColumn(String column) {
        String commaOrNothing = columnCount == ONE_COLUMN ? "" : String.valueOf(COMMA_CHAR);
        queryBuilder.append(SPACE_CHAR).append(column).append(commaOrNothing);
        columnCount++;
        return this;
    }

    public SelectQueryBuilder from(String tableName) {
        queryBuilder.append(SPACE_CHAR).append("from").append(SPACE_CHAR).append(tableName);
        return this;
    }

    public SelectQueryBuilder innerJoin(String tableName) {
        queryBuilder.append(SPACE_CHAR).append("inner join").append(SPACE_CHAR).append(tableName);
        return this;
    }

    public SelectQueryBuilder on(String leftTableKey, String rightTableKey) {
        queryBuilder.append(SPACE_CHAR).append("on").append(SPACE_CHAR)
                .append(leftTableKey).append(EQUAL_SIGN).append(rightTableKey);
        return this;
    }

    @Override
    public String buildQuery() {
        return queryBuilder.toString();
    }
}
