/*
 * This file is generated by jOOQ.
 */
package by.gsu.jooq;


import by.gsu.jooq.tables.Product;
import by.gsu.jooq.tables.records.ProductRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code></code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<ProductRecord, Integer> IDENTITY_PRODUCT = Identities0.IDENTITY_PRODUCT;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ProductRecord> PK_PRODUCT = UniqueKeys0.PK_PRODUCT;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ProductRecord, Integer> IDENTITY_PRODUCT = Internal.createIdentity(Product.PRODUCT, Product.PRODUCT.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ProductRecord> PK_PRODUCT = Internal.createUniqueKey(Product.PRODUCT, "pk_Product", Product.PRODUCT.ID);
    }
}